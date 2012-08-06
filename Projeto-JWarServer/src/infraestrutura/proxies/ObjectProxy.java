package infraestrutura.proxies;

import java.rmi.ServerException;
import java.rmi.registry.Registry;
import java.util.HashMap;

import org.apache.xmlrpc.webserver.WebServer;

public class ObjectProxy {
	public static ObjectProxy objectProxy;
	private Registry r;
	public HashMap<String, Object> registroDeObjetos;
	private WebServer webServer;
	
	/** Implementacao de Singleton */
	private static ObjectProxy getObjectProxy() {
		if(objectProxy == null) {
			objectProxy = new ObjectProxy();
			System.out.println("REGISTRO DE OBJETOS INICIALIZADO COM SUCESSO");
		}
		return objectProxy;
	}
	
	private ObjectProxy () {
		registroDeObjetos = new HashMap<String, Object>();
	}
	
	/** Registra o Objeto no servidor de nome e no Rmi registry */
	public static boolean registraObjeto(Object o, String registro) throws ServerException {
		System.out.println("Tentando Registrar Objeto");
		if(getObjectProxy().registroDeObjetos.get(registro) == null) {
//			try {
				
//					// prepara o objeto remoto para registro
//					UnicastRemoteObject.exportObject((Remote) o, 0);
//					//registra o objeto
//					r.bind(registro,(Remote) o);
					
					getObjectProxy().registroDeObjetos.put(registro, o);
					System.out.println("OBJETO :" + o.getClass().getSimpleName() + 
							" - REGISTRADO -> " + registro);	
				
//			} catch (AlreadyBoundException e) {
//				e.printStackTrace();
//				throw new ServerException("Objeto ja registrado");
//			} catch (RemoteException e) {
//				System.out.println("DEU PAU");
//				e.printStackTrace();
//			} 
			return false;
		}
		System.out.println("Objeto: " +registro + "-> ja esta registrado !");
		return true;
		
	}
	
	public static Object resgataObjeto(String referencia) {
		return getObjectProxy().registroDeObjetos.get(referencia);
	}

	public static  void setRegistry(Registry createRegistry) {
		getObjectProxy().r = createRegistry;	
	}
	
	public static Registry getRegistry() {
		return getObjectProxy().r;
	}

	public static void setWebServer(WebServer webServer) {
		getObjectProxy().webServer = webServer;
	}
	
	public WebServer getWebServer() {
		return this.webServer;
	}

	public static void startObjectProxy() {
		getObjectProxy();		
	}

	public static HashMap<String, Object> getRegistroDeObjetos() {
		return getObjectProxy().registroDeObjetos;
	}
}
