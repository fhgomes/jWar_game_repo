package negocio.logistica.acoes.estrutura;

import negocio.beans.Jogador;
import negocio.estrutura.VUsuario;

/**
 * @author Fernando Gomes
 * O implementa��o do m�todo public abstract void alguemFalou(Jogador jFalando, String msg);
 * 
 */
public abstract class ChatObserve {
	
	protected Jogador j;
	
	public abstract void alguemFalou(String jFalando, String msg);
	public abstract void alguemEntrou(VUsuario usuario);
	public abstract void salaCriada(String nomeSala, Integer maxJog);
	public abstract void saidaSala(String nomeSala);
}
