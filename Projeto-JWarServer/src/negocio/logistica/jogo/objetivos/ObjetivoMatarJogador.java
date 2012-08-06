package negocio.logistica.jogo.objetivos;


import interfaces.negocio.IObjetivoImpl;

import java.util.Iterator;
import java.util.Vector;

import negocio.beans.jogo.JogadorDoJogo;
import negocio.beans.jogo.Objetivo;

/**
 * @author Fernando Gomes
 * <br/>
 * Classe que extende Objetivo, é responsavel por implementar o método 
 * objetivo alcançado com implementaçao do Objetivo de Matar um Jogador
 */
public class ObjetivoMatarJogador extends Objetivo implements IObjetivoImpl{

	public ObjetivoMatarJogador(String nomeObjetivo, int tipo, Vector instrucoes) {
		super(nomeObjetivo, tipo, instrucoes);
	}
	/**
	 * Pode ser chamado a cada conquista de territorio, se o jogador defensor
	 * perdeu todos seus paises. <br/>
	 * 
	 * -> verifica se o Objetivo do jogador era matar o jogador.
	 */
	public boolean objetivoFoiAlcancado(Object obj) {
		JogadorDoJogo jogAlvo = (JogadorDoJogo) getInstrucoes().get(0);
		JogadorDoJogo morto = (JogadorDoJogo) obj;
		if (jogAlvo == morto)
			return true;
		else{
			getDonoDoObjetivo().ganhaCartasDoMorto(morto.getCartas());
			morto.getCartas().removeAllElements();
			morto.setMorto();
			return false;
		}
	}
	/**
	 * Caso o objetivo nao tenha sido alcançado com a morte do jogador.. este método é
	 * acionado. Verifica se algum outro jogador tinah este objetivo.. e o troca para
	 * 24 territorios.
	 * 
	 */
	public void verificaJogadorMorto(JogadorDoJogo jMorto, Vector<JogadorDoJogo> jogadores){
		Iterator itJ = jogadores.iterator();
		while(itJ.hasNext()){
			JogadorDoJogo jogTemp = (JogadorDoJogo) itJ.next();
			if(jMorto == jogTemp.getObjetivo().getInstrucoes().get(0)){
				//jogTemp.setObjetivo(new ObjetivoPaises(24,imagen
			}
		}
	}

	public String getNomeObjetivo() {
		return getNome();
	}
	

	
}
