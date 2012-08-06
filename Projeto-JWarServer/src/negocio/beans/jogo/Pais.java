package negocio.beans.jogo;


import interfaces.negocio.jogo.IJogadorDoJogo;
import interfaces.negocio.jogo.IPais;

import java.util.HashMap;

/**
 * 
 * @author Fernando Gomes
 *
 */
public class Pais implements IPais{
	private String nome;
	private Continente continente;
	private JogadorDoJogo jogadorDono;
	private Integer exercitos;

	private HashMap<String, Pais> fronteiras;
	private Carta carta;
	
	/** Se o pais acabou de ser conquistado tera de receber um exercito.. 
	 *  e ser setado para a movimentaçao do resto dos exercitos.  */
	private boolean recemConquistado = false;
	
	public Pais(String nome, Continente continente) {
		this.nome = nome;
		this.exercitos = 0;
		this.continente = continente;
		fronteiras = new HashMap<String, Pais>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Continente getContinente() {
		return continente;
	}

	public JogadorDoJogo getJogadorDono() {
		return jogadorDono;
	}

	public void setJogadorDono(JogadorDoJogo jogadorDono) {
		this.jogadorDono = jogadorDono;
	}

	public Integer getExercitos() {
		return exercitos;
	}

	public void addExercitos(Integer exercitos) {
		this.exercitos += exercitos;
	}

	public void setCarta(Carta c1) {
		this.carta = c1;
	}

	public Carta getCarta() {
		return this.carta;
	}
	/** 
	 * Metodo responsavel por adcionar as fronteiras deste pais. <br>
	 * Fronteiras nao podem repetir.
	 * @param front
	 */
	public void addFronteira(Pais front){
		if(fronteiras.get(front.getNome()) == null){
			fronteiras.put(front.getNome(), front);
		}
	}

	@Override
	public boolean isFronteira(String nomePais) {
		if(fronteiras.get(nomePais) == null)
			return false;
		else
			return true;
	}
	@Override
	public boolean isDono(IJogadorDoJogo jog){
		if(((JogadorDoJogo)jog)==this.getJogadorDono())
			return true;
		else
			return false;
	}

	public void perdeExercitos(Integer perdasD) {
		this.exercitos = exercitos - perdasD;
	}
}
