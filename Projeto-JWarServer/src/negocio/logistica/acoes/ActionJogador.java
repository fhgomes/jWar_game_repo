package negocio.logistica.acoes;

import java.util.List;

import negocio.beans.Jogador;
import negocio.interfaces.IActionJogador;
import negocio.repositorio.beans.JogadorRep;

public class ActionJogador implements IActionJogador{

	@Override
	public boolean cadastrar(String nome, String nick, String email, String senha) {
		Jogador j = new Jogador(nome, nick, email, senha);
		JogadorRep jRep = new JogadorRep();
		jRep.comecar();
		jRep.salvar(j);
		jRep.terminar();
		return true;
	}

	@Override
	public boolean deletar(Integer cod) {
		JogadorRep jRep = new JogadorRep();
		jRep.comecar();
		jRep.deletar(new Jogador(cod));
		jRep.terminar();
		return true;
	}

	@Override
	public List listar() {
		JogadorRep jRep = new JogadorRep();
		jRep.comecar();
		List todos = jRep.buscaTodos();
		jRep.terminar();
		return todos;
	}

	@Override
	public boolean editar(Integer id, String nome, String nick, String email,
			String senha) {
		Jogador j = new Jogador(id, nome, nick, email, senha);
		JogadorRep jRep = new JogadorRep();
		jRep.comecar();
		jRep.salvar(j);
		jRep.terminar();
		return true;
	}
	

}
