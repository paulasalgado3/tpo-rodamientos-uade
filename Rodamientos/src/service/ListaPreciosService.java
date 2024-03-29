package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import modelo.Item;

public interface ListaPreciosService extends Remote {

	List<Item> obtenerItemPorMejorPrecio(String codigo, List<String> marcas, 
			String paisOrigen, String caracteristicas) throws RemoteException;

	List<Item> obtenerItemPorMejorPrecioCant(String codigo, List<String> marcas,
			String paisOrigen, String caracteristicas, int cantidad)
			throws RemoteException;

	

}
