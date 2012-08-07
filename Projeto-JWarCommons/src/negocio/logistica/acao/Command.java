package negocio.logistica.acao;

import java.awt.event.ActionEvent;

import exceptions.GenericException;

/** templhate method **/
public abstract class Command {
	public void executeCommand(ActionEvent evt) throws GenericException {
		inicio();
		termino();
	}
	
	public abstract void inicio() throws GenericException;
	public abstract void termino() throws GenericException;
	
}
