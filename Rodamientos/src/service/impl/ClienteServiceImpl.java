package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.ClienteDAO;
import dao.impl.ClienteDAOImpl;

import modelo.Cliente;
import modelo.CondicionPago;

import service.ClienteService;

@SuppressWarnings("serial")
public class ClienteServiceImpl extends UnicastRemoteObject implements ClienteService {
	
	ClienteDAO clienteDAO;
	
	public ClienteServiceImpl() throws RemoteException {
		super();
		clienteDAO = new ClienteDAOImpl();
	}

	@Override
	public void agregarCliente(String nombre, String apellido, Integer dni,
			String telefono) throws RemoteException{
			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDni(dni);
			cliente.setTelefono(telefono);
			Double descuento = null;
			cliente.setDescuento(descuento);
			CondicionPago condPago = null;
			cliente.setCondicionpago(condPago);
			clienteDAO.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer dni) throws RemoteException{
		Cliente cli = clienteDAO.findByDni(dni);
		clienteDAO.delete(cli);
		
	}

	@Override
	public void modificarCliente(Integer dni)throws RemoteException {
		
		
	}
	
	public Cliente findByDni(Integer dni)throws RemoteException{
		return clienteDAO.findByDni(dni);
	}

}
