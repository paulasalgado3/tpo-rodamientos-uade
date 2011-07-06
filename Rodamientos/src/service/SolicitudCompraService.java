package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import modelo.Cliente;
import modelo.Item;
import modelo.SolicitudCompra;

public interface SolicitudCompraService extends Remote{

	void generarSolicitudCompra(Set<Item> items, Cliente cli) throws RemoteException;
	public Set<SolicitudCompra> generarSolicitudCompraSet(Set<Item> items, Cliente cli) throws RemoteException;
	List<SolicitudCompra> findAll() throws RemoteException;
	void confirmarSolicitudCompra(Integer id) throws RemoteException;
	List<SolicitudCompra> obtenerNoConfirmadas() throws RemoteException;
}
