package infraestrutura.comunicacao.observe.xml.estrutura;

import interfaces.gui.estrutura.chat.xml.IChatGUIXml;
import negocio.beans.Jogador;
import negocio.estrutura.VUsuario;
import negocio.logistica.acoes.estrutura.ChatObserve;

public class ChatObserveXml extends ChatObserve{

	public ChatObserveXml(Jogador j) {
		this.j = j;
	}
	
	@Override
	public void alguemFalou(String jFalando, String msg) {
		try {
			((IChatGUIXml)j.getChatListener()).alguemFalou("-> "+jFalando, msg);
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO GERAL");
			j.setConectado(false);
		}
		
	}

	@Override
	public void alguemEntrou(VUsuario usuario) {
		try {
//			IChatGUIXml listenerXml = (IChatGUIXml) j.getChatListener();
//			listenerXml.alguemEntrou(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO GERAL");
			j.setConectado(false);
		}
		
	}
	
	@Override
	public void salaCriada(String nomeSala, Integer maxJog) {
		try {
			IChatGUIXml listenerXml = (IChatGUIXml) j.getChatListener();
			listenerXml.salaCriada(nomeSala, 1, maxJog);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO GERAL");
			j.setConectado(false);
		}
	}
	
	@Override
	public void saidaSala(String nomeSala) {
		try {
			IChatGUIXml listenerXml = (IChatGUIXml) j.getChatListener();
			listenerXml.saidaSala(nomeSala);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO GERAL");
			j.setConectado(false);
		}
		
	}
	
}
