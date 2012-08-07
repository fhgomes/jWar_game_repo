package exceptions.logistica;

import org.apache.xmlrpc.XmlRpcException;

public class JogoExceptionXml extends XmlRpcException{

	public JogoExceptionXml(String message) {
		super(message);
	}

}
