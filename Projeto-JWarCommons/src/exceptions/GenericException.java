package exceptions;

public class GenericException extends Exception { 
	private Class tipo;
	public GenericException(String msg, Class tipo) {
		super(msg);
		this.tipo = tipo;
	}
	
	public Class getTipo() {
		return this.tipo;
	}
}
