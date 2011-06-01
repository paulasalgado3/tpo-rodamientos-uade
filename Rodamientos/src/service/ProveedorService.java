package service;

import java.rmi.Remote;

public interface ProveedorService extends Remote {

	void agregarProveedor(String razonSocial, String cuit, String telefono); //Agregar el tema de descuentos y forma de pago.
}
