package negocio.app;

import java.util.Iterator;

import infraestrutura.dao.*;
import negocio.beans.*;

import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class JWarGeraBanco {

	public static void main(String[] args) {
		AnnotationConfiguration cfg = 
			new AnnotationConfiguration().
			configure("/cfg/hibernate.cfg.xml");
		SchemaExport export = new SchemaExport(cfg);
		
		export.create(true, true);
		TipoUsuarioDAO tpUDAO = new TipoUsuarioDAO();
		
		tpUDAO.iniSession();
		
		Transaction t = tpUDAO.getSession().beginTransaction();
		
		tpUDAO.save(new TipoUsuario("Administrador" , "Administrador Geral", 10));
		tpUDAO.save(new TipoUsuario("Cliente" , "Jogador Basico", 1));
				
		t.commit();
		
		TipoUsuario tipo = tpUDAO.buscaPorDescricao("Administrador Geral");
		System.out.println(tipo.getDescricao());
		
		tpUDAO.finishSession();
		
		tpUDAO.iniSession();
		Iterator i =tpUDAO.list().iterator();
		while (i.hasNext()){
			TipoUsuario tpu = (TipoUsuario) i.next();
			System.out.println(tpu.getDescricao());
		}
		tpUDAO.finishSession();	
	}

}

