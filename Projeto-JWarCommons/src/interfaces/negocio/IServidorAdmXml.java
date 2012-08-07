package interfaces.negocio;

public interface IServidorAdmXml {

	public String cadastrar(String nick, String name, String email, String senha);
	public boolean editar(String id, String nick, String name, String email, String senha);
	public Object[] listar();
	public boolean excluir(String email);
	public Object[] getDados(String id);
}
