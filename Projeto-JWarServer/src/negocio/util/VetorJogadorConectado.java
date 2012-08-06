package negocio.util;

import java.util.Iterator;
import java.util.Vector;

import negocio.beans.Jogador;


public class VetorJogadorConectado extends Vector<Jogador>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VetorJogadorConectado() {
		super();
	}
	
	@Override
	public void add(int index, Jogador element) {
		if(element.isConectado())
			super.add(index, element);
	}

	@Override
	public synchronized boolean add(Jogador e) {
		if(e.isConectado())
			return super.add(e);
		else return false;
	}

	@Override
	public Iterator<Jogador> iterator() {
		return new JogadorConectadoIterator(this);
	}

}
