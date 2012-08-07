package interfaces.gui.estrutura.chat.rmi;

import interfaces.gui.estrutura.chat.IChatGUI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import negocio.estrutura.VUsuario;

public interface IChatGUIRmi extends IChatGUI, Remote {
	
	/** Atualizar a lista de Chat */
	public void alguemFalou(String quem, String fala) throws RemoteException;
	
	/** Atualizar os jogadores conectados */
	public void alguemEntrou(VUsuario jogador) throws RemoteException;
	
	/** Atualizar o painel de salas - Cria uma Sala */
	public void salaCriada(String nomeSala, Integer jog, Integer max) throws RemoteException;
	
	/** Atualizar o painel de salas - Diminuir o contador de jogadores na sala */
	public void saidaSala(String nomeSala) throws RemoteException;
	
	/** Atualizar o painel de salas - Muda cor do painel */
	public void salaComecaJogo(String nomeSala) throws RemoteException;
	
	/** Atualizar o painel de salas - Retira uma Sala */
	public void salaFechada(String nomeSala) throws RemoteException;
	
	/** Atualizar o painel de salas - Aumenta um jogador */
	public void jogEntraSala(String nomeSala) throws RemoteException;
	
	/** Atualizar o painel de salas - Diminui um jogador */
	public void jogSaiuDaSala(String nomeSala) throws RemoteException;
	
	public void testeConexao() throws RemoteException;
	
}
