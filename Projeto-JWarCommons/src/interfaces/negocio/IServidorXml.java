package interfaces.negocio;

import java.net.MalformedURLException;


public interface IServidorXml {
	public String login(String servidor, String email, String senha) throws Exception;
	public String connect(String servidor, String jogador, String ip, int porta) throws MalformedURLException;
}
