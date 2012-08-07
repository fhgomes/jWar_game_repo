package interfaces.negocio;

import interfaces.gui.estrutura.chat.IChatGUI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import exceptions.infraestrutura.LoginException;



public interface IServidorRmi extends Remote  {
	public String login(String servidor, String email, String senha, int tipo) throws RemoteException, LoginException;
	public String connect(String servidor, String jogador, IChatGUI listener) throws RemoteException;
	
}
