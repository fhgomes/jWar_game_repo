package negocio.beans.jogo;

import interfaces.negocio.jogo.ICarta;
/**
 * 
 * @author Fernando Gomes
 * <br/>
 */
public class Carta implements ICarta{
	
	public static String TRIANGULO = "Triangulo";
	public static String QUADRADO = "Quadrado";
	public static String BOLA = "Bola";
	public static String CORINGA = "Coringa";
	
	private Pais pais;
	private String tipoCarta;
	
	public Carta(Pais p1, String tpc) {
		this.pais = p1;
		this.tipoCarta = tpc;
	}

	public Pais getPais() {
		return pais;
	}

	public String getTipoCarta() {
		return tipoCarta;
	}

	public String getNomeCarta() {
		return "Carta"+getPais().getNome();
	}

}
