package util.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	 static
	    {
	        try
	        {
	        	 AnnotationConfiguration cfg = new AnnotationConfiguration();
	         	/*Agregar las clases con anotaciones*/	
//	        	 config.addAnnotatedClass(nombreDeClase.class);
	             sessionFactory = cfg.buildSessionFactory();
	        }
	        catch (Throwable ex)
	        {
	            System.err.println("Error en la creación de la session factory." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    }
}
