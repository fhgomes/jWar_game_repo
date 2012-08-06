package infraestrutura.dao;

import negocio.beans.TipoUsuario;

import org.hibernate.Query;

public class TipoUsuarioDAO extends HibernateDAO<TipoUsuario> {

	public TipoUsuarioDAO() {
		super(TipoUsuario.class);
	}
	
	public TipoUsuario buscaPorDescricao(String descricao) {
		String sql = "from TipoUsuario where descricao = :TUSU_DESCRICAO";
		Query query = getSession().createQuery(sql);
		query.setParameter("TUSU_DESCRICAO",descricao);
		return (TipoUsuario) query.uniqueResult();
	}
	public TipoUsuario buscaPorNome(String nome){
		String sql = "from TipoUsuario where nome = :TUSU_NOME";
		Query query = getSession().createQuery(sql);
		query.setParameter("TUSU_NOME", nome);
		return (TipoUsuario) query.uniqueResult();
	}

}
