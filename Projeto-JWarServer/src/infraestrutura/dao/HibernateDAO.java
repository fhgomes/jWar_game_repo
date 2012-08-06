package infraestrutura.dao;

import infraestrutura.helper.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

public class HibernateDAO<T> extends GenericDAO<T>{
	
	private Session session;

	protected HibernateDAO(Class<T> persistentClass) {
		super(persistentClass);
	}
	
	public void save(T t) {
		this.session.saveOrUpdate(t);
		
	}
	
	public void delete(T t) {
		this.session.delete(t);
	}
	
	public T load(Long id) {
		return (T) this.session.load(persistentClass, id);
	}

	public List<T> list() {
		return session.createCriteria(persistentClass).list();
	}
	
	public void merge(T t) {
		session.merge(t);
	}
	
	public Session getSession() {
		return session;
	}
	public void finishSession() {
		session = null;
		HibernateUtil.closeCurrentSession();		
	}
	public void iniSession(){
		this.session = HibernateUtil.openSession();
	}

	@Override
	public void update(T t) {
		this.session.update(t);
		
	}

}
