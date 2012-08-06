package negocio.logistica.acoes;

import infraestrutura.proxies.ServerProxy;
import negocio.beans.Jogador;
import negocio.repositorio.beans.JogadorRep;

public class JWarServer {
	private static JWarServer singleton;
	
	private JWarServer () {}
	
	public static JWarServer getServer() {
		if(singleton == null) 
			singleton = new JWarServer();
		return singleton;
	}
	
	public String getServidor(String nome) {

		System.out.println("PROCURANDO SERVIDOR : "+nome);
		String serverName = ServerProxy.procuraServer(nome).toRegistry();
		System.out.println("RETORNANDO SERVIDOR AO CLIENTE: "+serverName);
		return serverName;
	}
	
	public boolean cadastrar(String nome, String nick, String email, String senha) {
		JogadorRep jRep = new JogadorRep();
		jRep.comecar();
		Jogador j = new Jogador(nome, nick, email, senha);
		jRep.salvar(j);
		jRep.terminar();
		
		return true;
	}
}
