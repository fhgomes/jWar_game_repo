package negocio.util.imagens;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * 
 * @author Fernando Gomes
 *
 */
public class ImageUtil {
	public static String CAMINHO = "C:/Arquivos de programas/eWar 3.1/Skins/Original/";
	private static BufferedImage imagem;
	
	/**
	 * 
	 * @param nome -> Nome da imagen
	 * @return BufferedImage imagen
	 */
	public static BufferedImage getImagen(String nome){
        imagem= null;
          try{
            imagem = ImageIO.read(
              new File(CAMINHO + nome +".jpg"));
          }
          catch(IOException exc){
            JOptionPane.showMessageDialog(null,
              "Erro ao carregar a imagem: " +
              exc.getMessage());
          }
          return imagem;
    }
	
	/**
	 * Desenha uma imagen em um componente grafico.
	 * @param imagem -> Imagen a ser pintada
	 * @param c -> Componente a receber o desenho
	 */
	public static void desenhar(BufferedImage imagem, Component c){
	    Graphics g = c.getGraphics();   
	    g.drawImage(imagem, 0, 0, c);
	}
}
