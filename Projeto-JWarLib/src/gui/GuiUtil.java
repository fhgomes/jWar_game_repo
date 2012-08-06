package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class GuiUtil{
        
    
    /**
     * 
     * @return Componente para filtro do plano de contas
     */
    public static JFormattedTextField createPlanoContaField(){
        try{
            MaskFormatter mf=new MaskFormatter("##.##.###.###.######");
            mf.setPlaceholderCharacter('_');
            mf.setOverwriteMode(true);
            mf.setValueContainsLiteralCharacters(true);
            mf.setAllowsInvalid(false);
            JFormattedTextField ret=new JFormattedTextField(mf);
            return ret;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static JFormattedTextField createFormattedTextFieldMoeda(){
        
        JFormattedTextField ftf=new JFormattedTextField(){
            
        };
        return ftf;
    }
    
    public static JTextField createJTextField(){
        return new JTextField(){
            @Override
            public String getText(){
                return super.getText().replace('\'',' ').replace('|',' ').replace('\"',' ');
            }

            @Override
            public void setText(String t){
                if(t!=null){
                    t=t.replace('\'',' ').replace('|',' ').replace('\"',' ');
                }
                super.setText(t);
            }
        };      
    }
        
    
    public static void showErrorMessage(Window parent,String title,String erro){
        JOptionPane.showMessageDialog(parent, erro,title,JOptionPane.ERROR_MESSAGE);
    }
    
    public static Font font=new Font("Arial",Font.BOLD,12);
    public static JTable createJTable(){
        JTable jt=new JTable();
        jt.setRowMargin(0);
        jt.setRowHeight(20);
        jt.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jt.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jt.setFont(font);
        
        
        return jt;
    }
    
    public static boolean validaStringSomenteNumeros(String str){
    	
    	char[] chars = str.toCharArray();
    	for (int i = 0; i < chars.length; i++) {
			if (!("0123456789".contains(String.valueOf(chars[i]))))
				return false;
		}
    	
    	return true;
    }
    
    public static void centralizaTela(Window window){
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	Dimension frameSize = window.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        window.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);        
    }
    
}