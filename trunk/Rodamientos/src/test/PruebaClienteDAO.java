package test;

import java.util.List;

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
		
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		/*
		Cliente cliente = new Cliente();
		cliente.setApellido("Max");
		cliente.setNombre("Power");
		cliente.setDni("99999999");
		
		clienteDAO.save(cliente);
		System.out.println("Creó al cliente " + cliente.getNombre());
		*/
		
		
		/*
		List<Cliente> clientes = clienteDAO.findAll(Cliente.class);
		System.out.println(clientes.size());
		*/
		
	}

}
