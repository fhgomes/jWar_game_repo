package negocio.util;

import java.util.Vector;

import negocio.beans.Jogador;

/** Padrao Iterator **/
public class JogadorConectadoIterator implements IJogadoresIterator{

	private Vector<Jogador> jogadores = new Vector<Jogador>();
	private int position = -1;
	
	public JogadorConectadoIterator(Vector<Jogador> jogs) {
		this.jogadores = jogs;
	}
	
	@Override
	public boolean hasNext() {
		System.out.println("wow for it usa o hasNext");
		try{
			if(jogadores.get(position+1) != null)
				if(jogadores.get(position+1).isConectado())
				return true;
		}catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Jogador next() {
		position ++;
		Jogador j = jogadores.get(position);		
		if(j.isConectado())
			return j;
		else
			if(position < jogadores.size())
				return next();
			else return null;
	}

	@Override
	public void remove() {
		Jogador j = jogadores.remove(position);
		j.setConectado(false);
		position--;
	}

	@Override
	public boolean hasNextDesconectado() {
		if(jogadores.get(position+1) != null)
			if(!jogadores.get(position+1).isConectado())
				return true;
		return false;
	}

	@Override
	public Jogador nextDescontecado() {
		Jogador j = jogadores.get(position);
		position ++;
		if(!j.isConectado())
			return j;
		else
			if(position < jogadores.size())
				return nextDescontecado();
			else return null;
	}

	@Override
	public void reConnect() {
		Jogador j = jogadores.get(position);
		j.setConectado(true);
	}
	
	@Override
	public void desConnect() {
		Jogador j = jogadores.get(position);
		j.setConectado(false);
	}

}
