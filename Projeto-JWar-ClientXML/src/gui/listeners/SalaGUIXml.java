package gui.listeners;

import gui.estrutura.FrameSala;
import gui.util.RepositorioFrames;
import interfaces.gui.estrutura.sala.xml.ISalaGuiXml;
import negocio.estrutura.VJogadorDaSala;


public class SalaGUIXml implements ISalaGuiXml{

	@Override
	public String alguemEntrou(VJogadorDaSala jogador) {
		FrameSala fs = (FrameSala) RepositorioFrames.getRepositorio().getFrame("Sala");
		return fs.alguemEntrou(jogador);
		
	}

	@Override
	public String alguemFalou(String quem, String fala) {
		FrameSala fs = (FrameSala) RepositorioFrames.getRepositorio().getFrame("Sala");
		return fs.alguemFalou(quem, fala);
	}

	@Override
	public String testeConexao() {
		return "ok";
	}

}
