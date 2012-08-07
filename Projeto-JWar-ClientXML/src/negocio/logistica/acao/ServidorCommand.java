package negocio.logistica.acao;

import gui.estrutura.FrameChat;
import infraestrura.comunicacao.ClientSession;
import interfaces.negocio.IChatXml;
import interfaces.negocio.IServidorXml;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.NotBoundException;
import java.util.Enumeration;

import org.apache.xmlrpc.client.util.ClientFactory;

public class ServidorCommand {

	public void executeCommand(String servidor, String email, String senha, FrameChat frameChat) throws Exception, NotBoundException, MalformedURLException {
		System.out.println("Servidor->" + servidor);
		//PEGO O SERVIDOR
		String nomeServidorJogo = ClientSession.getSession()
						.getServerXml().getServidor(servidor); 
		ClientSession.getSession().setNomeServidorJogo(nomeServidorJogo);
		
		ClientFactory cf = new ClientFactory(ClientSession.getSession().getServerPrincipal());
	    IServidorXml servidorJogo = (IServidorXml) cf.newInstance(IServidorXml.class);
	    ClientSession.getSession().setServidorJogo(servidorJogo);
		
		//PEGO A MINHA REFERENCIA
		String logado = ClientSession.getSession().getServidorJogo().login(nomeServidorJogo, email, senha);	
		ClientSession.getSession().setJogador(logado);
		
		//EXPORTO A MINHA REFERENCIA !
		// IP+PORTA

		String ip="192.168.5.131";
		Enumeration nis = null;  
		try {  
		    nis = NetworkInterface.getNetworkInterfaces(); 
		} catch (SocketException e) {  
		    e.printStackTrace();  
		}  
		
		if(nis != null)
		while (nis.hasMoreElements()) {    
		    NetworkInterface ni = (NetworkInterface) nis.nextElement();    
		    Enumeration ias = ni.getInetAddresses();    
		    while (ias.hasMoreElements()) {    
		        InetAddress ia = (InetAddress) ias.nextElement(); 
		        if(!ia.isLoopbackAddress() && !ia.isLinkLocalAddress())
					try {
						if(ni.isUp()) {
							ip = ia.getHostAddress();
							System.out.println(ni.getName() + " -> ip: " + ia.getHostAddress() + " - hostname: " + ia.getHostName());
							break;
						}
					} catch (SocketException e) {
						e.printStackTrace();
					}     
		    }    
		}    
		
		
		//PEGO A REFERENCIA PRO MEU CHAT
		String nomeChat = servidorJogo.connect(nomeServidorJogo, logado, ip, ClientSession.PORT_XML_MY_SERVER);
	    ClientSession.getSession().setNomeChat(nomeChat);
		IChatXml chat = (IChatXml) cf.newInstance(IChatXml.class);
	    ClientSession.getSession().setChat(chat);
	    
	    
	}

}
