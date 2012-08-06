package infraestrutura.comunicacao.acoes.rmi.estrutura;

import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.sala.ISalaGUI;
import interfaces.negocio.IChatRmi;

import java.rmi.RemoteException;

import negocio.logistica.estrutura.Chat;
import exceptions.logistica.SalaException;

public class ChatActionRmi implements IChatRmi{

	@Override
	public String assistirSala(String nomeChat, String nomeSala, String nomeJog) throws RemoteException, SalaException {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		return chat.assistirSala(nomeSala, nomeJog);
	}

	@Override
	public String criarSala(String nomeChat, String nomeSala, Integer maxJog, String nomeJog,
															ISalaGUI listener) throws RemoteException, SalaException {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		return chat.criarSala(nomeSala, maxJog, nomeJog, listener);
	}

	@Override
	public void darOpiniao(String chat, String msg, String nomeJog) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String entrarSala(String nomeChat, String nomeSala, String nomeJog, ISalaGUI listener)
																				throws RemoteException, SalaException {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		
		return chat.entrarSala(nomeSala, nomeJog, listener);
	}

	@Override
	public void escrever(String nomeChat, String msg, String nomeJog) throws RemoteException {
		System.out.println("ALGUEM TA FALANDO NO CHAT ...");
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		chat.escrever(msg, nomeJog);
		
	}

	@Override
	public String reentrarSala(String nomeChat, String nomeSala, String nomeJog) throws RemoteException, SalaException {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		return chat.reentrarSala(nomeSala, nomeJog);
	}

	@Override
	public boolean sairSala(String nomeChat, String sala, String nomeJog) throws RemoteException, SalaException {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		return chat.sairSala(sala,nomeJog);
	}

}
