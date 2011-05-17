package service;

import java.rmi.Remote;

public interface ProveedorService extends Remote {

	void agregarProveedor(String nombre, String apellido, Integer dni,
			String telefono, String formaPago); //Agregar el tema de descuentos.
}
