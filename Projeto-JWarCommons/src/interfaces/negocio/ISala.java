package interfaces.negocio;

public interface ISala {
	
	public boolean mudarDeCor(String jog, int cor);
	public void escrever(String jog, String texto);
	public void sair(String jog);
	public boolean inicar();
	public void acionarBanner(String jog);
}
