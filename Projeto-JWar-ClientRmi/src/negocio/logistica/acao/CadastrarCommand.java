package negocio.logistica.acao;

import infraestrura.comunicacao.ClientSession;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import exceptions.GenericException;

public class CadastrarCommand extends Command{
	private String nome;
	private String nick;
	private String email;
	private String senha;
	
	public CadastrarCommand(String nome, String nick, String email, String senha) {
		this.nick = nick;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public void inicio() throws GenericException {
		try {
			ClientSession.getSession().getServerPrincipal().cadastrar(
					nome, nick, email, senha);
		} catch (RemoteException e) {
			throw new GenericException(e.getMessage(), RemoteException.class);
		} catch (NotBoundException e) {
			throw new GenericException(e.getMessage(), NotBoundException.class);
		}	
		
	}

	@Override
	public void termino() throws GenericException {
		System.out.println("chama o mediator para avisar a tela que cadastrou com sucesso");
		
	}
	
	
}
