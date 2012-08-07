package interfaces.negocio.jogo;



public interface IPais {
	public boolean isFronteira(String nomePais);
	public Integer getExercitos();
	public String getNome();
	public boolean isDono(IJogadorDoJogo jogador);
}
