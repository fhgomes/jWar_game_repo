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
	 * CRIAÇAO DOS CONTINENTES E PAISES EM OBJETOS.
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
		fp.createPais("México", americaDoNorte, Carta.QUADRADO);
		fp.createPais("Nova York", americaDoNorte, Carta.TRIANGULO);
		fp.createPais("California", americaDoNorte, Carta.QUADRADO);
		fp.createPais("Vancouver", americaDoNorte, Carta.TRIANGULO);
		fp.createPais("Ottawa", americaDoNorte, Carta.BOLA);
		fp.createPais("Labrador", americaDoNorte, Carta.QUADRADO);
		fp.createPais("Mackenzie", americaDoNorte, Carta.BOLA);
		fp.createPais("Alaska", americaDoNorte, Carta.TRIANGULO);
		fp.createPais("Groênlandia", americaDoNorte, Carta.BOLA);
		
		Continente europa = new Continente(Continente.EUROPA, 5);
		fp.createPais("Islândia", europa, Carta.TRIANGULO);
		fp.createPais("Inglaterra", europa, Carta.BOLA);
		fp.createPais("Suécia", europa, Carta.BOLA);
		fp.createPais("Alemanha", europa, Carta.BOLA);
		fp.createPais("Portugal", europa, Carta.QUADRADO);
		fp.createPais("Moscou", europa, Carta.TRIANGULO);
		fp.createPais("Polônia", europa, Carta.QUADRADO);
		
		Continente africa = new Continente(Continente.AFRICA, 3);
		fp.createPais("Argélia", africa, Carta.BOLA);
		fp.createPais("Egito", africa, Carta.TRIANGULO);
		fp.createPais("Sudão", africa, Carta.QUADRADO);
		fp.createPais("Congo", africa, Carta.QUADRADO);
		fp.createPais("Africa do Sul", africa, Carta.TRIANGULO);
		fp.createPais("Madagascar", africa, Carta.BOLA);
		
		Continente oceania = new Continente(Continente.OCEANIA, 2);
		fp.createPais("Sumatra", oceania, Carta.QUADRADO);
		fp.createPais("Borneo", oceania, Carta.QUADRADO);
		fp.createPais("Nova Guiné", oceania, Carta.BOLA);
		fp.createPais("Austrália", oceania, Carta.TRIANGULO);
		
		Continente asia = new Continente(Continente.ASIA, 7);
		fp.createPais("O. Médio", asia, Carta.QUADRADO);
		fp.createPais("Índia", asia, Carta.QUADRADO);
		fp.createPais("Vietnã", asia, Carta.TRIANGULO);
		fp.createPais("China", asia, Carta.BOLA);
		fp.createPais("Aral", asia, Carta.TRIANGULO);
		fp.createPais("Japão", asia, Carta.QUADRADO);
		fp.createPais("Tchita", asia, Carta.TRIANGULO);
		fp.createPais("Mongólia", asia, Carta.BOLA);
		fp.createPais("Sibéria", asia, Carta.TRIANGULO);
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
//		// o arquivo encontra-se no mesmo diretório //da aplicação  
//		File fFronteiras = new File("fronteiras.properties");      
//		Properties pFronteiras = new Properties();  
//		FileInputStream fis = null;  
//		try {  
//		    fis = new FileInputStream(fFronteiras);  
//		    //lê os dados que estão no arquivo  
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
		
		fronteiras.put("Brasil",new String[]{"Argentina","Chile","Colombia","Argélia"});
		fronteiras.put("Argentina",new String[]{"Brasil", "Chile"});
		fronteiras.put("Chile",new String[]{"Brasil", "Argentina", "Colombia"});
		fronteiras.put("Colombia",new String[]{"Chile", "Brasil", "México"});
		fronteiras.put("México",new String[]{"Colombia", "Nova York", "California"});
		fronteiras.put("California",new String[]{"México", "Nova York", "Ottawa", "Vancouver"});
		fronteiras.put("Nova York",new String[]{"México", "California", "Labrador", "Ottawa"}); 
		fronteiras.put("Labrador",new String[]{"Nova York", "Groênlandia", "Ottawa" });
		fronteiras.put("Ottawa",new String[]{"Labrador", "Nova York", "California", "Vancouver", "Mackenzie"});
		fronteiras.put("Vancouver",new String[]{"California", "Ottawa", "Alaska", "Mackenzie"});
		fronteiras.put("Mackenzie",new String[]{"Alaska", "Vancouver", "Ottawa", "Groênlandia"});
		fronteiras.put("Groêlandia",new String[]{"Mackenzie", "Labrador", "Islândia"});
		fronteiras.put("Islândia",new String[]{"Groênlandia", "Inglaterra"});
		fronteiras.put("Inglaterra",new String[]{"Islândia", "Suécia", "Alemanha", "Portugal"});
		fronteiras.put("Suécia",new String[]{"Inglaterra", "Moscou"});
		fronteiras.put("Alemanha",new String[]{"Inglaterra", "Polônia","Portugal"});
		fronteiras.put("Moscou",new String[]{"Polônia", "Suécia", "Omsk", "Aral", "O. Médio" });
		fronteiras.put("Polônia",new String[]{"Moscou", "O. Médio", "Egito", "Alemanha", "Portugal"});
		fronteiras.put("Portugal",new String[]{"Alemanha", "Inglaterra", "Argélia", "Egito", "Polônia"});
		fronteiras.put("Argélia",new String[]{"Brasil", "Portugal", "Egito", "Sudão", "Congo"});
		fronteiras.put("Egito",new String[]{"Polônia", "Portugal", "O. Médio", "Argélia", "Sudão"});
		fronteiras.put("Sudão",new String[]{"Madagascar", "Egito", "Argélia", "Congo", "Africa do Sul"});
		fronteiras.put("Congo",new String[]{"Argélia", "Sudão", "Africa do Sul"});
		fronteiras.put("Africa do Sul",new String[]{"Congo", "Sudão", "Madagascar"});
		fronteiras.put("Madagascar",new String[]{"Sudão", "Africa do Sul"});
		fronteiras.put("O. Médio",new String[]{"Egito", "Polônia", "Moscou", "Aral", "Índia"});
		fronteiras.put("Aral",new String[]{"O. Médio", "Moscou", "Omsk", "Índia", "China"});
		fronteiras.put("Omsk",new String[]{"Moscou", "Aral", "China", "Mongólia", "Dudinka"});
		fronteiras.put("Índia",new String[]{"O. Médio", "Aral", "China", "Vietnã", "Sumatra"});
		fronteiras.put("Dudinka",new String[]{"Omsk", "Mongólia", "Tchita", "Sibéria"});
		fronteiras.put("Vietnã",new String[]{"China", "Índia", "Borneo" });
		fronteiras.put("China",new String[]{"Índia", "Vietnã", "Aral", "Mongólia", "Omsk", "Vladvostok", "Japão", "Tchita"});
		fronteiras.put("Borneo",new String[]{"Vietnã", "Nova Guiné", "Austrália"});
		fronteiras.put("Nova Guiné",new String[]{"Austrália", "Borneo"});
		fronteiras.put("Sumatra",new String[]{"Índia", "Austrália"});
		fronteiras.put("Austrália",new String[]{"Sumatra", "Borneo", "Nova Guiné"});
		fronteiras.put("Mongólia",new String[]{"China", "Omsk", "Dudinka", "Tchita"});
		fronteiras.put("Tchita",new String[]{"Mongólia", "Dudinka", "Sibéria", "Vladvostok", "China"});
		fronteiras.put("Japão",new String[]{"China", "Vladvostok"});
		fronteiras.put("Vladvostok",new String[]{"Japão", "China", "Tchita", "Sibéria", "Alaska" });
		fronteiras.put("Sibéria",new String[]{"Vladvostok", "Dudinka", "Tchita"});
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
