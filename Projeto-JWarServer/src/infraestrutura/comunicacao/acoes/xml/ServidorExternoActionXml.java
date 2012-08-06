package infraestrutura.comunicacao.acoes.xml;

import infraestrutura.proxies.ObjectProxy;
import interfaces.gui.estrutura.chat.xml.IChatGUIXml;
import interfaces.negocio.IServidorAdmXml;
import interfaces.negocio.IServidorXml;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import negocio.beans.Jogador;
import negocio.logistica.estrutura.Servidor;
import negocio.repositorio.beans.JogadorRep;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.util.ClientFactory;

import exceptions.infraestrutura.LoginException;
import exceptions.infraestrutura.LoginExceptionXml;

public class ServidorExternoActionXml implements IServidorXml, IServidorAdmXml{

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

	@Override
	public String cadastrar(String nick, String nome, String email, String senha) {
		JogadorRep rep = new JogadorRep();
		rep.comecar();
		Jogador u = new Jogador(nome, nick, email, senha);
		rep.salvar(u);
		rep.terminar();
		return "ok";
	}

	@Override
	public boolean editar(String id, String nick, String name, String email, String senha) {
		JogadorRep rep = new JogadorRep();
		rep.comecar();
		Jogador j;
		j = rep.buscarPorId(Long.parseLong(id));
//		j= new Jogador();
		j.setId(Long.parseLong(id));
		j.setNickname(nick);
		j.setNome(name);
		j.setEmail(email);
		if(!senha.equals(""))
			j.setSenha(senha);
		rep.update(j);
		rep.terminar();
		System.out.println("FUCK:"+j.getNickname() + j.getId());
		System.out.println("EDITADO"+nick +"->"+id);
		return true;
	}

	@Override
	public boolean excluir(String id) {
		JogadorRep rep = new JogadorRep();
		rep.comecar();
		rep.deletar(new Jogador(Integer.parseInt(id)));
		rep.terminar();
		return true;
	}

	@Override
	public Object[] listar() {
		JogadorRep rep = new JogadorRep();
		rep.comecar();
		ArrayList<Object[]> jogadores = new ArrayList<Object[]>();
		for(Jogador j: rep.buscaTodos()) {
			Object[] jogador = new Object[]{
								j.getId().toString(),
								j.getNickname(),
								j.getNome(),
								j.getEmail()					
								};
			jogadores.add(jogador);
			}
		rep.terminar();
		return jogadores.toArray();
	}

	@Override
	public Object[] getDados(String id) {
		JogadorRep rep = new JogadorRep();
		rep.comecar();
		Jogador j = rep.buscarPorId(Long.parseLong(id));
		Object[] jogador = new Object[]{j.getNickname(), j.getNome(), j.getEmail()};
		rep.terminar();
		return jogador;
	}
	
	
	

}
