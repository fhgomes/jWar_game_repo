package negocio.repositorio.beans;

import infraestrutura.dao.TipoUsuarioDAO;

import java.util.Vector;

import negocio.beans.TipoUsuario;
import negocio.repositorio.GenericPersistence;

import org.hibernate.Transaction;

public class TipoUsuarioRep extends GenericPersistence<TipoUsuario>{
	TipoUsuarioDAO dao;
	
	public TipoUsuarioRep() {
		dao = new TipoUsuarioDAO();
	}
	@Override
	public Vector<TipoUsuario> buscaTodos() {
		Vector<TipoUsuario> tipos = new Vector();
		tipos.addAll(dao.list());
		return tipos;
	}
	@Override
	public TipoUsuario buscarPorId(Long id) {
		return dao.load(id);
	}
	@Override
	public void deletar(TipoUsuario t) {
		Transaction tr = dao.getSession().beginTransaction();
		dao.delete(t);		
		tr.commit();
	}
	@Override
	public void salvar(TipoUsuario t) {
		Transaction tr = dao.getSession().beginTransaction();
		dao.save(t);		
		tr.commit();
	}
	@Override
	public void terminar() {
		dao.finishSession();
	}
	@Override
	public void comecar() {
		dao.iniSession();
		
	}
	public TipoUsuario buscaPorNome(String nome) {
		return dao.buscaPorNome(nome);
	}

}
