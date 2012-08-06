package infraestrutura.comunicacao.observe.rmi.estrutura;

import interfaces.gui.estrutura.chat.rmi.IChatGUIRmi;

import java.rmi.RemoteException;

import negocio.beans.Jogador;
import negocio.estrutura.VUsuario;
import negocio.logistica.acoes.estrutura.ChatObserve;

public class ChatObserveRmi extends ChatObserve {

	
	public ChatObserveRmi(Jogador j) {
		this.j = j;
	}
	@Override
	public void alguemFalou(String jFalando, String msg) {
		try {
			((IChatGUIRmi)j.getChatListener()).alguemFalou("-> "+jFalando, msg);
		} catch (RemoteException e) {
			System.out.println("Cliente nao alcançado");
			j.setConectado(false);
		} catch (Exception eGeral) {
			eGeral.printStackTrace();
			System.out.println("ERRO GERAL");
			j.setConectado(false);
		}
	}
	@Override
	public void alguemEntrou(VUsuario usuario) {
		IChatGUIRmi listenerRmi = (IChatGUIRmi) j.getChatListener();
		try {
			listenerRmi.alguemEntrou(usuario);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void salaCriada(String nomeSala, Integer maxJog) {
		try {
			((IChatGUIRmi)j.getChatListener()).salaCriada(nomeSala, 1, maxJog);
		} catch (RemoteException e) {
			System.out.println("Cliente nao alcançado");
			j.setConectado(false);
		} catch (Exception eGeral) {
			eGeral.printStackTrace();
			System.out.println("ERRO GERAL");
			j.setConectado(false);
		}
	}
	
	@Override
	public void saidaSala(String nomeSala) {
		try {
			((IChatGUIRmi)j.getChatListener()).saidaSala(nomeSala);
		} catch (RemoteException e) {
			System.out.println("Cliente nao alcançado");
			j.setConectado(false);
		} catch (Exception eGeral) {
			eGeral.printStackTrace();
			System.out.println("ERRO GERAL");
			j.setConectado(false);
		}
	}
	
}
