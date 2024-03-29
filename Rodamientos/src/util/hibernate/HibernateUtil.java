package util.hibernate;

import modelo.Cliente;
import modelo.CondicionCompra;
import modelo.CondicionPago;
import modelo.Cotizacion;
import modelo.Item;
import modelo.ListaPrecios;
import modelo.Proveedor;
import modelo.Rodamiento;
import modelo.SolicitudCompra;

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
	        	 cfg.addAnnotatedClass(CondicionCompra.class);
	        	 cfg.addAnnotatedClass(CondicionPago.class);
	        	 cfg.addAnnotatedClass(Item.class);
	        	 cfg.addAnnotatedClass(ListaPrecios.class);
	        	 cfg.addAnnotatedClass(Proveedor.class);
	        	 cfg.addAnnotatedClass(Rodamiento.class);
	        	 cfg.addAnnotatedClass(Cotizacion.class);
	        	 cfg.addAnnotatedClass(SolicitudCompra.class);

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
