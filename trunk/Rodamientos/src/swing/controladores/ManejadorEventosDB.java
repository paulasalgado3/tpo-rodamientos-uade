package swing.controladores;

import org.hibernate.Session;

import util.hibernate.HibernateUtil;

public class ManejadorEventosDB {

	private static ManejadorEventosDB instancia = null;
	static {
		if(instancia == null) instancia = new ManejadorEventosDB();
	}
			
	public static ManejadorEventosDB getInstancia() {
		return instancia;
	}
	
	/*
	 * Aca en este metodo mediante algo (excepcion o algo por el estilo)
	 * tenemos que ver como manejar el asunto si no conecta, por ahora lo dejo
	 * asi para seguir laburando en el resto.
	 */
	public void conectarADataBase(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		System.out.println("Creó las tablas de la Data Base");
	}
}
