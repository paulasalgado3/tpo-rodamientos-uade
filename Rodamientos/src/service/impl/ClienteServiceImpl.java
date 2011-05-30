package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.ClienteDAO;
import dao.impl.ClienteDAOImpl;

import modelo.Cliente;
import modelo.CondicionPago;
import modelo.Descuento;

import service.ClienteService;

@SuppressWarnings("serial")
public class ClienteServiceImpl extends UnicastRemoteObject implements ClienteService {
	
	ClienteDAO clienteDAO;
	
	protected ClienteServiceImpl() throws RemoteException {
		super();
		clienteDAO = new ClienteDAOImpl();
	}

	@Override
	public void agregarCliente(String nombre, String apellido, String dni,
			String telefono) {
			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDni(dni);
			cliente.setTelefono(telefono);
			Descuento descuento = null;
			cliente.setDescuento(descuento);
			CondicionPago condPago = null;
			cliente.setCondicionpago(condPago);
			clienteDAO.save(cliente);
	}

	@Override
	public void eliminarCliente(String dni) {
		Cliente cli = clienteDAO.findByDni(dni);
		clienteDAO.delete(cli);
		
	}

	@Override
	public void modificarCliente(String dni) {
		
		
	}
	
	public Cliente findByDni(String dni){
		return clienteDAO.findByDni(dni);
	}

}
