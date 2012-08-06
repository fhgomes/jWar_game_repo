package negocio.logistica.estrutura;


import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.sala.ISalaGUI;
import interfaces.negocio.IChat;

import java.util.HashMap;
import java.util.Vector;

import negocio.beans.Jogador;
import negocio.beans.jogo.JogadorDoJogo;
import negocio.repositorio.beans.JogadorRep;
import negocio.threads.FalaChatListenerThread;
import negocio.threads.ObjectProxyThread;
import exceptions.logistica.FullException;
import exceptions.logistica.JogoException;
import exceptions.logistica.SalaException;
/**
 * 
 * @author Fernando Gomes
 * <br/>
 */
public class Chat implements IChat {

	private HashMap<String,Sala> salas;
	private Servidor servidor;
	private String nome;
	
	/**
	 * 
	 * @param nome
	 * @param serv
	 */
	public Chat (String nome, Servidor serv){
		this.servidor = serv;
		this.nome = nome;
		salas = new HashMap<String, Sala>();
	}
	
	
	public String assistirSala(String nomeSala, String nomeJog) throws SalaException {
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(nomeJog);
		//SEM RESTRIÇOES
		if (salas.containsKey(nomeSala)) {
			if (salas.get(nomeSala).getJogoDaSala() == null)
				throw new SalaException("Este Jogo ainda nao começou");
			else{
				try{
					salas.get(nomeSala).assistir(j);
					return salas.get(nomeSala).getJogoDaSala().toRegistry();
				}catch(FullException fe){
					throw new SalaException("Impossivel assistir este jogo: " +fe.getMessage());
				}
				
			}
		}			
		else
			throw new SalaException("Esta sala nao existe");
		
	}
	
	@Override
	public String criarSala(String nomeSala, Integer maxJog, String nomeJog, ISalaGUI listener)throws SalaException {
		System.out.println("CRIANDO A SALA - EM CHAT_CRIAR_SALA\n--------------"+nomeSala);
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(nomeJog);
		
		//VERIFICA SE O JOGADOR ESTA BLOQUEADO
		if(jogadorBloqueado(j))
			throw new SalaException("Você esta bloqueado e nao pode realizar esta ação");
		
		//VERIFICA SE A SALA JA ESTA CRIADA
		if (salas.containsKey(nomeSala)) 
			throw new SalaException("Esta sala ja esta criada, Tente outra");
		else{
			//CRIA A SALA 
			Sala novaSala = new Sala(nomeSala, maxJog, j, this, listener);
			//REGISTRA NO SERVIDOR 
			ObjectProxyThread t = new ObjectProxyThread(novaSala, novaSala.toRegistry());
			t.start();
			while(t.isAlive()){}
			
			//ADCIONA A LISTA
			salas.put(novaSala.getNome(), novaSala);
			//AVISA A TODOS DO CHAT QUE UMA SALA FOI CRIADA!
			getServidor().avisarSalaCriada(nomeSala, maxJog);
			System.out.println("REGISTRO DA SALA->"+novaSala.toRegistry());
			return novaSala.toRegistry();
		}
				
	}
	
	@Override
	public String entrarSala(String nomeSala, String nomeJog, ISalaGUI listener)throws SalaException {
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(nomeJog);
		
		if (salas.containsKey(nomeSala)){
			//VERIFICA SE O JOGADOR ESTA BLOQUEADO
			if(jogadorBloqueado(j))
				throw new SalaException("Você esta bloqueado e nao pode realizar esta ação");
			
			//VERIFICA SE O JOGADOR ESTA NOUTRO JOGO.. E VIVO..
			if(jogadorLivre((Jogador)j)) {
				if (salas.get(nomeSala).temEspaco()){
					salas.get(nomeSala).entrar(j, listener);
					return salas.get(nomeSala).toRegistry();	
				}	
				else
					throw new SalaException("Esta sala esta cheia");
			}
			else
				throw new SalaException("Voce ja esta participando de um jogo, Volte para la.");
		}
		else
			throw new SalaException("Esta sala ainda nao foi criada");
	}
	/**
	 * Percorre todas as salas verificando se o jogador ja nao esta jogando.
	 * @param j
	 * @return
	 */
	private boolean jogadorLivre(Jogador j) {
		for(Sala s: salas.values()){
			if(s.getJogoDaSala() != null){
				for(JogadorDoJogo jdj: s.getJogoDaSala().getJogadores()){
					if (jdj.getJogador().getJogador() == j){
						if(!jdj.isMorto())
							return false;
					}
						
				}
			}
				
		}
		return true;
	}
	
	/**
	 * @param jogador
	 * @return True se o jogador estiver bloqueado. <br/>
	 * 		   False se o jogador nao estiver bloqueado.
	 */
	private boolean jogadorBloqueado(Jogador jogador) {
		boolean blk = false;
		JogadorRep jRep = new JogadorRep();
		
		jRep.comecar();
		blk = jRep.isBloqueado(jogador);
		jRep.terminar();
		
		return blk;
		
	}

	@Override
	public String reentrarSala(String nomeSala, String nomeJog) throws SalaException{
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(nomeJog);
		
		if (salas.containsKey(nomeSala))
			if (salas.get(nomeSala).getJogoDaSala() == null)
				throw new SalaException("Este Jogo ainda nao começou");
			else{
				try{
					salas.get(nomeSala).reentrar(j);
					return salas.get(nomeSala).getJogoDaSala().toRegistry();
				}catch (JogoException je) {
					throw new SalaException("Impossivel reentrar: "+je.getMessage());
				}
			}
		else
			throw new SalaException("Esta sala ainda nao foi criada");
	}
	
	@Override
	public String darOpiniao(String msg, String nomeJog) {
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(nomeJog);
		
		/* RECEBE UMA OPINIAO EH ARMAZENA NO BANCO.. */
		return "ok";
	}
	public String escrever(String msg, String nomeJog) {
		Jogador jFalando = (Jogador) ObjectProxy.resgataObjeto(nomeJog);
		Vector<Jogador> jogadores = getServidor().getJogadores();
		FalaChatListenerThread clt = new FalaChatListenerThread(jFalando, msg, jogadores);
		clt.start();
		System.out.println("PQP DE CHAT");
		return "ok";
	}

	public Servidor getServidor() {
		return this.servidor;
	}	
	
	public String getNome(){
		return this.nome;
	}
	
	public String toRegistry() {
		String reg = this.getClass().getSimpleName() + getNome();
		return reg;
	}


	public boolean sairSala(String sala, String jog) throws SalaException {
		System.out.println("Saindo da sala-> "+ sala);
		for(String s: salas.keySet()) {
			System.out.println("--"+s);
		}
		if (salas.containsKey(sala))
			if (salas.get(sala).getJogoDaSala() == null) {
				salas.get(sala).sair(jog);
				return true;
			}
			else{
				throw new SalaException("Este Jogo ja começou");
			}
		else
			throw new SalaException("Esta sala ainda nao foi criada");
	}


	public void avisarSaidaDaSala(String nomeSala) {
		getServidor().avisarSaidaDaSala(nomeSala);
	}

}
