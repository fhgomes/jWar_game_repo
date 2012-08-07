package negocio.app;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

public class CodExeplo {
	
	public CodExeplo() throws ConfigurationException {
		   // Lemos os dados de configura��o. O arquivo deve estar no mesmo diret�rio que a aplica��o. 
			   PropertiesConfiguration config = new PropertiesConfiguration("app.windows.properties"); 

			   // A seguinte instru��o se imprimir�: 800 
			   System.out.println(config.getInt("main.mdi.width")); 

			   // A seguinte instru��o se imprimir�: Minha aplica��o de proba 
			   System.out.println(config.getString("main.mdi.title"));	

			   // A seguinte instru��o imprimir�: Castellano 
			   System.out.println(config.getStringArray("language")[0]); 

			   // A seguinte instru��o configura o objeto para que salve as propriedades 
			   // automaticamente em sua origem (Neste caso um arquivo) quando se atualizem 
			   // ou quando se agregem novas propriedades 
			   config.setAutoSave(true); 

			   // Adicionamos duas propriedades 
			   config.addProperty("version", "1.0");	
			   config.addProperty("author", "Carlos Garc�a P�rez"); 

			   // N�o faz falta gra�as a que est� estabelecida a propriedade autoSave 
			   // config.save(); 

			
 
			   // Lemos os dados de configura��o. O arquivo deve estar no mesmo diret�rio que a aplica��o. 
			   XMLConfiguration config2 = new XMLConfiguration("app.windows.properties.xml"); 

			   // A seguinte instru��o imprimir�: 800 
			   System.out.println(config2.getInt("mainmdi.dimension.width")); 

			   // A seguinte instru��o imprimir�: Minha aplica��o de prova 
			   System.out.println(config2.getString("mainmdi.title")); 

			   // A seguinte instru��o imprimir�: Castellano 
			   System.out.println(config2.getString("languages[@default]")); 

			   // A seguinte instru��o imprimir�: 3 
			   System.out.println(((java.util.List) config.getProperty("languages.language")).size()); 

			   // A seguinte instru��o imprimir�: French 
			   System.out.println(config2.getString("languages.language(2)")); 

			   // A seguinte instru��o imprimir�: 320 
			   // Observe que devido a que o elemento cont�m um ponto em seu nome 
			   // devemos acess�-lo escapando o ponto mediante .. 
			   System.out.println(config2.getInt("printer..form.dimension.width")); 

			   // A seguinte instru��o configura o objeto para que salve as propriedades 
			   // automaticamente em sua origem (Neste caso um arquivo) quando se atualizarem 
			   // ou quando se agregarem novas propriedades 
			   config2.setAutoSave(true); 

			   // Mudamos o jogo de caracteres, pois usaremos propriedades 
			   // que precisam de acentos. 
			   config2.setEncoding("ISO-8859-1"); 

			   // Adicionamos duas propriedades 
			   // Adicionamos a propriedade 1.0 que descende da raiz 
			   config2.addProperty("version", "1.0"); 

			   // Adicionamos a propriedade Carlos Garc�a P�rez que descende da raiz 
			   config2.addProperty("author", "Carlos Garc�a P�rez"); 

			   // N�o faz falta gra�as a que est� estabelecida a propriedade autoSave estabelecida 
			   // config.save(); 
	}	

}


