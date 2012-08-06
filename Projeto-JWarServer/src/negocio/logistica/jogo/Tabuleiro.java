package negocio.logistica.jogo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import negocio.beans.jogo.Carta;
import negocio.beans.jogo.Continente;
import negocio.beans.jogo.Objetivo;
import negocio.beans.jogo.Pais;
import negocio.repositorio.jogo.FabricaPais;

/**
 * 
 * @author Fernando Gomes
 *
 */
public class Tabuleiro {
	private HashMap<String,Pais> paises = new HashMap<String,Pais>(42,0);
	private HashMap<String, Continente> continentes = new HashMap<String,Continente>(6,0);
	private Vector<Carta> cartas = new Vector<Carta>(45,0);
	private Vector<Objetivo> objetivos = new Vector<Objetivo>(14,0);
	
	public Tabuleiro () {
		montarMapa();
		montarObjetivos();
	}
	/**
	 * CRIA�AO DOS CONTINENTES E PAISES EM OBJETOS.
	 * Adicionar os Paises aos continentes.
	 * Criar Carta para cada Pais
	 *  
	 */
	public void montarMapa(){
		FabricaPais fp = new FabricaPais();
		
		Continente americaDoSul = new Continente(Continente.AMERICA_DO_SUL, 2);
		fp.createPais("Brasil", americaDoSul, Carta.BOLA);
		fp.createPais("Argentina", americaDoSul,Carta.QUADRADO );
		fp.createPais("Chile", americaDoSul, Carta.TRIANGULO);
		fp.createPais("Colombia",americaDoSul, Carta.TRIANGULO);		
		
		Continente americaDoNorte = new Continente(Continente.AMERICA_DO_NORTE, 5);
		fp.createPais("M�xico", americaDoNorte, Carta.QUADRADO);
		fp.createPais("Nova York", americaDoNorte, Carta.TRIANGULO);
		fp.createPais("California", americaDoNorte, Carta.QUADRADO);
		fp.createPais("Vancouver", americaDoNorte, Carta.TRIANGULO);
		fp.createPais("Ottawa", americaDoNorte, Carta.BOLA);
		fp.createPais("Labrador", americaDoNorte, Carta.QUADRADO);
		fp.createPais("Mackenzie", americaDoNorte, Carta.BOLA);
		fp.createPais("Alaska", americaDoNorte, Carta.TRIANGULO);
		fp.createPais("Gro�nlandia", americaDoNorte, Carta.BOLA);
		
		Continente europa = new Continente(Continente.EUROPA, 5);
		fp.createPais("Isl�ndia", europa, Carta.TRIANGULO);
		fp.createPais("Inglaterra", europa, Carta.BOLA);
		fp.createPais("Su�cia", europa, Carta.BOLA);
		fp.createPais("Alemanha", europa, Carta.BOLA);
		fp.createPais("Portugal", europa, Carta.QUADRADO);
		fp.createPais("Moscou", europa, Carta.TRIANGULO);
		fp.createPais("Pol�nia", europa, Carta.QUADRADO);
		
		Continente africa = new Continente(Continente.AFRICA, 3);
		fp.createPais("Arg�lia", africa, Carta.BOLA);
		fp.createPais("Egito", africa, Carta.TRIANGULO);
		fp.createPais("Sud�o", africa, Carta.QUADRADO);
		fp.createPais("Congo", africa, Carta.QUADRADO);
		fp.createPais("Africa do Sul", africa, Carta.TRIANGULO);
		fp.createPais("Madagascar", africa, Carta.BOLA);
		
		Continente oceania = new Continente(Continente.OCEANIA, 2);
		fp.createPais("Sumatra", oceania, Carta.QUADRADO);
		fp.createPais("Borneo", oceania, Carta.QUADRADO);
		fp.createPais("Nova Guin�", oceania, Carta.BOLA);
		fp.createPais("Austr�lia", oceania, Carta.TRIANGULO);
		
		Continente asia = new Continente(Continente.ASIA, 7);
		fp.createPais("O. M�dio", asia, Carta.QUADRADO);
		fp.createPais("�ndia", asia, Carta.QUADRADO);
		fp.createPais("Vietn�", asia, Carta.TRIANGULO);
		fp.createPais("China", asia, Carta.BOLA);
		fp.createPais("Aral", asia, Carta.TRIANGULO);
		fp.createPais("Jap�o", asia, Carta.QUADRADO);
		fp.createPais("Tchita", asia, Carta.TRIANGULO);
		fp.createPais("Mong�lia", asia, Carta.BOLA);
		fp.createPais("Sib�ria", asia, Carta.TRIANGULO);
		fp.createPais("Dudinka", asia, Carta.BOLA);
		fp.createPais("Omsk", asia, Carta.QUADRADO);
		fp.createPais("Vladvostok", asia, Carta.BOLA);
		
		
		this.continentes.put(americaDoSul.getNome(), americaDoSul);
		this.paises.putAll(americaDoSul.getPaises());
		this.continentes.put(americaDoNorte.getNome(), americaDoNorte);
		this.paises.putAll(americaDoNorte.getPaises());
		this.continentes.put(africa.getNome(), africa);
		this.paises.putAll(africa.getPaises());
		this.continentes.put(europa.getNome(), europa);
		this.paises.putAll(europa.getPaises());
		this.continentes.put(asia.getNome(), asia);
		this.paises.putAll(asia.getPaises());
		this.continentes.put(oceania.getNome(), oceania);
		this.paises.putAll(oceania.getPaises());
		
		pegaCartas();
		montarFronteiras();
	}
	private void montarObjetivos() {
		//
	}
	private void montarFronteiras(){
//		// o arquivo encontra-se no mesmo diret�rio //da aplica��o  
//		File fFronteiras = new File("fronteiras.properties");      
//		Properties pFronteiras = new Properties();  
//		FileInputStream fis = null;  
//		try {  
//		    fis = new FileInputStream(fFronteiras);  
//		    //l� os dados que est�o no arquivo  
//		    pFronteiras.load(fis);    
//		    fis.close(); 
//		}  
//		catch (IOException ex) {  
//		    System.out.println(ex.getMessage());  
//		    ex.printStackTrace();  
//		}  
//		String fronteira = pFronteiras.getProperty("Brasil"); 
//		
		
		HashMap<String,String[]> fronteiras = new HashMap<String,String[]>();
		
		fronteiras.put("Brasil",new String[]{"Argentina","Chile","Colombia","Arg�lia"});
		fronteiras.put("Argentina",new String[]{"Brasil", "Chile"});
		fronteiras.put("Chile",new String[]{"Brasil", "Argentina", "Colombia"});
		fronteiras.put("Colombia",new String[]{"Chile", "Brasil", "M�xico"});
		fronteiras.put("M�xico",new String[]{"Colombia", "Nova York", "California"});
		fronteiras.put("California",new String[]{"M�xico", "Nova York", "Ottawa", "Vancouver"});
		fronteiras.put("Nova York",new String[]{"M�xico", "California", "Labrador", "Ottawa"}); 
		fronteiras.put("Labrador",new String[]{"Nova York", "Gro�nlandia", "Ottawa" });
		fronteiras.put("Ottawa",new String[]{"Labrador", "Nova York", "California", "Vancouver", "Mackenzie"});
		fronteiras.put("Vancouver",new String[]{"California", "Ottawa", "Alaska", "Mackenzie"});
		fronteiras.put("Mackenzie",new String[]{"Alaska", "Vancouver", "Ottawa", "Gro�nlandia"});
		fronteiras.put("Gro�landia",new String[]{"Mackenzie", "Labrador", "Isl�ndia"});
		fronteiras.put("Isl�ndia",new String[]{"Gro�nlandia", "Inglaterra"});
		fronteiras.put("Inglaterra",new String[]{"Isl�ndia", "Su�cia", "Alemanha", "Portugal"});
		fronteiras.put("Su�cia",new String[]{"Inglaterra", "Moscou"});
		fronteiras.put("Alemanha",new String[]{"Inglaterra", "Pol�nia","Portugal"});
		fronteiras.put("Moscou",new String[]{"Pol�nia", "Su�cia", "Omsk", "Aral", "O. M�dio" });
		fronteiras.put("Pol�nia",new String[]{"Moscou", "O. M�dio", "Egito", "Alemanha", "Portugal"});
		fronteiras.put("Portugal",new String[]{"Alemanha", "Inglaterra", "Arg�lia", "Egito", "Pol�nia"});
		fronteiras.put("Arg�lia",new String[]{"Brasil", "Portugal", "Egito", "Sud�o", "Congo"});
		fronteiras.put("Egito",new String[]{"Pol�nia", "Portugal", "O. M�dio", "Arg�lia", "Sud�o"});
		fronteiras.put("Sud�o",new String[]{"Madagascar", "Egito", "Arg�lia", "Congo", "Africa do Sul"});
		fronteiras.put("Congo",new String[]{"Arg�lia", "Sud�o", "Africa do Sul"});
		fronteiras.put("Africa do Sul",new String[]{"Congo", "Sud�o", "Madagascar"});
		fronteiras.put("Madagascar",new String[]{"Sud�o", "Africa do Sul"});
		fronteiras.put("O. M�dio",new String[]{"Egito", "Pol�nia", "Moscou", "Aral", "�ndia"});
		fronteiras.put("Aral",new String[]{"O. M�dio", "Moscou", "Omsk", "�ndia", "China"});
		fronteiras.put("Omsk",new String[]{"Moscou", "Aral", "China", "Mong�lia", "Dudinka"});
		fronteiras.put("�ndia",new String[]{"O. M�dio", "Aral", "China", "Vietn�", "Sumatra"});
		fronteiras.put("Dudinka",new String[]{"Omsk", "Mong�lia", "Tchita", "Sib�ria"});
		fronteiras.put("Vietn�",new String[]{"China", "�ndia", "Borneo" });
		fronteiras.put("China",new String[]{"�ndia", "Vietn�", "Aral", "Mong�lia", "Omsk", "Vladvostok", "Jap�o", "Tchita"});
		fronteiras.put("Borneo",new String[]{"Vietn�", "Nova Guin�", "Austr�lia"});
		fronteiras.put("Nova Guin�",new String[]{"Austr�lia", "Borneo"});
		fronteiras.put("Sumatra",new String[]{"�ndia", "Austr�lia"});
		fronteiras.put("Austr�lia",new String[]{"Sumatra", "Borneo", "Nova Guin�"});
		fronteiras.put("Mong�lia",new String[]{"China", "Omsk", "Dudinka", "Tchita"});
		fronteiras.put("Tchita",new String[]{"Mong�lia", "Dudinka", "Sib�ria", "Vladvostok", "China"});
		fronteiras.put("Jap�o",new String[]{"China", "Vladvostok"});
		fronteiras.put("Vladvostok",new String[]{"Jap�o", "China", "Tchita", "Sib�ria", "Alaska" });
		fronteiras.put("Sib�ria",new String[]{"Vladvostok", "Dudinka", "Tchita"});
		fronteiras.put("Alaska",new String[]{"Vladvostok", "Mackenzie", "Vancouver"});
		
		for (Pais p :paises.values()){
			for(String paisF: fronteiras.get(p.getNome())){
				p.addFronteira(paises.get(paisF));
				System.out.println(p.getNome() +"--add->"+paisF);
			}
		}
	}
	public void pegaCartas(){
		Iterator iPais = this.paises.values().iterator();
		while(iPais.hasNext()){
			Pais p = (Pais) iPais.next();
			cartas.add(p.getCarta());
		}
		Carta coringa1 = new Carta(null, Carta.CORINGA);
		Carta coringa2 = new Carta(null, Carta.CORINGA);
		Carta coringa3 = new Carta(null, Carta.CORINGA);
		cartas.add(coringa1);
		cartas.add(coringa2);
		cartas.add(coringa3);
	}
	public HashMap<String, Pais> getPaises() {
		return this.paises;
	}
	public Vector<Carta> getCartas() {
		return this.cartas;
	}
	public Vector<Objetivo> getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(Vector<Objetivo> objts) {
		this.objetivos = objts;
	}
	public HashMap<String,Continente> getContinentes() {
		return continentes;
	}

}
