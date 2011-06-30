package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import modelo.Item;
import service.ListaPreciosService;
import dao.ListaPreciosDAO;
import dao.impl.ItemDAOImpl;
import dao.impl.ListaPreciosDAOImpl;

@SuppressWarnings("serial")
public class ListaPreciosServiceImpl extends UnicastRemoteObject implements
		ListaPreciosService {

	ListaPreciosDAO listaPreciosDAO = new ListaPreciosDAOImpl();
	
	public ListaPreciosServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*Obtener item con el mejor precio (sin verificar la cantidad) restringido con nroserie
	 * (lo tomo como el codigo del rodamiento pq no existe otro numero de serie)
	 * marcas pudiendo ser varias, origen, caracteristicas*/
	
	 
	@Override
	public Item obtenerItemPorMejorPrecio(String codigo, List<String> marcas, String paisOrigen, String caracteristicas) throws RemoteException{
		/*-	Mejor precio, características del rodamiento, marca, país de origen y lista del proveedor.*/
		ItemDAOImpl itemDAO = new ItemDAOImpl();
		Item i = itemDAO.obtenerItemPorMejorPrecio(codigo, marcas, paisOrigen, caracteristicas);
		
		
		
		return i;

	}
	/*Obtener item con el mejor precio (ordenados de menor a mayor)*/
	
	 
	public List<Item> obtenerItemPorMejorPrecioCant(String codigo, List<String> marcas, String paisOrigen, String caracteristicas, int cantidad) throws RemoteException{
		/*-	Mejor precio, características del rodamiento, marca, país de origen y lista del proveedor.*/
		ItemDAOImpl itemDAO = new ItemDAOImpl();
		List<Item> items = itemDAO.obtenerItemPorMejorPrecioCant(codigo, marcas, paisOrigen, caracteristicas, cantidad);
		return items;

	}


}
