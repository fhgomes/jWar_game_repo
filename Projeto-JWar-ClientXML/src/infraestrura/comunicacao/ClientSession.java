package infraestrura.comunicacao;

import gui.listeners.ChatGUIXml;
import gui.listeners.SalaGUIXml;
import interfaces.comunicacao.IJWarServerXml;
import interfaces.gui.estrutura.chat.xml.IChatGUIXml;
import interfaces.gui.estrutura.sala.xml.ISalaGuiXml;
import interfaces.negocio.IChatXml;
import interfaces.negocio.ISalaXml;
import interfaces.negocio.IServidorXml;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

/** Esta classe em seu método getServidorPrincipal implementa a
 * funcionalidade de cliente RMI.
 * 
 * @author Fernando
 *
 */
public class ClientSession {
	//ATRIBUTOS DE CLASSE
	private static final int PORT_XML_SERVIDOR = 34340;
	public static final int PORT_XML_MY_SERVER= 34350;
	private static final String IP_SERVIDOR = "201.24.204.40";
	
	private static ClientSession  session= null;
	
	//ATRIBUTOS DE OBJETO
	/** referencia ao server principal */
	private XmlRpcClient servidorPrincipal = null;
	
	
	private IJWarServerXml serverXml = null;
	private IServidorXml servidorJogo = null;
	private IChatXml chat = null;
	private ISalaXml sala = null;
	
	/** meu WebServer, por onde serei chamado quando houver resposta */
	private WebServer myWebServer = null;
	
	
	private String nomeServidorJogo = null;
	private String jogador = null;
	private String nomeChat = null;
	private String nomeSala = null;
	
	/** Crio um clientSession, starto meu servidor web do cliente */
	private ClientSession() {
		try {
			
			System.out.println("COMEÇANDO A ESTARTAR O SERVIDOR...");
			
			myWebServer = new WebServer(PORT_XML_MY_SERVER);
			
			XmlRpcServer xmlRpcServer = myWebServer.getXmlRpcServer();
			PropertyHandlerMapping phm = new PropertyHandlerMapping();
			phm.addHandler(IChatGUIXml.class.getName(), ChatGUIXml.class);
			phm.addHandler(ISalaGuiXml.class.getName(), SalaGUIXml.class);
			xmlRpcServer.setHandlerMapping(phm);
			
			XmlRpcServerConfigImpl config = new XmlRpcServerConfigImpl();
			config.setEnabledForExceptions(true);
			config.setEnabledForExtensions(true);
			
			myWebServer.start();
			
			System.out.println("SERVIDOR XML ESTARTADO COM SUCESSO");
			System.out.println("ACEITANDO REQUISIÇOES");
		}catch (Exception exp) {
			System.err.println("JWARSERVER- CLIENT-"+ exp);
		}
	}
	
	/** Implementação de Singlenton */
	public static ClientSession getSession() {
		if (session == null) {
			session = new ClientSession();
		}
		return session;
	}
	
	/** Pego a referencia do WebServer do server */
	public XmlRpcClient getServerPrincipal() {
		if(servidorPrincipal == null) {
			try {
				XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
				config.setServerURL(new URL("http://"+IP_SERVIDOR+":"+PORT_XML_SERVIDOR+"/"));
				
				servidorPrincipal = new XmlRpcClient();
				servidorPrincipal.setConfig(config);
				
				ClientFactory cf = new ClientFactory(servidorPrincipal);
			    IJWarServerXml serverXml  = (IJWarServerXml) cf.newInstance(IJWarServerXml.class);
				setServerXml(serverXml);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return servidorPrincipal;
	}
	
	public WebServer getMyServer() {
		return myWebServer;
	}
	
	public void setNomeServidorJogo(String s) {
		nomeServidorJogo = s;
	}

	public String getNomeServidorJogo() {
		return this.nomeServidorJogo;
	}

	public void setJogador(String logado) {
		this.jogador = logado;		
	}
	
	public String getJogador() {
		return this.jogador;
	}

	public void setNomeChat(String connect) {
		this.nomeChat = connect;
	}
	
	public String getNomeChat() {
		return this.nomeChat;
	}

	public IJWarServerXml getServerXml() {
		return serverXml;
	}

	public void setServerXml(IJWarServerXml serverXml) {
		this.serverXml = serverXml;
	}

	public IServidorXml getServidorJogo() {
		return servidorJogo;
	}

	public void setServidorJogo(IServidorXml servidorJogo) {
		this.servidorJogo = servidorJogo;
	}

	public IChatXml getChat() {
		return chat;
	}

	public void setChat(IChatXml chat) {
		this.chat = chat;
	}

	public ISalaXml getSala() {
		return sala;
	}

	public void setSala(ISalaXml sala) {
		this.sala = sala;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	
}
