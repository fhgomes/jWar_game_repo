package negocio.repositorio.beans;

import infraestrutura.dao.UsuarioDAO;

import java.util.Vector;

import negocio.beans.Usuario;
import negocio.repositorio.GenericPersistence;

import org.hibernate.Transaction;

import exceptions.infraestrutura.UsuarioNaoExisteException;

public class UsuarioRep extends GenericPersistence<Usuario>{
	private UsuarioDAO dao;
	
	public UsuarioRep(){
		dao = new UsuarioDAO();
	}
	@Override
	public Vector<Usuario> buscaTodos() {
		Vector<Usuario> usuarios = new Vector<Usuario>();
		usuarios.addAll(dao.list());
		return usuarios;
	}
	@Override
	public Usuario buscarPorId(Long id) {
		return dao.load(id);
	}
	@Override
	public void comecar() {
		dao.iniSession();
	}
	@Override
	public void deletar(Usuario u) {
		Transaction t = dao.getSession().beginTransaction();
		dao.delete(u);		
		t.commit();
	}
	@Override
	public void salvar(Usuario u) {
		Transaction tr = dao.getSession().beginTransaction();
		dao.save(u);		
		tr.commit();
	}
	@Override
	public void terminar() {
		dao.finishSession();
	}
	public Boolean logar(String nick, String senha) throws UsuarioNaoExisteException{
		Usuario u = dao.buscaPorNick(nick);
		System.out.println("usuario encontrado"+ u);
		if (u == null)
			throw new UsuarioNaoExisteException("Nick nao encontrado");
		else
			if (u.getSenha().equals(senha))
				return true;
			else return false;
	}
	public boolean existeUsuarioNick(String nick, Boolean ativo) {
		Usuario u = dao.buscaPorNick(nick);
		if (u != null)
			return true;
		else
			return false;
	}
	
}
