package negocio.logistica.jogo.objetivos;


import interfaces.negocio.IObjetivoImpl;

import java.util.Iterator;
import java.util.Vector;

import negocio.beans.jogo.Objetivo;
import negocio.beans.jogo.Pais;

/**
 * @author Fernando Gomes
 * <br/>
 * Classe que extende Objetivo, é responsavel por implementar o método 
 * objetivo alcançado com implementaçao 
 */
public class ObjetivoPaises extends Objetivo implements IObjetivoImpl{
	
	public ObjetivoPaises(String nomeObjetivo,int tipo, Vector instrucoes) {
		super(nomeObjetivo, tipo, instrucoes);
	}

	/**
	 * Pode ser chamado em cada pais conquistado, cada movimentaçao de tropas. <br/>
	 * Verifica se o objetivo de Paises foi alcançado.
	 * <br/>
	 * -> 24 Paises - Verifica se o jogador possui 24 paises 
	 * <br/>
	 * -> 18 com 2 - Verifica se o Jogador tem mais de 17 paises.. e se todos estes
	 * possuem 2 exercitos
	 */
	public boolean objetivoFoiAlcancado(Object obj) {
		int numPaises = Integer.valueOf(getInstrucoes().get(0).toString());
		if (numPaises == 24)
			if (getDonoDoObjetivo().getPaises().size() == 24)
				return true;
			else return false;
		else
			if(getDonoDoObjetivo().getPaises().size()>17){
				// NAO ESQUECER FAZER VERIFICAR A CADA EXERCITO DESLOCADO
				int paisC2 = 0;
				Iterator it = getDonoDoObjetivo().getPaises().iterator();
				while(it.hasNext()){
					Pais p = (Pais) it.next();
					if (p.getExercitos()>1)
						paisC2 ++;
				}
				if (paisC2 > 17) 
					return true;
				else
					return false;
			}
			else
				return false;
	}

	public String getNomeObjetivo() {
		return getNome();
	}

}
