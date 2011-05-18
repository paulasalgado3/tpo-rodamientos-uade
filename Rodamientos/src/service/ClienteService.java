package service;

import java.rmi.Remote;

import modelo.Cliente;

public interface ClienteService extends Remote {

	void agregarCliente(String nombre, String apellido, int dni, String telefono);
	void eliminarCliente(String dni);
	void modificarCliente(String dni);
	Cliente findByDni(String dni);
}
