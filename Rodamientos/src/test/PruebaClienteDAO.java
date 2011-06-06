package test;

import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import modelo.Cliente;
import dao.ClienteDAO;
import dao.impl.ClienteDAOImpl;

public class PruebaClienteDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setApellido("Power");
		cliente.setNombre("Max");
		cliente.setDni("99999999");
		
		clienteDAO.save(cliente);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Creó al cliente " + cliente.getNombre());
	}

}
