package negocio.util;

import java.util.Iterator;

import negocio.beans.Jogador;

/** Padrao Iterator **/
public interface IJogadoresIterator extends Iterator<Jogador>{

	public boolean hasNextDesconectado();
	public Jogador nextDescontecado();
	public void reConnect();
	public void desConnect();
}
