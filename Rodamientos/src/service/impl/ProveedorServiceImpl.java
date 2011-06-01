
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

	public void agregarProveedor(String razonSocial, String cuit, String telefono) {
		Proveedor proveedor = new Proveedor(razonSocial, cuit, telefono);
		
		/*Busco la condicion de compra por forma de pago*/
		CondicionCompra condicionCompra = null;
		
		proveedor.getCondicionesCompra().add(condicionCompra);
		proveedorDAO.save(proveedor);//la cond compra se guardar en cascada
	}

}
