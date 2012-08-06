package infraestrutura.comunicacao.acoes.rmi;

import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.chat.IChatGUI;
import interfaces.negocio.IServidorRmi;

import java.rmi.RemoteException;

import negocio.beans.Jogador;
import negocio.logistica.estrutura.Servidor;
import exceptions.infraestrutura.LoginException;

public class ServidorActionRmi implements IServidorRmi{

	
	@Override
	public String connect(String servidor, String jogador, IChatGUI listener) throws RemoteException {
		Servidor s = (Servidor) ObjectProxy.resgataObjeto(servidor);
	    String chat = s.connect(jogador, listener);
	    
	    return chat;	
	}

	/**
	 * Método que implementa o padrao de projeto adapter.
	 */
	@Override
	public String login(String servidor, String email, String senha, int tipo) throws RemoteException, LoginException {
		Servidor s = (Servidor) ObjectProxy.resgataObjeto(servidor);
		
		String logado;		
		logado = s.login(email, senha, Jogador.CONEXAO_RMI);
		return logado;
	}

	

}
