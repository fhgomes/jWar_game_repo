package infraestrutura.comunicacao.acoes.rmi.estrutura;

import infraestrutura.proxies.ObjectProxy;
import interfaces.negocio.ISalaRmi;

import java.rmi.RemoteException;

import negocio.logistica.estrutura.Sala;

public class SalaActionRmi implements ISalaRmi{

	@Override
	public void acionarBanner(String nomeSala, String jog) throws RemoteException {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		sala.acionarBanner(jog);
	}

	@Override
	public void escrever(String nomeSala, String jog, String texto)throws RemoteException {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		sala.escrever(jog, texto);
	}

	@Override
	public boolean inicar(String nomeSala) throws RemoteException {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		return sala.inicar();
	}

	@Override
	public boolean mudarDeCor(String nomeSala, String jog, int cor)throws RemoteException {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		return false;
	}

	@Override
	public void sair(String nomeSala, String jog) throws RemoteException {
		Sala sala = (Sala) ObjectProxy.resgataObjeto(nomeSala);
		
	}

}
