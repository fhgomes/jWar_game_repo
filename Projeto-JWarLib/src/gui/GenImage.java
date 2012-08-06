package gui;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GenImage 
{
	public static String DIRETORIO_PADRAO = "/images/";
	public static String FRAME_ICON = "icon.png";
	
	private String diretorioPadrao = DIRETORIO_PADRAO;
	private String frameIcon       = FRAME_ICON;
	
	private Image icon = null;
	
	private static GenImage img;
	
	private GenImage () {}
	
	public static GenImage getInstance()
	{
		if (img == null)
			img = new GenImage();
		return img;
	}
	
	
	public Image getImageDir(String arquivo)
	{
		return getImage(diretorioPadrao+arquivo);		
	}
	
	public Image getImage(String arquivo)
	{
		try {
			InputStream is= this.getClass().getResourceAsStream(arquivo);
			return ImageIO.read(is);
		} catch(IOException e) {
			System.out.println("Não foi possível carregar o arquivo \"" + arquivo + "\""+ e);
		}
		
		return null;		
	}
	
	public Image getImageByName(String name){
		return getImage(diretorioPadrao+name);
	}
	
	public ImageIcon getIconByName(String name){
		return createImageIcon(diretorioPadrao+name);
	}
	
	public ImageIcon createImageIcon(String filename, String description) {
		return new ImageIcon(getImage(filename), description);
		//return new ImageIcon(getClass().getResource(filename), description);		
	}
	
	public ImageIcon createImageIcon(String filename) {
		return new ImageIcon(getImage(filename));		
	}
	
	public Image getFrameIcon (){
		if (icon==null)
			icon = getImage(diretorioPadrao+frameIcon);
		
		return icon;
	}
	
	public ImageIcon createIconByResource(String filename) {
		return new ImageIcon(this.getClass().getResource(filename));		
	}
	

	public String getDiretorioPadrao() {
		return diretorioPadrao;
	}

	public void setDiretorioPadrao(String diretorioPadrao) {
		this.diretorioPadrao = diretorioPadrao;
	}

	public void setFrameIcon(String frameIcon) {
		this.frameIcon = frameIcon;
	}
}