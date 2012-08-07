package interfaces.negocio;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author Fernando Gomes
 * <br/> 
 * Interface para métodos remotos referentes as funçoes da Sala.
 *
 */
public interface ISalaRmi extends Remote{
	public boolean mudarDeCor(String sala, String jog, int cor) throws RemoteException;;
	public void escrever(String sala, String jog, String texto) throws RemoteException;;
	public void sair(String sala, String jog) throws RemoteException;;
	public boolean inicar(String sala) throws RemoteException;;
	public void acionarBanner(String sala, String jog) throws RemoteException;;
	
}
