package infraestrutura.comunicacao.estrutura.rmi;

import interfaces.comunicacao.IJWarServerRmi;

import java.rmi.RemoteException;

import negocio.logistica.acoes.JWarServer;

/**
 * @author Fernando Gomes
 * Interface remota. Serve de proxie para o servidor principal.
 *
 */
public class JWarServerRmi implements IJWarServerRmi{
	
	public JWarServerRmi() {
		
	}

	public String getServidor(String nome) throws RemoteException {
		return JWarServer.getServer().getServidor(nome);
	}

	public boolean cadastrar(String nome, String nick, String email,
							 					String senha) throws RemoteException {
		return JWarServer.getServer().cadastrar(nome, nick, email, senha);
	}
	

	


	
}
