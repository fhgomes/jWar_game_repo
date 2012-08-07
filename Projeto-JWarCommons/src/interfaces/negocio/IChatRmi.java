package interfaces.negocio;

import interfaces.gui.estrutura.sala.ISalaGUI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import exceptions.logistica.SalaException;

/**
 * 
 * @author Fernando Gomes
 * <br/>
 * Interface para acesso remoto, referente as funçoes do Chat geral.
 *
 */
public interface IChatRmi extends Remote {
	public void escrever(String chat, String msg, String nomeJog) throws RemoteException;
	public void darOpiniao(String chat, String msg, String nomeJog) throws RemoteException;
	
	public String criarSala(String chat, String nomeSala, Integer maxJog, String nomeJog, ISalaGUI listener) throws RemoteException, SalaException;
	public String entrarSala(String chat, String sala, String nomeJog, ISalaGUI listener) throws RemoteException, SalaException;
	public boolean sairSala(String chat, String sala, String nomeJog) throws RemoteException, SalaException;
	public String reentrarSala(String chat, String nomeSala, String nomeJog) throws RemoteException, SalaException;
	public String assistirSala(String chat, String nomeSala, String nomeJog) throws RemoteException, SalaException;
}
