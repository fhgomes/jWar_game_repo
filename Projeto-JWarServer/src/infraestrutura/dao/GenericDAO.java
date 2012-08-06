package infraestrutura.dao;

import java.util.List;

public abstract class GenericDAO<T> {
	protected Class<T> persistentClass;
	
	protected GenericDAO(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}
	
	public abstract void save(T t);	
	public abstract void update(T t);
	public abstract void delete(T t) ;
	
	public abstract T load(Long id) ;
	public abstract List<T> list() ;
	
	public abstract void merge(T t) ;

	protected Class<T> getPersistentClass() {
		return persistentClass;
	}
}
