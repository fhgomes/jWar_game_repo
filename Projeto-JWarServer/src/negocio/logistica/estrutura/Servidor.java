package negocio.logistica.estrutura;


import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.chat.IChatGUI;
import interfaces.gui.estrutura.chat.rmi.IChatGUIRmi;
import interfaces.gui.estrutura.chat.xml.IChatGUIXml;
import interfaces.negocio.IServidor;

import java.rmi.RemoteException;
import java.util.Vector;

import negocio.beans.Jogador;
import negocio.estrutura.VUsuario;
import negocio.interfaces.estrutura.FabricaListener;
import negocio.logistica.acoes.estrutura.ChatObserve;
import negocio.repositorio.FabricaComunicacao;
import negocio.repositorio.beans.JogadorRep;
import negocio.threads.ObjectProxyThread;
import negocio.util.VetorJogadorConectado;
import exceptions.infraestrutura.LoginException;

public class Servidor implements IServidor {

	/** Nome do servidor */
	private String nome;
	/** Nivel de Pontuaçao por partida */
	private Integer pontuacao;
	/** Quantidade de bonus adcional por partida */
	private Integer bonus;
	/** Armazena todos os jogadores que ja se conectaram ao servidor 
	 * Seu iterator retorna um iterator de jogadores conectados **/
	private Vector<Jogador> jogadoresConectados = new VetorJogadorConectado();
	/** Chat onde os jogadores estarao interligados */
	private Chat chat;
	
	/**
	 * Instancia do servidor 
	 * <br/>
	 * Instancia o chat de interaçao dos jogadores
	 * 
	 * @param nome
	 * @param pont Nivel de pontuaçao
	 * @param bonus Bonus por Partida
	 * @throws RemoteException 
	 */
	public Servidor(String nome, Integer pont, Integer bonus) throws RemoteException {
		this.nome = nome;
		this.pontuacao = pont;
		this.bonus = bonus;
		this.chat = new Chat("ChatServer-"+this.nome, this);
		ObjectProxy.registraObjeto(chat, chat.toRegistry());
		System.out.println("SERVIDOR: "+getNome() +"- CONECTADOS"+jogadoresConectados.size());
		
	}
	
	public String login(String email, String senha, int tipo) throws LoginException {
		JogadorRep jRep = new JogadorRep();
		jRep.comecar();
		Jogador logado = jRep.logar(email, senha);
		jRep.terminar();
		
		System.out.println("LOGADO:"+logado.getNickname());

		ObjectProxyThread t = new ObjectProxyThread(logado, logado.toRegistry());
		t.start();
		while(t.isAlive()){}
		if(!jogadorAlcancado(logado.toRegistry())) {
			logado.setTipoConexao(tipo);
			logado.setConectado(true);
				
			this.jogadoresConectados.add(logado);
			System.out.println("SERVIDOR: "+getNome() +"- CONECTADOS"+jogadoresConectados.size());
			return logado.toRegistry();
		}else {
			throw new LoginException("Jogador ja está conectado");
		}
	}
	
	
	/** 
	 * verifico se o jogador q ainda esta no registro, ainda esta conectado..
	 * um jogador nao pode estar com duas conexoes abertas <br/>
	 * 
	 * false para desconectado  <br/>
	 * true para conectado <br/>
	 */
	private boolean jogadorAlcancado(String rJogador) {
		System.out.println("Jogador Alcançado ENTRANDO");
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(rJogador);
		if(j.isConectado()){
			System.out.println("Jogador esta conectado");
			if(j.getTipoConexao() == Jogador.CONEXAO_RMI) {
				System.out.println("Conexao RMI");
				try {
					((IChatGUIRmi)j.getChatListener()).testeConexao();
					System.out.println("Jogador alcançado");
				} catch (RemoteException e) {
					System.out.println("Cliente nao alcançado");
					j.setConectado(false);
				} catch (Exception eGeral) {
					eGeral.printStackTrace();
					System.out.println("ERRO GERAL");
					j.setConectado(false);
				}
			}else{
				if(j.getTipoConexao() == Jogador.CONEXAO_XML) {
					System.out.println("Conexao XML");
					try {
						((IChatGUIXml)j.getChatListener()).testeConexao();
						System.out.println("Jogador alcançado");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("ERRO GERAL");
						j.setConectado(false);
					}
				}
			}
		}
		return j.isConectado();
	}
	
