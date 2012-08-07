package gui.listeners;

import gui.estrutura.FrameChat;
import gui.util.RepositorioFrames;
import interfaces.gui.estrutura.chat.xml.IChatGUIXml;
import negocio.estrutura.VUsuario;

public class ChatGUIXml implements IChatGUIXml{

	@Override
	public String alguemEntrou(VUsuario jogador) {
		FrameChat fc = (FrameChat) RepositorioFrames.getRepositorio().getFrame("Chat");
		fc.alguemEntrou(jogador);
		return "";
	}

	@Override
	public String alguemFalou(String quem, String fala) {
		FrameChat fc = (FrameChat) RepositorioFrames.getRepositorio().getFrame("Chat");
		fc.alguemFalou(quem, fala);	
		return "";
	}

	@Override
	public String jogEntraSala(String nomeSala) {
		// TODO Auto-generated method stub
		return "";
		
	}

	@Override
	public String jogSaiuDaSala(String nomeSala) {
		// TODO Auto-generated method stub
		return "";
		
	}

	@Override
	public String salaComecaJogo(String nomeSala) {
		// TODO Auto-generated method stub
		return "";
		
	}

	@Override
	public String salaCriada(String nomeSala, Integer jog, Integer max) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String salaFechada(String nomeSala) {
		// TODO Auto-generated method stub
		return "";		
	}

	public String testeConexao() {
		return "";
	}

	@Override
	public String saidaSala(String nomeSala) {
		// TODO Auto-generated method stub
		return null;
	}

}
