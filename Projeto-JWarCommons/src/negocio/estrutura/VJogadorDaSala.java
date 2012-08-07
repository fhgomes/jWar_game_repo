package negocio.estrutura;

import java.io.Serializable;


public class VJogadorDaSala implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int verde = 1;
	public static final int vermelho = 2;
	public static final int azul = 3;
	public static final int branco = 4;
	public static final int preto = 5;
	public static final int amarelo = 6;
	
	private String nome;
	private int cor;
	
	public VJogadorDaSala(String nome, int cor) {
		this.cor = cor;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}

}
