package interfaces.negocio.jogo;

import java.util.HashMap;

/**
 * 
 * @author Fernando Gomes
 * Classe respons�vel por guardar todas as informa�oes da fun�ao de ataque.
 *
 */
public interface IAtackResults {
	public HashMap<IPais, Integer> getExercitosDepois();
	public boolean conquistado();
}
