package negocio.app;

import infraestrutura.comunicacao.acoes.rmi.ServidorActionRmi;
import infraestrutura.comunicacao.acoes.rmi.estrutura.ChatActionRmi;
import infraestrutura.comunicacao.acoes.rmi.estrutura.SalaActionRmi;
import infraestrutura.comunicacao.acoes.xml.ServidorActionXML;
import infraestrutura.comunicacao.acoes.xml.ServidorExternoActionXml;
import infraestrutura.comunicacao.acoes.xml.estrutura.ChatActionXML;
import infraestrutura.comunicacao.acoes.xml.estrutura.JogoActionXML;
import infraestrutura.comunicacao.acoes.xml.estrutura.SalaActionXML;
import infraestrutura.comunicacao.estrutura.rmi.JWarServerRmi;
import infraestrutura.comunicacao.estrutura.xml.JWarServerXml;
import infraestrutura.proxies.ObjectProxy;
import interfaces.comunicacao.IJWarServerRmi;
import interfaces.comunicacao.IJWarServerXml;
import interfaces.negocio.IChatRmi;
import interfaces.negocio.IChatXml;
import interfaces.negocio.ISalaRmi;
import interfaces.negocio.ISalaXml;
import interfaces.negocio.IServidorRmi;
import interfaces.negocio.IServidorXml;
import interfaces.negocio.jogo.IJogoXml;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import negocio.repositorio.estrutura.FabricaDeServidor;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class ServerMain {
	private static WebServer webServer;
	private static final int PORT_XML = 34340;
	private static final int PORT_RMI = 20090;
	
	
	//=======================
	public static void main(String[] args) 
	{
		startRmiServer();
		startXmlServer();
		ObjectProxy.startObjectProxy();;
		
		FabricaDeServidor fs = new FabricaDeServidor();
		try {
			fs.criarServidor("Academia", 1, 1);
			fs.criarServidor("Pearl Harbor", 2, 2);
			fs.criarServidor("Normandia", 3, 3);
			fs.criarServidor("Iwo Jima", 4, 4);
			fs.criarServidor("Okinawa", 5, 5);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
				
	}

	private static void startXmlServer() {
		try {
			
			System.out.println("COMEÇANDO A ESTARTAR O SERVIDOR...");
			
			webServer = new WebServer(PORT_XML);
			ObjectProxy.setWebServer(webServer);
			
			XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
	
			PropertyHandlerMapping phm = new PropertyHandlerMapping();
			phm.addHandler(IJWarServerXml.class.getName(), JWarServerXml.class);
			phm.addHandler(IServidorXml.class.getName(), ServidorActionXML.class);
			phm.addHandler(IChatXml.class.getName(), ChatActionXML.class);
			phm.addHandler(ISalaXml.class.getName(), SalaActionXML.class);
			phm.addHandler(IJogoXml.class.getName(), JogoActionXML.class);
			
			phm.addHandler("servidorAdm", ServidorExternoActionXml.class);
			
			xmlRpcServer.setHandlerMapping(phm);

			webServer.start();
			
			System.out.println("SERVIDOR XML ESTARTADO COM SUCESSO");
			System.out.println("ACEITANDO REQUISIÇOES");
		}catch (Exception exp) {
			System.err.println("JWARSEVER-"+ exp);
		}
		
	}

	private static void startRmiServer() {
		// inicializar o RMIRegistry
		 try {
			ObjectProxy.setRegistry(LocateRegistry.createRegistry(PORT_RMI));
			
			IJWarServerRmi rmi = new JWarServerRmi();
			IServidorRmi servidor = new ServidorActionRmi();
			IChatRmi chat = new ChatActionRmi();
			ISalaRmi sala = new SalaActionRmi();
			
			// prepara o objeto remoto para registro
			UnicastRemoteObject.exportObject(rmi, 0);
			UnicastRemoteObject.exportObject(servidor, 1);
			UnicastRemoteObject.exportObject(chat, 2);
			UnicastRemoteObject.exportObject(sala, 3);
			
			// registra o(s) objeto(s) remoto(s)
			ObjectProxy.getRegistry().bind("JWarServerRmi", rmi);
			ObjectProxy.getRegistry().bind("IServidorRmi", servidor);
			ObjectProxy.getRegistry().bind("IChatRmi", chat);
			ObjectProxy.getRegistry().bind("ISalaRmi", sala);
			
			
			
			System.out.println("SERVIDOR RMI ESTARTADO COM SUCESSO");
			System.out.println("ACEITANDO REQUISIÇOES");
			
		} catch (Exception e) {
			System.err.println("JWARSEVER-"+ e);
		}
		
	}
}
