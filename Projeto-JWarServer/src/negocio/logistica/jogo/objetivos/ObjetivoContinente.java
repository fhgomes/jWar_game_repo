package negocio.logistica.jogo.objetivos;


import interfaces.negocio.IObjetivoImpl;

import java.util.Iterator;
import java.util.Vector;

import negocio.beans.jogo.Continente;
import negocio.beans.jogo.Objetivo;
import negocio.beans.jogo.Pais;

/**
 * @author Fernando Gomes
 * <br/>
 * Classe que extende Objetivo, � responsavel por implementar o m�todo 
 * objetivo alcan�ado com implementa�ao do objetivo de continentes.
 * Obtem os continentes contidos nas instru�oes do Objetivo e faz a verifica�ao
 * se o Jogador deste objetivo possui os mesmos.
 */
public class ObjetivoContinente extends Objetivo implements IObjetivoImpl {

	public ObjetivoContinente(String nomeObjetivo, int tipo, Vector instrucoes) {
		super(nomeObjetivo,tipo, instrucoes);
	}
	
	/**
	 * Pode ser chamado a cada conquista de pais. <br/>
	 * Verifica se as instru�oes do objetivo do jogador.
	 * (Quais continentes). e verifica se o jogador � dono destes.
	 */
	public boolean objetivoFoiAlcancado(Object obj) {
		Pais p = (Pais) obj;
		if (!(p.getContinente().getJogadorDono() == getDonoDoObjetivo()))
			return false;
		
		boolean alcancado = false;
		Iterator it = getInstrucoes().iterator();
		while (it.hasNext()) {
			Continente c = (Continente) it.next();
			if(c.getJogadorDono() == getDonoDoObjetivo())
				alcancado = true;
			else
				alcancado = false;
		}
		return alcancado;
	}

	@Override
	public String getNomeObjetivo() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
