package service;

import java.rmi.Remote;

import modelo.Cliente;

public interface ClienteService extends Remote {

	void agregarCliente(String nombre, String apellido, String dni, String telefono);
	void eliminarCliente(String dni);
	void modificarCliente(String dni);
	Cliente findByDni(String dni);
}
