package interfaces.negocio;

public interface ISalaXml {
	
	
	public boolean mudarDeCor(String sala, String jog, int cor);
	public String escrever(String sala, String jog, String texto);
	public void sair(String sala, String jog);
	public boolean inicar(String nomeSala);
	public void acionarBanner(String sala, String jog);
}
