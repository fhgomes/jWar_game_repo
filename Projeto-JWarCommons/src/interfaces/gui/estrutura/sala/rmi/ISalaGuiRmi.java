package interfaces.gui.estrutura.sala.rmi;

import interfaces.gui.estrutura.sala.ISalaGUI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import negocio.estrutura.VJogadorDaSala;


public interface ISalaGuiRmi extends ISalaGUI, Remote{
	/** Atualizar a lista de Chat */
	public void alguemFalou(String quem, String fala) throws RemoteException;
	
	/** Atualizar os jogadores conectados */
	public void alguemEntrou(VJogadorDaSala jogador) throws RemoteException;

}
