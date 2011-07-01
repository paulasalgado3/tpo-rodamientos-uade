package service;

import java.rmi.Remote;

import modelo.Cliente;

public interface ClienteService extends Remote {

	void agregarCliente(String nombre, String apellido, Integer dni, String telefono);
	void eliminarCliente(Integer dni);
	void modificarCliente(Integer dni);
	Cliente findByDni(Integer dni);
}
