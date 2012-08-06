package infraestrutura.dao;

import negocio.beans.Jogador;

import org.hibernate.Query;
import org.hibernate.Transaction;

public class JogadorDAO extends HibernateDAO<Jogador>{

	public JogadorDAO() {
		super(Jogador.class);
		// TODO Auto-generated constructor stub
	}
	public Jogador buscaJogPorNome(String nome){
		Query query = getSession().
		createQuery("from Jogador where tipoUsuario.nome =:TIPO_USUARIO"
					+  " and nome = :JOG_NOME");
		query.setParameter(" TIPO_USUARIO" ,"Administrador");
		query.setParameter("JOG_NOME" ,nome);
		return (Jogador) query.uniqueResult();
	}
	public Jogador buscaPorNick(String nick) {
		System.out.println("PROCURANDO POR->"+nick);
		Query query = getSession().
		createQuery("from Jogador where nickname = :JOG_NICK");
		query.setParameter("JOG_NICK" ,nick);
		return (Jogador) query.uniqueResult();
	}
	public Jogador buscaPorEmail(String email) {
		System.out.println("PROCURANDO POR->"+email);
		Query query = getSession().
		createQuery("from Jogador where email = :JOG_EMAIL");
		query.setParameter("JOG_EMAIL" ,email);
		return (Jogador) query.uniqueResult();
	}
	
//	public boolean updateJogador(Jogador j) {
//		Query query = getSession().
//		createQuery("update Jogador j set j.nome =:JOG_NOME " +
//						" j.email =:JOG_EMAIL j. =:JOG_NICK j.senha =:JOG_SENHA" +
//						" where j.id =:JOG_ID");
//		query.setParameter("JOG_ID" ,j.getId());
//		query.setParameter("JOG_EMAIL" ,j.getEmail());
//		query.setParameter("JOG_NOME" ,j.getNome());
//		query.setParameter("JOG_NICK" ,j.getNickname());
//		query.setParameter("JOG_SENHA" ,j.getSenha());
//		query.executeUpdate();
//		return true;
//	}
	public boolean updatejog(Jogador j) {
		Transaction t = getSession().beginTransaction();
		super.save(j);
		t.commit();
		return true;
	}
	
	public void delete(Jogador j) {
		Query query = getSession().
		createQuery("delete from Jogador where id = :JOG_ID");
		query.setParameter("JOG_ID" ,j.getId());
		query.executeUpdate();
	}
	
}
