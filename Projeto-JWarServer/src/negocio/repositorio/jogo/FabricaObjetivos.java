package negocio.repositorio.jogo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import negocio.beans.JogadorDaSala;
import negocio.beans.jogo.Continente;
import negocio.beans.jogo.Objetivo;
import negocio.logistica.jogo.objetivos.ObjetivoContinente;
import negocio.logistica.jogo.objetivos.ObjetivoMatarJogador;
import negocio.logistica.jogo.objetivos.ObjetivoPaises;

/**
 * 
 * @author Fernando Gomes
 * <br/>
 * Classe fabrica. Responsável por criar uma instancia de Objetivo e retorna-la;
 *
 */
public class FabricaObjetivos {
	public static final int MATAR = 1;
	public static final int PAIS24 = 2;
	public static final int PAIS18 = 3;
	public static final int CONT = 4;
	
	public Objetivo getObjetivo(int tipo, ArrayList<Object> params) {
		switch(tipo) {
		case 1:
			int i = (Integer) params.get(0);
			return criaObjetivoMatar(i);
		case 2:
			return criaObjetivoPais(24);
		case 3:
			return criaObjetivoPais(18);
		case 4:
			return criaObjetivoContinente(params);
			
		default: return null;
		}
	}
	@SuppressWarnings("unchecked")
	private Objetivo criaObjetivoContinente(ArrayList<Object> params) {
		String nomeObjetivo="Conquistar_";
		Iterator iParams = params.iterator();
		while(iParams.hasNext()){
			Continente c = (Continente) iParams.next();
			if(c!=null)
				nomeObjetivo += c.getNome();
			else
				nomeObjetivo += "Qualquer";
			
			if(iParams.hasNext())
				nomeObjetivo+="_";
		}
		Objetivo objt = new ObjetivoContinente(nomeObjetivo, FabricaObjetivos.CONT, new Vector(params));
		return objt;
	}
	@SuppressWarnings("unchecked")
	private Objetivo criaObjetivoPais(int i) {
		String nomeObjetivo;
		@SuppressWarnings("unused")
		Objetivo objetivo;
		Vector instrucoes = new Vector();
		if (i == 24) {
			nomeObjetivo = "24Territorios";
			instrucoes.add(24);
			objetivo = new ObjetivoPaises(nomeObjetivo, FabricaObjetivos.PAIS24, instrucoes);
		}
		else
			if(i == 18){
				nomeObjetivo = "18Territorios2";
				instrucoes.add(18);
				objetivo = new ObjetivoPaises(nomeObjetivo, FabricaObjetivos.PAIS24, instrucoes);
			}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Objetivo criaObjetivoMatar(int cor){
		String corString = "";
		switch(cor){
		case JogadorDaSala.amarelo:
			corString ="Amarelo";
			break;
		case JogadorDaSala.azul:
			corString ="Azul";
			break;
		case JogadorDaSala.verde:
			corString ="Verde";
			break;
		case JogadorDaSala.vermelho:
			corString ="Vermelho";
			break;
		case JogadorDaSala.preto:
			corString ="Preto";
			break;
		case JogadorDaSala.branco:
			corString ="Branco";
			break;
		}
		Vector instrucoes = new Vector();
		instrucoes.add(cor);
		Objetivo objt = new ObjetivoMatarJogador("Destruir o exercito "+ corString,
							FabricaObjetivos.MATAR, instrucoes);
		return objt;
	}

}
