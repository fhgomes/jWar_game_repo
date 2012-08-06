package infraestrutura.comunicacao.estrutura.rmi;

import infraestrutura.comunicacao.observe.rmi.estrutura.ChatObserveRmi;
import infraestrutura.comunicacao.observe.rmi.estrutura.SalaObserveRmi;
import negocio.beans.Jogador;
import negocio.beans.JogadorDaSala;
import negocio.interfaces.estrutura.FabricaListener;
import negocio.logistica.acoes.estrutura.ChatObserve;
import negocio.logistica.acoes.estrutura.JogoObserve;
import negocio.logistica.acoes.estrutura.SalaObserve;

public class FabricaListenerRmi implements FabricaListener {

	@Override
	public ChatObserve getChatObserve(Jogador j) {
		return new ChatObserveRmi(j);
	}

	@Override
	public JogoObserve getJogoObserve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaObserve getSalaObserve(JogadorDaSala jds) {
		return new SalaObserveRmi(jds);
	}

}
