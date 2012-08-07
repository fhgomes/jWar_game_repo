package interfaces.negocio.jogo;

import java.util.HashMap;

/**
 * 
 * @author Fernando Gomes
 * Classe responsável por guardar todas as informaçoes da funçao de ataque.
 *
 */
public interface IAtackResults {
	public HashMap<IPais, Integer> getExercitosDepois();
	public boolean conquistado();
}
