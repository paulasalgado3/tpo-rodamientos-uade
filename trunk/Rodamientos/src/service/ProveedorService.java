package service;

import java.rmi.Remote;

public interface ProveedorService extends Remote {

	void agregarProveedor(String razonSocial, String cuit, String telefono, String formaPago); //Agregar el tema de descuentos.
}
