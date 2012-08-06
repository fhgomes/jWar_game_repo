package negocio.interfaces.estrutura;

import negocio.beans.Jogador;
import negocio.beans.JogadorDaSala;
import negocio.logistica.acoes.estrutura.ChatObserve;
import negocio.logistica.acoes.estrutura.JogoObserve;
import negocio.logistica.acoes.estrutura.SalaObserve;

/**
 * 
 * @author Fernando Gomes
 * Implementa��o da interface de FabricaListener para utiliza��o no abstractFactory
 *
 */
public interface FabricaListener {
	
	public ChatObserve getChatObserve(Jogador j);
	public SalaObserve getSalaObserve(JogadorDaSala jds);
	public JogoObserve getJogoObserve();
}
