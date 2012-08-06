package negocio.beans;

import interfaces.gui.estrutura.sala.ISalaGUI;

/**
 * 
 * @author Fernando Gomes <br/><br/>
 * Nao extends Jogador pois precisa da referencia de jogador para fazer
 * comparaçoes posteriormente. Tem uma referencia para jogador dentro de si.
 * <br/>
 */
public class JogadorDaSala  {
	public static final int verde = 1;
	public static final int vermelho = 2;
	public static final int azul = 3;
	public static final int branco = 4;
	public static final int preto = 5;
	public static final int amarelo = 6;
	
	private Jogador jogador;
	private boolean pronto;
	private int cor;
	private Integer bonusFinal;

	private ISalaGUI salaListener;
	
	public void ficarPronto(){
		pronto = true;
	}
	public JogadorDaSala (Jogador j){
		this.jogador = j;
		this.pronto = false;
		this.bonusFinal = 0;
	}
	/**public JogadorDaSala(JogadorDaSala j){
		super(j.getNickName(), j.getEmail(), j.getNome(), j.getPontos());
		this.cor = j.getCor();
	}**/
	public boolean isPronto() {
		return pronto;
	}
	public void setPronto(boolean pronto) {
		this.pronto = pronto;
	}
	public int getCor() {
		return cor;
	}
	public void setCor(int cor) {
		this.cor = cor;
	}
	public Jogador getJogador(){
		return this.jogador;
	}
	public void addBonus(Integer bonus) {
		this.bonusFinal = bonus;
	}
	public Integer getBonusFinal(){
		return this.bonusFinal;
	}
	public ISalaGUI getSalaListener() {
		return salaListener;
	}
	public void setSalaListener(ISalaGUI salaListener) {
		this.salaListener = salaListener;
	}
}
