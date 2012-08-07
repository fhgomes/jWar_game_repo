package negocio.logistica.acao;

import infraestrura.comunicacao.ClientSession;
import exceptions.GenericException;

public class CadastrarCommand extends Command {
	
	private String nome;
	private String nick;
	private String email;
	private String senha;	
	
	public CadastrarCommand(String nome, String nick, String email, String senha) {
		this.nome = nome;
		this.nick = nick;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public void inicio() throws GenericException {
		ClientSession.getSession().getServerXml().cadastrar(nome, nick, email, senha);
	}

	@Override
	public void termino() throws GenericException {
		// TODO Auto-generated method stub
		
	}

}
