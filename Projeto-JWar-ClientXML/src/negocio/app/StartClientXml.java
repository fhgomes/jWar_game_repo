	package negocio.app;

import gui.login.FrameLogin;
import gui.util.RepositorioFrames;
import infraestrura.comunicacao.ClientSession;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class StartClientXml {
    
    public static void main(String[] args){
    	ClientSession.getSession();
    	
    	try{
    		ClientSession.getSession().getServerPrincipal();
    	}catch (Exception e) {
    		JOptionPane.showMessageDialog(new JDialog(), "O Servidor JWAR nao pode ser alcançado" ,
					"Erros", JOptionPane.ERROR_MESSAGE);
    	}
		
		RepositorioFrames.getRepositorio().show("Login", new FrameLogin());
	}
}
