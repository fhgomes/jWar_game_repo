package gui;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class FrameConfig {
    private Window janela;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static String LOOK_AND_FEEL_METAL="javax.swing.plaf.metal.MetalLookAndFeel";
    public static String LOOK_AND_FEEL_WINDOWS="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public static String LOOK_AND_FEEL_MOTIF="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    public static String LOOK_AND_FEEL_GTK="com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    public static String LOOK_AND_FEEL_WINDOWS_XP="com.jgoodies.looks.plastic.PlasticXPLookAndFeel";
    
    public FrameConfig(){
               
    };
    
    
    public FrameConfig(Window janela, boolean exibir){
        this();
        this.janela = janela;
//        fecha();
        centraliza(exibir);
        //setIcon(janela);
    }  
   
    public static void setIcon(Window janela){
        
    	Image icon = GenImage.getInstance().getFrameIcon();
    	
        if(icon==null)
            return;
        if(janela instanceof JFrame){
            ((JFrame)janela).setIconImage(icon);
        }
    }

//    public void fecha() {
//        janela.addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent e){
//                janela.dispose();
//            }
//        });
//    }
    
    public void centraliza(boolean exibir) {
        Dimension frameSize = janela.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        janela.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        janela.setVisible(exibir);
    }
    
    public static void setLookAndFeel(String look) 
    {
        if(look==null)
            look=LOOK_AND_FEEL_WINDOWS_XP;
        try {
            UIManager.setLookAndFeel(look);
        }
        catch(Exception e) {
            System.err.println("Erro setando a look and feel:"+look);
        }
    }
    
    public Point pontoCentro(int comp, int altura){
        Point tamanho = new Point((screenSize.width - comp) / 2, (screenSize.height - altura) / 2);
        return( tamanho );
    }
    
    public static JFrame getFramePadrao(){
    	
    	JFrame frame = new JFrame();
    	setIcon(frame);
    	return frame;
    }
}