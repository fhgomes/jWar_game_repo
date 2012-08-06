package negocio.repositorio.jogo;

import java.util.HashMap;

import negocio.beans.jogo.Carta;
import negocio.beans.jogo.Continente;
import negocio.beans.jogo.Pais;

public class FabricaPais {
	
	private HashMap<String, Pais> paisesCriados = new HashMap<String, Pais>();
	/**
	 * Retorna uma instancia de pais. Adciona o pais ao continente e cria uma carta para
	 * este pais.
	 * @param strings 
	 * @param nome: Nome do pais.
	 * @param c: Continente do pais.
	 * @param tipoCarta: Simbolo da carta deste pais.
	 * @return Objeto pais instanciado.
	 */
	public Pais createPais(String nome, Continente c, String tipoCarta){
		//Instancia o objeto pais
		Pais p1 = new Pais(nome, c);
		
		//Adciona o pais ao continente
		c.addPais(p1);
		
		//Cria a carta do pais
		Carta c1 = new Carta(p1, tipoCarta);
		p1.setCarta(c1);
		
		//ADCIONA NO HASH MAP
		paisesCriados.put(nome,p1);
		
		return p1;
	}
}
