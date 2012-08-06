package infraestrutura.proxies;

import negocio.beans.Jogador;

public class JogadorProxy {
	public static Jogador procuraServer(String registry) {
		Jogador j = (Jogador) ObjectProxy.resgataObjeto(registry);
		if(j != null) {
			System.out.println("Jogador encontrado");
			return j;
		}
		System.out.println("JogadorNaoEncontrado");
		return null;
	}
}
