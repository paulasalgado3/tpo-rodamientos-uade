package service;
/*
 * Gente no nos gastemos haciendo el rmi del abm de proveedores, En las consignas
 * dice que los proveedores los maneja la casa central, NO las sucursales, por 
 * lo tanto no lo tenemos que publicar.
 */
import java.rmi.Remote;

public interface ProveedorService extends Remote {

	void agregarProveedor(String razonSocial, String cuit, String telefono); //Agregar el tema de descuentos y forma de pago.
}
