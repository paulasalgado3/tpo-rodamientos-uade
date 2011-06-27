package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import modelo.Item;

public interface ListaPreciosService extends Remote {

	Item obtenerItemPorMejorPrecio(Integer nroSerie, List<String> marcas,
			String paisOrigen, String caracteristicas) throws RemoteException;


}
