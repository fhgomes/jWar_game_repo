package negocio.beans.jogo;

import java.util.HashMap;

/**
 * 
 * @author Fernando Gomes
 * <br/>
 */
public class Continente {
	public static final int AMERICA_DO_SUL = 1;
	public static final int AMERICA_DO_NORTE = 2;
	public static final int AFRICA = 3;
	public static final int ASIA = 4;
	public static final int EUROPA = 5;
	public static final int OCEANIA = 6;
	
	private String nome;
	private Integer nExercitos;
	private HashMap<String, Pais> paises;
	private JogadorDoJogo jogadorDono;
	
	public Continente(int nome, int i) {
		switch(nome){
		case 1: this.nome = "América do Sul";
			break;
		case 2: this.nome = "América do Norte";
			break;
		case 3: this.nome = "Africa";
			break;
		case 4: this.nome = "Asia";
			break;
		case 5: this.nome = "Europa";
			break;
		case 6: this.nome = "Oceania";
			break;
		}
		this.nExercitos = new Integer(i);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNExercitos() {
		return nExercitos;
	}

	public void setNExercitos(Integer exercitos) {
		nExercitos = exercitos;
	}

	public HashMap<String,Pais> getPaises() {
		return paises;
	}

	public void setPaises(HashMap<String,Pais> paises) {
		this.paises = paises;
	}
	public void addPais(Pais p){
		this.paises.put(p.getNome(), p);
	}

	public JogadorDoJogo getJogadorDono() {
		return jogadorDono;
	}

	public void setJogadorDono(JogadorDoJogo jogadorDono) {
		this.jogadorDono = jogadorDono;
	}
	
}
