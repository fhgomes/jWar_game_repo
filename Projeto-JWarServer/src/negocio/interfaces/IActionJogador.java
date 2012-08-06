package negocio.interfaces;

import java.util.List;

public interface IActionJogador {
	public boolean cadastrar(String nome, String nick, String email, String senha);
	public List listar();
	public boolean deletar(Integer cod);
	public boolean editar(Integer id, String nome, String nick, String email, String senha);
}
