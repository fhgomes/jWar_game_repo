package interfaces.gui.estrutura.sala.xml;

import interfaces.gui.estrutura.sala.ISalaGUI;
import negocio.estrutura.VJogadorDaSala;

public interface ISalaGuiXml extends ISalaGUI {
	
	/** Atualizar a lista de Chat */
	public String alguemFalou(String quem, String fala);
	
	/** Atualizar os jogadores conectados */
	public String alguemEntrou(VJogadorDaSala jogador);
	
	public String testeConexao();

}
