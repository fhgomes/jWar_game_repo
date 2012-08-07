package interfaces.comunicacao;

public interface IJWarServerXml {
	public String getServidor(String nome);
	public boolean cadastrar(String nome, String nick, String email, String senha);
}
