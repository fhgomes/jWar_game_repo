package exceptions.logistica;

import org.apache.xmlrpc.XmlRpcException;

public class SalaExceptionXml extends XmlRpcException{

	public SalaExceptionXml(String message) {
		super(message);
	}

}
