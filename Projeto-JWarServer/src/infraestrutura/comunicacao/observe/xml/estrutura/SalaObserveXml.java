package infraestrutura.comunicacao.observe.xml.estrutura;

import interfaces.gui.estrutura.sala.xml.ISalaGuiXml;
import negocio.beans.JogadorDaSala;
import negocio.estrutura.VJogadorDaSala;
import negocio.logistica.acoes.estrutura.SalaObserve;

public class SalaObserveXml extends SalaObserve{

	public SalaObserveXml(JogadorDaSala jds) {
		j = jds;
	}
	@Override
	public void alguemEntrou(VJogadorDaSala usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alguemFalou(String jFalando, String msg) {
		try {
			((ISalaGuiXml)j.getSalaListener()).alguemFalou("-> "+jFalando, msg);
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO GERAL");
			j.getJogador().setConectado(false);
		}
		
	}

}
