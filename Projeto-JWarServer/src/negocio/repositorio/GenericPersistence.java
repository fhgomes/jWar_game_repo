package negocio.repositorio;

import java.util.List;
import java.util.Vector;

public abstract class GenericPersistence<T> {
	
	public abstract void salvar(T t);	
	public abstract void deletar(T t) ;
	
	public abstract T buscarPorId(Long id) ;
	public abstract Vector<T> buscaTodos() ;
	
	public abstract void terminar();
	public abstract void comecar();

}
