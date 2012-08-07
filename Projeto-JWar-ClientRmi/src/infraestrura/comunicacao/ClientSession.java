package infraestrura.comunicacao;

import interfaces.comunicacao.IJWarServerRmi;
import interfaces.negocio.IChatRmi;
import interfaces.negocio.ISalaRmi;
import interfaces.negocio.IServidorRmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/** Esta classe em seu método getServidorPrincipal implementa a
 * funcionalidade de cliente RMI.
 * 
 * @author Fernando
 *
 */
public class ClientSession {
	
	private static final int PORT_RMI = 15180;
	private static final String IP_SERVIDOR = "localhost";
		
	private static ClientSession  session= null;
	private IJWarServerRmi serverPrincipal = null;
	private IServidorRmi servidorJogo = null;
	private String nomeServidor;
	private String jogador = null;
	private IChatRmi chat = null;
	private String chatName;
	private ISalaRmi sala = null;
	private String salaName;
	private Registry rServidor;
	private Registry rCliente;
	
	public Registry getRCliente() {
		return rCliente;
	}

	public void setRCliente(Registry cliente) {
		rCliente = cliente;
	}

	private ClientSession() {
		try {
			rCliente = LocateRegistry.createRegistry(PORT_RMI);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/** Implementação de Singlenton */
	public static ClientSession getSession() {
		if (session == null) {
			session = new ClientSession();
		}
		return session;
	}
	
	public IJWarServerRmi getServerPrincipal() throws RemoteException, NotBoundException {
		if(serverPrincipal == null){
			rServidor = LocateRegistry.getRegistry(IP_SERVIDOR, 20090);
			//rServidor = LocateRegistry.getRegistry("localhost", 2009);
			serverPrincipal = (IJWarServerRmi)rServidor.lookup("JWarServerRmi");
		}
		return this.serverPrincipal;
	}

	public void setServidor(IServidorRmi s) {
		servidorJogo = s;
	}

	public IServidorRmi getServidorJogo() {
		return this.servidorJogo;
	}

	public void setJogador(String logado) {
		this.jogador = logado;		
	}
	
	public String getJogador() {
		return this.jogador;
	}

	public void setChat(IChatRmi connect) {
		this.chat = connect;
	}
	
	public IChatRmi getChat() {
		return this.chat;
	}
	
	public void setSala(ISalaRmi connect) {
		this.sala = connect;
	}
	
	public ISalaRmi getSala() {
		return this.sala;
	}

	public Registry getRServidor() {
		return rServidor;
	}

	public void setRServidor(Registry r) {
		this.rServidor = r;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public String getSalaName() {
		return salaName;
	}

	public void setSalaName(String salaName) {
		this.salaName = salaName;
	}
	
}
