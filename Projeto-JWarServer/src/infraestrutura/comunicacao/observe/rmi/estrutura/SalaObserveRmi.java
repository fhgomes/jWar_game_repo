package infraestrutura.comunicacao.observe.rmi.estrutura;

import interfaces.gui.estrutura.sala.rmi.ISalaGuiRmi;

import java.rmi.RemoteException;

import negocio.beans.JogadorDaSala;
import negocio.estrutura.VJogadorDaSala;
import negocio.logistica.acoes.estrutura.SalaObserve;

public class SalaObserveRmi extends SalaObserve{
	
	public SalaObserveRmi(JogadorDaSala jds) {
		j = jds;
	}

	@Override
	public void alguemEntrou(VJogadorDaSala usuario) {
		ISalaGuiRmi listener = (ISalaGuiRmi) j.getSalaListener();
		try {
			listener.alguemEntrou(usuario);
		} catch (RemoteException e) {
			//TODO DESCONECTAR O CARA
			e.printStackTrace();
		}
	}

	@Override
	public void alguemFalou(String falando, String msg) {
		ISalaGuiRmi listener = (ISalaGuiRmi) j.getSalaListener();
		try {
			listener.alguemFalou(falando, msg);
		} catch (RemoteException e) {
			// TODO DESCONECTAR O CARA
			e.printStackTrace();
		}
		
	}
}
