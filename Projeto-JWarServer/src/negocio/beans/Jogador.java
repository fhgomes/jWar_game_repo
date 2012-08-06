package negocio.beans;


import interfaces.gui.estrutura.chat.IChatGUI;
import interfaces.negocio.IJogador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.hibernate.annotations.Type;


/**
 * @author Fernando Gomes
 * <br/>
 * 
 * Existem Jogador, JogadorDaSala, JogadorDoJogo.
 * Sao objetos diferentes que podem existir.
 * JogadorDaSala tem um atributo Jogador dentro de si.
 * JogadorDoJogo tem um atributo JogadorDaSala.
 * 
 * Um Jogador que inicia um Jogo , tem um JogadorDoJogo.
 * Um Jogador é unico, mas pode-se ter dois JogadorDoJogo com o mesmo Jogador.
 * 
 */
@Entity
@Table(name="TB_JOGADOR")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Jogador extends Usuario implements IJogador{
	
	//CONEXAO
	public static final int CONEXAO_RMI = 0;
	public static final int CONEXAO_XML = 1;
	
	@Column
	private Integer pontos;
	@Column
	@Type(type="org.hibernate.type.YesNoType")
	private boolean bloqueado;
	
	/** flag que diz se a instancia cliente do jogador esta respondendo ou nao */
	@Transient
	private boolean conectado;
	
	/** Tipo de conexao do cliente */
	@Transient
	private int tipoConexao;
	
	/** Interface para integraçao de chats  */
	@Transient
	private IChatGUI chatListener;
	
	/** Referencia para meu cliente XML-RPC que inicialmente vou deichar aki!! */
	@Transient
	private XmlRpcClient referencia;
	
	
	public Jogador(){
		
	}
	
	public Jogador(Jogador j) {
		this(j.getNome(), j.getNickname(), j.getEmail(), j.pontos);
	}

	public Jogador(String nome, String nickName, String email,
			Integer pontos) {
		super();
		setNickname(nickName);
		setNome(nome);
		setEmail(email);
		this.pontos = pontos;
	}

	public Jogador(String nome, String nickName, String email, String senha) {

		setNickname(nickName);
		setNome(nome);
		setEmail(email);
		setSenha(senha);
	}
	
	public Jogador(Integer cod) {
		setId(new Long(cod));
	}

	public Jogador(Integer id, String nome, String nick, String email,
			String senha) {
		setId(new Long(id));
		setNickname(nick);
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String toRegistry() {
		String reg = getNome() + getEmail() + getId();
		return reg;
	}

	public IChatGUI getChatListener() {
		return chatListener;
	}

	public void setChatListener(IChatGUI chatListener) {
		this.chatListener = chatListener;
	}

	public boolean isConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

	public int getTipoConexao() {
		return tipoConexao;
	}

	public void setTipoConexao(int tipoConexao) {
		this.tipoConexao = tipoConexao;
	}

	public XmlRpcClient getReferencia() {
		return referencia;
	}

	public void setReferencia(XmlRpcClient referencia) {
		this.referencia = referencia;
	}
	
	

}
