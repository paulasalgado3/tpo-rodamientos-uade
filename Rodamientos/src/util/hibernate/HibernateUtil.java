package util.hibernate;

import modelo.Cliente;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	 static
	    {
	        try
	        {
	        	 AnnotationConfiguration cfg = new AnnotationConfiguration();
	        	 cfg.addAnnotatedClass(Cliente.class);

	             sessionFactory = cfg.buildSessionFactory();
	        }
	        catch (Throwable ex)
	        {
	            System.err.println("Error en la creaci�n de la session factory." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    }
}
