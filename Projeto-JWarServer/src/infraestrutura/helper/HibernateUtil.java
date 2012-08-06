package infraestrutura.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> sessions = 
		new ThreadLocal<Session>();
	
	static {
		try {
			sessionFactory = new AnnotationConfiguration().
				configure("/cfg/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable t) {
			throw new ExceptionInInitializerError(t);
		}
	}
	
	public static Session openSession() {
		if (sessions.get() != null)
			System.out.println("Já existe uma sessão aberta");
		sessions.set(sessionFactory.openSession());
		return sessions.get();
	}
	
	public static Session currentSession() {
		return sessions.get();
	}
	
	public static void closeCurrentSession() {
		sessions.get().close();
		sessions.set(null);
	}
	
	public static void shutdown() {
		sessionFactory.close();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
