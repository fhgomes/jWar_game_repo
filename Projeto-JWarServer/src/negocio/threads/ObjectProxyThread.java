package negocio.threads;

import infraestrutura.proxies.ObjectProxy;

import java.rmi.ServerException;

public class ObjectProxyThread extends Thread {
	private Object logado;
	private String  registry;
	/** Provavelmente serve para quando um jogador for relogar **/
	private boolean jaRegistrado;
	
	public ObjectProxyThread(Object logado, String registry) {
		this.logado   = logado;
		this.registry = registry;
	}
	
	public void run() {
	   try {
		jaRegistrado = ObjectProxy.registraObjeto(logado, registry);
		} catch (ServerException e) {
			e.printStackTrace();
		}
	}
	
	public boolean jaRegistrado() {
		return this.jaRegistrado;
	}
}