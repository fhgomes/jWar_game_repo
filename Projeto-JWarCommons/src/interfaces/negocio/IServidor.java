package interfaces.negocio;

import interfaces.gui.estrutura.chat.IChatGUI;
import exceptions.infraestrutura.LoginException;

public interface IServidor {
	public String login(String email, String senha, int tipo) throws LoginException;
	public String connect(String jogador, IChatGUI listener);

}
