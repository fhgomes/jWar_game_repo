package exceptions.infraestrutura;

import org.apache.xmlrpc.XmlRpcException;

public class LoginExceptionXml extends XmlRpcException{

	public LoginExceptionXml(String message) {
		super(message);
	}

}
