package gui.util;

import gui.FrameConfig;

import java.awt.Window;
import java.util.HashMap;

public class RepositorioFrames {
	public static RepositorioFrames repositorio;
	private HashMap<String, Object> frames = new HashMap<String, Object>();
	
	public static RepositorioFrames getRepositorio() {
		if(repositorio == null) {
			repositorio = new RepositorioFrames();
		} 
		return repositorio;
	}
	
	public void show(String s, Window o, boolean exibir) {
		if(frames.get(s)==null) {
			FrameConfig fc = new FrameConfig(o, exibir);
			frames.put(s, o);
		}else{
			((Window)frames.get(s)).setVisible(true);
		}
		
	}
	
	public void show(String s, Window o) {
		if(frames.get(s)==null) {
			FrameConfig fc = new FrameConfig(o, true);
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
