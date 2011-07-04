package test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import modelo.Item;

import service.impl.ListaPreciosServiceImpl;

public class PruebaCompararPrecios {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		ListaPreciosServiceImpl lpsi = new ListaPreciosServiceImpl();
		List<String> marcas = new ArrayList<String>();
		marcas.add("SFK");
		marcas.add("FAG");
		List<Item> items=lpsi.obtenerItemPorMejorPrecio("D1",marcas , "Argentina", "caract 1");
		System.out.println("ITEMSSSS");
		for(Item i:items){
			System.out.println("ITEM: "+i.toString());
		}

	}

}
