package gui.util;

import java.awt.Window;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GuiFactory {

	private static final String PACK_GUI ="gui";
	
	private static final String GUI_ESTRUTURA = PACK_GUI+".estrutura";
	private static final String GUI_LOGIN = PACK_GUI+".login";
	
	
	public static final String LOGIN = GUI_LOGIN+".FrameLogin";
	public static final String CADASTRO = GUI_LOGIN+".FrameCadastroJogador";
	public static final String CHAT = GUI_ESTRUTURA+".FrameChat";
	
	protected static Window createWindow(String nome) {
		Window w = null;
		try {
			Class clazz = Class.forName(nome);
			Constructor constructor = clazz.getConstructor(new Class[]{});
			w = (Window)constructor.newInstance(new Object[]{});
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return w;
		
	}
}