	public String connect(String jogador , IChatGUI listener) {
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(jogador);
		
		if(jogadoresConectados.contains(j)) {
			j.setChatListener(listener);
			refreshChat(j, j.getTipoConexao());
			refreshChatJogadoresConectados(j, j.getTipoConexao());
			return this.chat.toRegistry();
		}
		else
			return "";
	}
		
	
	/**
	 * Envia as mensagem de boas vindas aos usuarios que se conectam
	 * @param j
	 * @param tipo
	 * @throws RemoteException
	 */
	private void refreshChat(Jogador j, int tipo) {
		FabricaListener fl = FabricaComunicacao.getFabricaListener(tipo);
		ChatObserve co = fl.getChatObserve(j);
		co.alguemFalou("-> Servidor JWar", "");
		co.alguemFalou("-> Servidor JWar", "BEM VINDO AO SERVIDOR : " + getNome());
		co.alguemFalou("-> Servidor JWar", "Pontuação: " + getPontuacao());
		co.alguemFalou("-> Servidor JWar", "Bonus: " +getBonus());
		co.alguemFalou("-> Servidor JWar", "Bom Jogo e Boa Sorte");
		co.alguemFalou("-> Servidor JWar", "");
		
	}
	
	private void refreshChatJogadoresConectados(Jogador j, int tipo) {
		//AVISO A MIN MESMO QUE TODO MUNDO CONECTOU
		for(Jogador jog:jogadoresConectados) {
			System.out.println("um cara conectado" +jog.getNickname());
			VUsuario vUsuario = new VUsuario();
			vUsuario.setInsignia("SOLDADO");
			vUsuario.setNickName(jog.getNickname());
			vUsuario.setPontos(jog.getPontos());
			ChatObserve co = FabricaComunicacao.getFabricaListener(tipo).getChatObserve(j);
			co.alguemEntrou(vUsuario);
		}
		
		//AVISO A TODOS Q EU CONECTEI
		for(Jogador jog:jogadoresConectados) {
			if(jog != j) {
				VUsuario vUsuario = new VUsuario();
				vUsuario.setInsignia("SOLDADO");
				vUsuario.setNickName(j.getNickname());
				vUsuario.setPontos(j.getPontos());
				ChatObserve co = FabricaComunicacao.getFabricaListener(jog.getTipoConexao()).getChatObserve(jog);
				co.alguemEntrou(vUsuario);
			}
		}
			
	}
	
	public Integer getBonus() {
		return this.bonus;
	}
	public Integer getPontuacao(){
		return this.pontuacao;
	}
	public String getNome(){
		return this.nome;
	}

	public String toRegistry() {
		String reg = this.getClass().getSimpleName() + getNome() + getPontuacao();
		return reg;
	}
	
	public Vector<Jogador> getJogadores() {
		return this.jogadoresConectados;
	}

	/** Método percorre os jogadores conectados no chat do servidor. e avisa ao chatListener
	 * que uma sala nova foi criada 
	 * 
	 * @param nomeSala
	 * @param maxJog
	 */
	public void avisarSalaCriada(String nomeSala, Integer maxJog) {
		for(Jogador jog:jogadoresConectados) {
			ChatObserve co = FabricaComunicacao.getFabricaListener(jog.getTipoConexao()).getChatObserve(jog);
			co.salaCriada(nomeSala, maxJog);	
		
		}
		
	}

	public void avisarSaidaDaSala(String nomeSala) {
		for(Jogador jog:jogadoresConectados) {
			ChatObserve co = FabricaComunicacao.getFabricaListener(jog.getTipoConexao()).getChatObserve(jog);
			co.saidaSala(nomeSala);		
		}
	}
}
