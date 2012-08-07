package interfaces.negocio.jogo;

import interfaces.negocio.IJogador;

import java.util.Vector;

import exceptions.logistica.JogoException;

public interface IJogoXml {
	public void atacar(IJogadorDoJogo jogAtacante, IPais defensor, Vector<IPais> atacantes, Integer qtdDados) throws JogoException;
	public void mover(IJogadorDoJogo jogMovimentando, IPais origem, IPais destino, int quantidade) throws JogoException;
	public void adcionarExercitos(IPais receptor, int qtd);
	
	public void pararDeAtacar();
	public void proximoJogador();
	
	public void naoTrocarCartas();
	public void trocarCartas(ICarta[] cartas, IJogadorDoJogo requisitante);
	
	public void falarAoChat(String msg, IJogador jogador);
	public void reportarFalha(String msg);
		
	public void sair();
	
	public IPais getPais(String nomePais);
}
