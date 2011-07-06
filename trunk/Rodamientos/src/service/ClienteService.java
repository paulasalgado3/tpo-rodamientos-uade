package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import modelo.Cliente;

public interface ClienteService extends Remote {

	void agregarCliente(String nombre, String apellido, Integer dni, String telefono)throws RemoteException;
	void eliminarCliente(Integer dni)throws RemoteException;
	void modificarCliente(Integer dni)throws RemoteException;
	Cliente findByDni(Integer dni)throws RemoteException;
}
