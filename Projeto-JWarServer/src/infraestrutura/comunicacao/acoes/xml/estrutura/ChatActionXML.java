package infraestrutura.comunicacao.acoes.xml.estrutura;

import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.sala.xml.ISalaGuiXml;
import interfaces.negocio.IChatXml;
import negocio.beans.Jogador;
import negocio.logistica.estrutura.Chat;

import org.apache.xmlrpc.client.util.ClientFactory;

import exceptions.logistica.SalaException;

/**
 * @author Fernando Gomes
 * Interface remota. Serve como Proxie para a sala.
 *
 */
public class ChatActionXML implements IChatXml {

	@Override
	public String assistirSala(String nomeChat, String nomeSala, String nomeJog) {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		try {
			return chat.assistirSala(nomeSala, nomeJog);
		} catch (SalaException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String criarSala(String nomeChat, String nomeSala, Integer maxJog,
			String nomeJog) {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		Jogador j =(Jogador) ObjectProxy.resgataObjeto(nomeJog);
		
		ClientFactory cf = new ClientFactory(j.getReferencia());
	    ISalaGuiXml salaListenerXml  = (ISalaGuiXml) cf.newInstance(ISalaGuiXml.class);
	    
		try {
			return chat.criarSala(nomeSala, maxJog, nomeJog, salaListenerXml);
		} catch (SalaException e) {
			return "ok";
		}
	}

	@Override
	public String darOpiniao(String nomeChat, String msg, String nomeJog) {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		return null;
	}

	@Override
	public String entrarSala(String nomeChat, String sala, String nomeJog) {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		return null;
	}

	@Override
	public String escrever(String nomeChat, String msg, String nomeJog) {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		chat.escrever(msg, nomeJog);
		return "ok";
	}

	@Override
	public String reentrarSala(String nomeChat, String nomeSala, String nomeJog) {
		Chat chat = (Chat) ObjectProxy.resgataObjeto(nomeChat);
		return null;
	}

}