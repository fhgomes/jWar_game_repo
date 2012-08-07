package interfaces.negocio;

import interfaces.gui.estrutura.sala.ISalaGUI;
import exceptions.logistica.SalaException;

public interface IChat {

	public String escrever(String msg, String nomeJog);
	public String darOpiniao(String msg, String nomeJog);
	
	public String criarSala(String nomeSala, Integer maxJog, String nomeJog, ISalaGUI listener) throws SalaException;
	public String entrarSala(String sala, String nomeJog, ISalaGUI listener) throws SalaException;
	public String reentrarSala(String nomeSala, String nomeJog) throws SalaException;
	public String assistirSala(String nomeSala, String nomeJog) throws SalaException;
}
