package infraestrutura.dao;

import negocio.beans.Usuario;

import org.hibernate.Query;

public class UsuarioDAO extends HibernateDAO<Usuario>{

	public UsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}
	public Usuario buscaAdmPorNome(String nome){
		Query query = getSession().
		createQuery("from Usuario where tipoUsuario.nome =:TIPO_USUARIO"
					+  " and nome = :USU_NOME");
		query.setParameter(" TIPO_USUARIO" ,"Administrador");
		query.setParameter("USU_NOME" ,nome);
		return (Usuario) query.uniqueResult();
	}
	public Usuario buscaPorNick(String nick) {
		System.out.println("PROCURANDO POR->"+nick);
		Query query = getSession().
		createQuery("from Usuario where nickname = :USU_NICK");
		query.setParameter("USU_NICK" ,nick);
		return (Usuario) query.uniqueResult();
	}
	
}
