package negocio.beans.jogo;

import java.util.Vector;


/**
 * @author Fernando Gomes
 * <br/>
 */
public class Objetivo {
	private String nome;
	private int tipo;
	private Vector instrucoes = new Vector();
	private JogadorDoJogo donoDoObjetivo;
	
	public Objetivo(String nome, int tipo, Vector instrucoes) {
		this.nome = nome;
		this.tipo = tipo;
		this.instrucoes = instrucoes;
	}

	public Vector getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(Vector instrucoes) {
		this.instrucoes = instrucoes;
	}

	public JogadorDoJogo getDonoDoObjetivo() {
		return donoDoObjetivo;
	}

	public void setDonoDoObjetivo(JogadorDoJogo donoDoObjetivo) {
		this.donoDoObjetivo = donoDoObjetivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
