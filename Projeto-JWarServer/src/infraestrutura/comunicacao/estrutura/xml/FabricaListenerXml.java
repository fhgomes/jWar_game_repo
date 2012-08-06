package infraestrutura.comunicacao.estrutura.xml;

import infraestrutura.comunicacao.observe.xml.estrutura.ChatObserveXml;
import infraestrutura.comunicacao.observe.xml.estrutura.SalaObserveXml;
import negocio.beans.Jogador;
import negocio.beans.JogadorDaSala;
import negocio.interfaces.estrutura.FabricaListener;
import negocio.logistica.acoes.estrutura.ChatObserve;
import negocio.logistica.acoes.estrutura.JogoObserve;
import negocio.logistica.acoes.estrutura.SalaObserve;

public class FabricaListenerXml implements FabricaListener{

	@Override
	public ChatObserve getChatObserve(Jogador j) {
		return new ChatObserveXml(j);
	}
	
	@Override
	public JogoObserve getJogoObserve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaObserve getSalaObserve(JogadorDaSala jds) {
		return new SalaObserveXml(jds);
	}

}
