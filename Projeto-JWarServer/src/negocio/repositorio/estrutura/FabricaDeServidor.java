package negocio.repositorio.estrutura;

import infraestrutura.proxies.ObjectProxy;

import java.rmi.RemoteException;

import negocio.logistica.estrutura.Servidor;

public class FabricaDeServidor {
	
	public void criarServidor(String nome, Integer pont, Integer bonus) throws RemoteException {
		Servidor s = new Servidor(nome, pont, bonus);
		ObjectProxy.registraObjeto(s, s.toRegistry());
	}
}
