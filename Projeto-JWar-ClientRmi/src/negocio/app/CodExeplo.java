package negocio.app;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

public class CodExeplo {
	
	public CodExeplo() throws ConfigurationException {
		   // Lemos os dados de configuração. O arquivo deve estar no mesmo diretório que a aplicação. 
			   PropertiesConfiguration config = new PropertiesConfiguration("app.windows.properties"); 

			   // A seguinte instrução se imprimirá: 800 
			   System.out.println(config.getInt("main.mdi.width")); 

			   // A seguinte instrução se imprimirá: Minha aplicação de proba 
			   System.out.println(config.getString("main.mdi.title"));	

			   // A seguinte instrução imprimirá: Castellano 
			   System.out.println(config.getStringArray("language")[0]); 

			   // A seguinte instrução configura o objeto para que salve as propriedades 
			   // automaticamente em sua origem (Neste caso um arquivo) quando se atualizem 
			   // ou quando se agregem novas propriedades 
			   config.setAutoSave(true); 

			   // Adicionamos duas propriedades 
			   config.addProperty("version", "1.0");	
			   config.addProperty("author", "Carlos García Pérez"); 

			   // Não faz falta graças a que está estabelecida a propriedade autoSave 
			   // config.save(); 

			
 
			   // Lemos os dados de configuração. O arquivo deve estar no mesmo diretório que a aplicação. 
			   XMLConfiguration config2 = new XMLConfiguration("app.windows.properties.xml"); 

			   // A seguinte instrução imprimirá: 800 
			   System.out.println(config2.getInt("mainmdi.dimension.width")); 

			   // A seguinte instrução imprimirá: Minha aplicação de prova 
			   System.out.println(config2.getString("mainmdi.title")); 

			   // A seguinte instrução imprimirá: Castellano 
			   System.out.println(config2.getString("languages[@default]")); 

			   // A seguinte instrução imprimirá: 3 
			   System.out.println(((java.util.List) config.getProperty("languages.language")).size()); 

			   // A seguinte instrução imprimirá: French 
			   System.out.println(config2.getString("languages.language(2)")); 

			   // A seguinte instrução imprimirá: 320 
			   // Observe que devido a que o elemento contém um ponto em seu nome 
			   // devemos acessá-lo escapando o ponto mediante .. 
			   System.out.println(config2.getInt("printer..form.dimension.width")); 

			   // A seguinte instrução configura o objeto para que salve as propriedades 
			   // automaticamente em sua origem (Neste caso um arquivo) quando se atualizarem 
			   // ou quando se agregarem novas propriedades 
			   config2.setAutoSave(true); 

			   // Mudamos o jogo de caracteres, pois usaremos propriedades 
			   // que precisam de acentos. 
			   config2.setEncoding("ISO-8859-1"); 

			   // Adicionamos duas propriedades 
			   // Adicionamos a propriedade 1.0 que descende da raiz 
			   config2.addProperty("version", "1.0"); 

			   // Adicionamos a propriedade Carlos García Pérez que descende da raiz 
			   config2.addProperty("author", "Carlos García Pérez"); 

			   // Não faz falta graças a que está estabelecida a propriedade autoSave estabelecida 
			   // config.save(); 
	}	

}


