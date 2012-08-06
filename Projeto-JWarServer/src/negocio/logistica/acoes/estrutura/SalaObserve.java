package negocio.logistica.acoes.estrutura;

import negocio.beans.JogadorDaSala;
import negocio.estrutura.VJogadorDaSala;

public abstract class SalaObserve {
	
	protected JogadorDaSala j;
	
	public abstract void alguemFalou(String jFalando, String msg);
	public abstract void alguemEntrou(VJogadorDaSala usuario);

}
