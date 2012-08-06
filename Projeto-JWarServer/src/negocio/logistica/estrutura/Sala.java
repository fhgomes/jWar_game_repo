package negocio.logistica.estrutura;


import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.sala.ISalaGUI;
import interfaces.negocio.ISala;

import java.util.HashMap;
import java.util.Vector;

import negocio.beans.Jogador;
import negocio.beans.JogadorDaSala;
import negocio.beans.jogo.JogadorDoJogo;
import negocio.estrutura.VJogadorDaSala;
import negocio.logistica.acoes.estrutura.SalaObserve;
import negocio.repositorio.FabricaComunicacao;
import exceptions.logistica.FullException;
import exceptions.logistica.JogoException;
import exceptions.logistica.SalaException;

/** 
 * 
 * @author Fernando Gomes
 *
 */
public class Sala implements ISala{
	/** Chave cor, valor JogadorDaSala */
//	private HashMap<Integer,JogadorDaSala> jogadores = new HashMap<Integer,JogadorDaSala>(6,0);
	private HashMap<Integer,JogadorDaSala> jogadores = new HashMap<Integer,JogadorDaSala>();	
	/** Aquele que pode iniciar o jogo */
	private Jogador responsavel;
	
	private String nome;
	private Chat chat;
	private Integer maxJogadores;
	
	/**Jogo da sala. Se estiver null o jogo ainda nao foi iniciado. */
	private Jogo jogoDaSala;
//	private String banner;
	
	
	public Sala(String nomeSala,Integer maxJog, Jogador responsavel, Chat chat, ISalaGUI salaListener) throws SalaException {
		if (maxJog > 6 || maxJog < 2) 
			throw new SalaException("Numero de jogadores nao permitido");
		this.maxJogadores = maxJog;
		setChat(chat);
		setResponsavel(responsavel);
		JogadorDaSala jds = new JogadorDaSala(responsavel);
		jds.setCor(getNextCor());
		jds.setSalaListener(salaListener);
		setNome(nomeSala);
		this.jogadores.put(jds.getCor(), jds);
		//AVISA ENTRADA
		avisarEntrada(jds);
	}
	
	@Override
	public void acionarBanner(String jog) {
		Jogador jogador = (Jogador) ObjectProxy.resgataObjeto(jog);
		for (JogadorDaSala j: jogadores.values()){
			if (j.getJogador() == (Jogador) jogador)
				j.addBonus(chat.getServidor().getBonus());
		}
	}
	
	@Override
	public void escrever(String jog, String texto) {
		Jogador jogador = (Jogador) ObjectProxy.resgataObjeto(jog);
		for(JogadorDaSala jds: jogadores.values()) {				
			SalaObserve so = FabricaComunicacao.getFabricaListener(jds.getJogador().getTipoConexao()).getSalaObserve(jds);		
			so.alguemFalou("->"+jogador.getNickname(), texto);
		}
	}
	
	@Override
	public boolean inicar() {
		Vector<JogadorDoJogo> jogadoresDoJogo = new Vector<JogadorDoJogo>(6,0);
		
		for (JogadorDaSala j: jogadores.values()){
			if (j.isPronto()) {
				JogadorDoJogo jdj = new JogadorDoJogo(j);
				jogadoresDoJogo.add(jdj);				
			}
			else return false;
		}
		
		this.jogoDaSala = new Jogo(jogadoresDoJogo);
		return true;
	}
	
	@Override
	public boolean mudarDeCor(String jog, int cor) {
		Jogador jogador = (Jogador) ObjectProxy.resgataObjeto(jog);
		// se nao tem ninguem na cor ...
		if (jogadores.get(new Integer(cor)) == null){
			for (JogadorDaSala j: jogadores.values()){
				if (j.getJogador() == (Jogador) jogador){
					jogadores.remove(j);
					jogadores.put(new Integer(cor),j );
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public void sair(String jog) {
		Jogador jogador = (Jogador) ObjectProxy.resgataObjeto(jog);
		for (JogadorDaSala j: jogadores.values()){
			if (j.getJogador() == (Jogador) jogador)
				jogadores.remove(j);
		}
		if (this.responsavel == (Jogador)jogador)
			this.responsavel = null;
		getChat().avisarSaidaDaSala(this.getNome());
		
	}
	
	public Vector<JogadorDaSala> getJogadores() {
		return new Vector<JogadorDaSala>(jogadores.values());
	}
	
	public Jogador getResponsavel() {
		return responsavel;
	}
	
	private void setResponsavel(Jogador responsavel) {
		this.responsavel = responsavel;
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public Chat getChat() {
		return chat;
	}
	
	private void setChat(Chat c) {
		this.chat = c;
	}
	 /** 
	  * Adciona o Jogador na sala
	  * @param j
	  */
	public void entrar(Jogador j, ISalaGUI listener){
		
		if(temEspaco()) {
			JogadorDaSala jds = new JogadorDaSala(j);
			jds.setSalaListener(listener);
			int cor= getNextCor();
			jds.setCor(cor);
			jogadores.put(new Integer(cor),jds);
		
			if (this.responsavel == null)
				responsavel = j;
			
			//AVISA ENTRADA
			avisarEntrada(jds);	
		}
			
	}
	
	private void avisarEntrada(JogadorDaSala jds) {
		//MOSTRA PRA MIN TODOS Q ESTAO CONECTADOS
		for(JogadorDaSala jogador: jogadores.values()) {
			SalaObserve so = FabricaComunicacao.getFabricaListener(jds.getJogador().getTipoConexao()).getSalaObserve(jds);
			VJogadorDaSala vjog = new VJogadorDaSala(jogador.getJogador().getNickname(), jogador.getCor());
			so.alguemEntrou(vjog);
		}
		
		// MOSTRO A TODOS Q EU CONECTEI
		for(JogadorDaSala jogador: jogadores.values()) {
			SalaObserve so = FabricaComunicacao.getFabricaListener(jogador.getJogador().getTipoConexao()).getSalaObserve(jogador);
			VJogadorDaSala vjog = new VJogadorDaSala(jds.getJogador().getNickname(), jds.getCor());
			so.alguemEntrou(vjog);
		}
	}
	
	/**
	 * Verifica se a Sala nao esta cheia
	 * @return
	 */
	public boolean temEspaco() {
		if (jogadores.size() == maxJogadores)
			return false;
		else
			return true;
		
	}
	/**
	 * Verfica qual a proxima cor vaga
	 * @return
	 */
	private Integer getNextCor(){
		if (jogadores.get(new Integer(JogadorDaSala.amarelo)) == null)
			return JogadorDaSala.amarelo;
		else
			if (jogadores.get(new Integer(JogadorDaSala.azul)) == null)
				return JogadorDaSala.azul;
			else
				if (jogadores.get(new Integer(JogadorDaSala.branco)) == null)
					return JogadorDaSala.branco;
				else
					if (jogadores.get(new Integer(JogadorDaSala.preto)) == null)
						return JogadorDaSala.preto;
					else
						if (jogadores.get(new Integer(JogadorDaSala.verde)) == null)
							return JogadorDaSala.verde;
						else
							return JogadorDaSala.vermelho;
	}

	public Jogo getJogoDaSala() {
		return jogoDaSala;
	}

	public void assistir(Jogador j) throws FullException {
		getJogoDaSala().adcionarEspectador(j);
	}

	public void reentrar(Jogador j) throws JogoException {
		getJogoDaSala().reentrar(j);
	}

	public String toRegistry() {
		String reg = this.getClass().getSimpleName()+"-"+getChat().getNome();
		return reg;
	}
	
}
