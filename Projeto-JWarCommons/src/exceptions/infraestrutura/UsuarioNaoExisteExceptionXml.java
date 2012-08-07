package exceptions.infraestrutura;

import org.apache.xmlrpc.XmlRpcException;

public class UsuarioNaoExisteExceptionXml extends XmlRpcException{

	public UsuarioNaoExisteExceptionXml(String message) {
		super(message);
	}

}
