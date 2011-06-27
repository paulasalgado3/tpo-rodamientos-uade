package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import modelo.Item;
import service.ListaPreciosService;
import dao.ListaPreciosDAO;
import dao.impl.ItemDAOImpl;
import dao.impl.ListaPreciosDAOImpl;

@SuppressWarnings("serial")
public class ListaPreciosServiceImpl extends UnicastRemoteObject implements
		ListaPreciosService {

	ListaPreciosDAO listaPreciosDAO = new ListaPreciosDAOImpl();
	
	protected ListaPreciosServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item comparativaPrecios(Integer nroSerie, String marca, String paisOrigen, String caracteristicas) throws RemoteException{
		/*-	Mejor precio, características del rodamiento, marca, país de origen y lista del proveedor.*/
		ItemDAOImpl itemDAO = new ItemDAOImpl();
		return itemDAO.obtenerItems(nroSerie, marca, paisOrigen);
		
	}

}
