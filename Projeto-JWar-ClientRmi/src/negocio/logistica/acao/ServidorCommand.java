package negocio.logistica.acao;

import exceptions.GenericException;
import exceptions.infraestrutura.LoginException;
import gui.estrutura.FrameChat;
import infraestrura.comunicacao.ClientSession;
import interfaces.negocio.IChatRmi;
import interfaces.negocio.IServidorRmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorCommand extends Command {

	private String servidor;
	private String email;
	private String senha;
	private FrameChat frameChat;
	
	public ServidorCommand (String servidor, String email, String senha, Object frameChat)  {
		this.senha = senha;
		this.servidor = servidor;
		this.frameChat = (FrameChat)frameChat;
		this.email = email;
	}

	@Override
	public void inicio() throws GenericException {
		System.out.println("Servidor->" + servidor);
		//PEGO O SERVIDOR
		String nomeServidorJogo;
		try {
			nomeServidorJogo = ClientSession.getSession().getServerPrincipal()
						.getServidor(servidor);	
			ClientSession.getSession().setNomeServidor(nomeServidorJogo);
			IServidorRmi servidorJogo = (IServidorRmi) ClientSession.getSession().getRServidor().lookup("IServidorRmi");
			ClientSession.getSession().setServidor(servidorJogo);
			//PEGO A MINHA REFERENCIA
			//TODO ...........
			String logado = ClientSession.getSession().getServidorJogo().login(nomeServidorJogo, email, senha, 0);	
			ClientSession.getSession().setJogador(logado);
			
			//EXPORTO O MEU OBJETO REMOTO
			// prepara o objeto remoto para registro
			UnicastRemoteObject.exportObject(frameChat, 0);
		
			// registra o(s) objeto(s) remoto(s)
			try {
				ClientSession.getSession().getRCliente().bind("JWarServerRmi", frameChat);
			} catch (AlreadyBoundException e) {	}
			
			//PEGO A REFERENCIA PRO MEU CHAT
			String nomeChat = servidorJogo.connect(nomeServidorJogo, logado, frameChat);
			ClientSession.getSession().setChatName(nomeChat);
			IChatRmi chat =  (IChatRmi) ClientSession.getSession().getRServidor().lookup("IChatRmi");
			ClientSession.getSession().setChat(chat);
		
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new GenericException(e.getMessage(), RemoteException.class);
			
		} catch (NotBoundException e) {
			e.printStackTrace();
			throw new GenericException(e.getMessage(), NotBoundException.class);
		} catch (LoginException e) {
			e.printStackTrace();
			throw new GenericException(e.getMessage(), LoginException.class);
		}
		
	}

	@Override
	public void termino() {}
	

}
