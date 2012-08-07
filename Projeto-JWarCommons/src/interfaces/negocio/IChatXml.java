package interfaces.negocio;



public interface IChatXml {
	public String escrever(String nomeChat, String msg, String nomeJog);
	public String darOpiniao(String nomeChat, String msg, String nomeJog);
	
	public String criarSala(String nomeChat, String nomeSala, Integer maxJog, String nomeJog);
	public String entrarSala(String nomeChat, String sala, String nomeJog);
	public String reentrarSala(String nomeChat, String nomeSala, String nomeJog);
	public String assistirSala(String nomeChat, String nomeSala, String nomeJog);
}
