package test;

import org.hibernate.Session;

import util.hibernate.HibernateUtil;

public class PruebaConexi�n {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		System.out.println("Cre� las tablas");
	}

}
