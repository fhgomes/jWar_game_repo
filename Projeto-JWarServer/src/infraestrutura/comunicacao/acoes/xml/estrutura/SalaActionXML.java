package infraestrutura.comunicacao.acoes.xml.estrutura;

import infraestrutura.proxies.ObjectProxy;
import interfaces.negocio.ISalaXml;
import negocio.logistica.estrutura.Sala;

public class SalaActionXML implements ISalaXml{

	@Override
	public void acionarBanner(String nomeSala, String jog) {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		sala.acionarBanner(jog);
	}

	@Override
	public String escrever(String nomeSala, String jog, String texto) {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		sala.escrever(jog, texto);
		return "ok";
		
	}

	@Override
	public boolean inicar(String nomeSala) {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		return sala.inicar();
	}

	@Override
	public boolean mudarDeCor(String nomeSala, String jog, int cor) {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		return sala.mudarDeCor(jog, cor);
	}

	@Override
	public void sair(String nomeSala, String jog) {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		sala.sair(jog);
		
	}

}
