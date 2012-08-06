package negocio.beans.jogo;

import interfaces.negocio.jogo.IJogadorDoJogo;

import java.util.Vector;

import negocio.beans.Jogador;
import negocio.beans.JogadorDaSala;

/**
 * @author Fernando Gomes <br/><br/>
 * Nao extends JogadorDaSala pois tem que guardar referencias posteriormente.
 * Tem uma referencia a JogadorDaSala dentro de si.
 * <br/>
 */
public class JogadorDoJogo implements IJogadorDoJogo{
	
	private Vector<Pais> paises = new Vector<Pais>();
	private Vector<Carta> cartasConquistadas = new Vector<Carta>();
	private boolean paisNaRodada = false;
	private boolean conectado = false;
	private Objetivo objetivo = null;
	private JogadorDaSala jogador;	
	
	//DIARIO
	private Integer mortosEmBatalha;
	private Integer inimigosMortos;
	
	@SuppressWarnings("unused")
	private boolean morto = false;
	
	
	public JogadorDoJogo (JogadorDaSala j){
		this.jogador = j;
	}
	public Vector<Pais> getPaises() {
		return paises;
	}
	public int getNumeroPaises(){
		return paises.size();
	}
	public void ganhaPais(Pais p, boolean win) {
		this.paises.add(p);	
		this.paisNaRodada = win;
	}
	public void setObjetivo(Objetivo obj) {
		this.objetivo = obj;
	}
	public Vector<Carta> getCartas(){
		return this.cartasConquistadas;
	}
	public Objetivo getObjetivo() {
		return this.objetivo;
	}
	public JogadorDaSala getJogador() {
		return jogador;
	}
	public void ganhaCartasDoMorto(Vector<Carta> cartasDoMorto) {
		cartasConquistadas.addAll(cartasDoMorto);
	}
	public void setMorto() {
		morto = true;
	}
	public boolean isJogador(Jogador jogador) {
		if(this.jogador.getJogador() == jogador)
			return true;
		else
			return false;
	}
	public boolean isMorto() {
		return this.morto;
	}

	

	
}
