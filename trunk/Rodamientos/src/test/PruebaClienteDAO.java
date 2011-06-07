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
		cliente.setApellido("Power");
		cliente.setNombre("Max");
		cliente.setDni("99999999");
		
		clienteDAO.save(cliente);
		System.out.println("Creó al cliente " + cliente.getNombre());
		*/
		
		//Listo todos
		/*
		List<Cliente> clientes = clienteDAO.findAll(Cliente.class);
		System.out.println(clientes.size());
		*/
		
		//busco por dni
		/*
		Cliente cliente = clienteDAO.findByDni("99999999");
		System.out.println(cliente.getNombre() + " " +cliente.getApellido());
		*/
	}

}
