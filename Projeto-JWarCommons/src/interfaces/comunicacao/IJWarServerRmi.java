package interfaces.comunicacao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IJWarServerRmi extends Remote {
	public String getServidor(String nome) throws RemoteException ;
	public boolean cadastrar(String nome, String nick, String email, String senha) throws RemoteException; 
}
