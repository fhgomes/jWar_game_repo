package negocio.app;

import exceptions.GenericException;
import exceptions.infraestrutura.LoginException;
import gui.login.FrameLogin;
import gui.util.GuiFactory;
import gui.util.RepositorioFrames;
import infraestrura.comunicacao.ClientSession;

import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import negocio.logistica.acao.Command;
import negocio.logistica.acao.ServidorCommand;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class StartClientRmi {
    
	private static Logger logger=Logger.getLogger(StartClientRmi.class.getName());
	
    public static void main(String[] args){
    	
    	
    	try {
			BasicConfigurator.configure(new org.apache.log4j.FileAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN), "../log/app.log"));
		} catch (IOException e1) {
			try {
				BasicConfigurator.configure(new org.apache.log4j.FileAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN), "./log/app.log"));
			} catch (IOException e2) {
				e1.printStackTrace();
			}
		}
		
		logger.info("start");
		ClientSession.getSession();
    	try {
			ClientSession.getSession().getServerPrincipal();
		} catch (RemoteException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JDialog(), "O Servidor JWAR nao pode ser alcançado" ,
					"Erros", JOptionPane.ERROR_MESSAGE);
		} catch (NotBoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JDialog(), "O Servidor JWAR esta fora do ar",
					"Erros", JOptionPane.ERROR_MESSAGE);
		}
		getOptions(args);
    	
    	
    	logger.debug("fim");
	}

    private static void startFrame() {
		// =============== START ================= \\\
		RepositorioFrames.getRepositorio().show(GuiFactory.LOGIN);
	}
	
    private static void getWithConfig(){
    	
    	// Lemos os dados de configuração. O arquivo deve estar no mesmo diretório que a aplicação. 
		   PropertiesConfiguration config;
		   
		   File f = new File("../exe/confLogin.properties");
		   System.out.println(f.length());
		try {
			config = new PropertiesConfiguration(f);
			startWithConfig(config);
		} catch (ConfigurationException e) {
			try {
				config = new PropertiesConfiguration("../exe/confLogin.properties");
				startWithConfig(config);
			} catch (ConfigurationException e1) {
				e1.printStackTrace();
			}
		} 
	}
    
    private static void startWithConfig(PropertiesConfiguration config) {
    	String email = config.getString("email");
		   String senha = config.getString("senha");
		   String servidor = config.getString("email");
		   
		   if(email == null || email.equals("") || senha == null || senha.equals("")) {
			startFrame();
			return;
		   }
		   System.out.println(email+"--"+senha);
		   if(servidor != null) {
			   if(servidor.equals("Academia")||servidor.equals("Pearl Harbor")
					   ||servidor.equals("Normandia")||servidor.equals("Iwo Jima")
					   ||servidor.equals("Okinawa")){
				   logIn(servidor, email, senha);
			   }else {
				   logIn("Academia", email, senha);
			   }
		   }else {
			   logIn("Academia", email, senha);
		   }
		   config.setAutoSave(true); 

//		   // Adicionamos duas propriedades 
//		   config.addProperty("version", "1.0");	
//		   config.addProperty("author", "JwarTest"); 
    }

	private static void logIn(String servidor, String email, String senha) {
		RepositorioFrames.getRepositorio().show(GuiFactory.CHAT, false);
	    Command c = new ServidorCommand(servidor, email, senha, 
	    									RepositorioFrames.getRepositorio().getFrame(GuiFactory.CHAT));
			try {				
				c.executeCommand(null);
				RepositorioFrames.getRepositorio().show(GuiFactory.CHAT, true);
				
			} catch (GenericException e) {
				if(e.getTipo() == LoginException.class) {
					RepositorioFrames.getRepositorio().show(GuiFactory.LOGIN);
					FrameLogin fl = (FrameLogin)RepositorioFrames.getRepositorio().getFrame(GuiFactory.LOGIN);
					fl.changeStatus(e.getMessage());
					
				}else{
					if(e.getTipo() == RemoteException.class) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Impossível Conectar ao servidor",
								"Erros", JOptionPane.ERROR_MESSAGE);
					}else{
						if(e.getTipo() == NotBoundException.class) {
							JOptionPane.showMessageDialog(null, "Servidor Fora do Ar",
									"Erros", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		
	}

	private static void getOptions(String[] args) {
		try {
			Options options = new Options();
	    	CommandLineParser parser = new GnuParser();
	    	
	    	Option conf = new Option("conf", "Usar arquivo de configuração");
	    	Option params = new Option("params", "Passar os parametros por linha de comando");
	    	Option property  = OptionBuilder.withArgName("email").hasArgs(2)
	    						.withValueSeparator().withDescription("nome do arquivo de configuração").create("D");
	    	
	    	Option property1  = OptionBuilder.withArgName("senha").hasArgs(2)
			.withValueSeparator().withDescription("nome do arquivo de configuração").create("D");
	    	
	    	Option property2  = OptionBuilder.withArgName("servidor").hasArgs(2)
			.withValueSeparator().withDescription("nome do arquivo de configuração").create("D");
	    	
	    	
	    	options.addOption(property);
	    	options.addOption(property1);
	    	options.addOption(property2);
	    	options.addOption(conf);
	    	options.addOption(params);
	    	
			CommandLine cmd = parser.parse(options, args);
			
//			for(String arg_: args) {
//				System.out.println("arg_"+arg_);
//			}
						
						
//			Properties p1 = cmd.getOptionProperties("senha");
//			for(Enumeration e=p.elements();e.hasMoreElements();){
//				String s= (String)e.nextElement();
//				System.out.println("prop="+s);
//			}
//			
//			Properties p2 = cmd.getOptionProperties("servidor");
//			for(Enumeration e=p.elements();e.hasMoreElements();){
//				String s= (String)e.nextElement();
//				System.out.println("prop="+s);
//			}
			
			if( cmd.hasOption("conf") ) {
				System.out.println("CONF");
			   getWithConfig();
			}else {
				if( cmd.hasOption("params") ) {
					System.out.println("PARAMNS");
					Properties p = cmd.getOptionProperties("D");
					String senha = p.getProperty("senha");
					String email = p.getProperty("email");
					String servidor = p.getProperty("servidor");
					startWithParams(servidor, senha, email);
				}else{
					startFrame();
				}
				
			}
		
    	} catch (ParseException e2) {
			System.out.println("deu merda nas options");
			e2.printStackTrace();
    	}
	}

	private static void startWithParams(String servidor, String senha, String email) {
		
	}
}

