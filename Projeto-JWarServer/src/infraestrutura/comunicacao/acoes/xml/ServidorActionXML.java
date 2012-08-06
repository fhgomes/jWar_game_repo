package infraestrutura.comunicacao.acoes.xml;

import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.chat.xml.IChatGUIXml;
import interfaces.negocio.IServidorXml;

import java.net.MalformedURLException;
import java.net.URL;

import negocio.beans.Jogador;
import negocio.logistica.estrutura.Servidor;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

import exceptions.infraestrutura.LoginException;
import exceptions.infraestrutura.LoginExceptionXml;

public class ServidorActionXML implements IServidorXml{

	public String connect(String servidor, String jogador, String ip, int porta) throws MalformedURLException {
		Servidor s = (Servidor) ObjectProxy.resgataObjeto(servidor);
		
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setEnabledForExceptions(true);
		config.setEnabledForExtensions(true);
		config.setServerURL(new URL("http://"+ip+":"+porta+"/"));
		
		XmlRpcClient servidorCliente = new XmlRpcClient();
		servidorCliente.setConfig(config);
		
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(jogador);
		j.setReferencia(servidorCliente);
		
		ClientFactory cf = new ClientFactory(servidorCliente);
	    IChatGUIXml chatListenerXml  = (IChatGUIXml) cf.newInstance(IChatGUIXml.class);
	    String chat = s.connect(jogador, chatListenerXml);
	    return chat;
	}

	public String login(String servidor, String email, String senha) throws LoginExceptionXml {
		Servidor s = (Servidor) ObjectProxy.resgataObjeto(servidor);
		
		String logado;
		try {
			logado = s.login(email, senha, Jogador.CONEXAO_XML);
		} catch (LoginException e) {
			throw new LoginExceptionXml(e.getMessage());
		}
		return logado;
	}
	
}
