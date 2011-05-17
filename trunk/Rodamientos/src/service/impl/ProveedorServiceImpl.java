package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.ProveedorDAO;
import dao.impl.ProveedorDAOImpl;

import modelo.CondicionCompra;
import modelo.Proveedor;

import service.ProveedorService;

@SuppressWarnings("serial")
public class ProveedorServiceImpl extends UnicastRemoteObject implements
		ProveedorService {

	ProveedorDAO proveedorDAO;
	public ProveedorServiceImpl() throws RemoteException {
		super();
		proveedorDAO = new ProveedorDAOImpl();
	}

	@Override
	public void agregarProveedor(String nombre, String apellido, Integer dni,
			String telefono, String formaPago) {
		Proveedor proveedor = new Proveedor();
		proveedor.setApellido(apellido);		
		proveedor.setDni(dni);
		proveedor.setNombre(nombre);
		proveedor.setTelefono(telefono);
		
		/*Busco la condicion de compra por forma de pago*/
		CondicionCompra condicionCompra = null;
		
		proveedor.setCondicionCompra(condicionCompra);
		proveedorDAO.save(proveedor);//la cond compra se guardar en cascada
	}

}
