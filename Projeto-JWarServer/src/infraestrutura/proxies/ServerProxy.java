package infraestrutura.proxies;

import negocio.logistica.estrutura.Servidor;

public class ServerProxy {
	
	public static Servidor procuraServer(String nome) {
		for(Object o:ObjectProxy.getRegistroDeObjetos().values()) {
			if (o instanceof Servidor) {
				Servidor server = (Servidor) o;
				System.out.println("Servidor ->" + server.getNome() +"=="+nome);
				if(server.getNome().equals(nome)){
					System.out.println("Servidor encontrado");
					return server;		
				}
			}
		}
		System.out.println("ServidorNaoEncontrado");
		return null;
	}
}
