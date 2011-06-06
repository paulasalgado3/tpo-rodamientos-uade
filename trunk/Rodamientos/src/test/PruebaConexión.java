package test;

import org.hibernate.Session;

import util.hibernate.HibernateUtil;

public class PruebaConexión {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		System.out.println("Creó las tablas");
	}

}
