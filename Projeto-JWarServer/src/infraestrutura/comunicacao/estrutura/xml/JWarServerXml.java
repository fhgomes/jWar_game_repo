package infraestrutura.comunicacao.estrutura.xml;

import interfaces.comunicacao.IJWarServerXml;
import negocio.logistica.acoes.JWarServer;

/**
 * @author Administrador
 * Interface disponibilizada para fazer a comunicação com Cliente XML-RPC.
 * 
 */
public class JWarServerXml implements IJWarServerXml {
	
	public String getServidor(String nome){
		return JWarServer.getServer().getServidor(nome);		
	}
	
	public boolean cadastrar(String nome, String nick, String email, String senha) {
		return JWarServer.getServer().cadastrar(nome, nick, email, senha);
	}
}
