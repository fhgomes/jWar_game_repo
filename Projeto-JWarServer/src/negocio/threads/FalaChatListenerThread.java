package negocio.threads;

import java.util.Vector;

import negocio.beans.Jogador;
import negocio.repositorio.FabricaComunicacao;

/**
 * @author Fernando Gomes
 * Esta thread é um observer, que observa todos os Jogadores,
 * quando startada, avisa cada chatListener de sua açao.
 *
 */
public class FalaChatListenerThread extends Thread {
	
	private Vector<Jogador> jogadores;
	private Jogador jFalando;
	private String msg;
	
	public FalaChatListenerThread (Jogador j , String msg, Vector<Jogador> jogadores ) {
		this.jFalando = j;
		this.jogadores = jogadores;
		this.msg = msg;
	}
	
	public void run() {
		for(Jogador j: jogadores) {
			System.out.println(j.getNickname());
			if(j.isConectado()) {
				System.out.println("esta conectado");
				/* Método alguemFalou é o observavel */
				FabricaComunicacao.getFabricaListener(j.getTipoConexao()).getChatObserve(j).alguemFalou(jFalando.getNickname(), msg);
			}			
		}
	}
	
}
