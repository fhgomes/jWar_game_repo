package gui.util;

import gui.FrameConfig;

import java.awt.Window;
import java.util.HashMap;

public class RepositorioFrames {
	/** Singleton */
	public static RepositorioFrames repositorio;
	private HashMap<String, Object> frames = new HashMap<String, Object>();
	
	public static RepositorioFrames getRepositorio() {
		if(repositorio == null) {
			repositorio = new RepositorioFrames();
		} 
		return repositorio;
	}
	
	public void show(String s) {
		show(s, true);	
	}
	
	public void show(String s, boolean exibir) {
		if(frames.get(s)==null) {
			Window o = GuiFactory.createWindow(s);
			new FrameConfig(o, exibir);
			frames.put(s, o);
		}else{
			((Window)frames.get(s)).setVisible(true);
		}
		
	}
	
	public void modifyAndShow(Object o) {
		
	}
	
	public Object getFrame(String s) {
		return frames.get(s);
	}
}
