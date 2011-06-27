package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import modelo.Item;

public interface ListaPreciosService extends Remote {

	Item comparativaPrecios(Integer nroSerie, String marca, String paisOrigen,
			String caracteristicas) throws RemoteException;


}
