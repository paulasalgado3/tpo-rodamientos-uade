package test;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import dao.impl.ItemDAOImpl;
import modelo.Item;

public class PruebaItemDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ItemDAO itemDAO = new ItemDAOImpl();

		//compara precios de items
		
		List<String> marcas = new ArrayList<String>();
		marcas.add("FCK");
		//List<Item> items =  itemDAO.obtenerItemPorMejorPrecioCant("D1", marcas, "Argentina", "caract 1", 2);
		List<Item> items = itemDAO.obtenerItemPorMejorPrecio("Cod99", marcas, "Chipre", "las caracteristicas");
		
		for (Item i:items){
			System.out.println(i.toString());
		}		
		
	}

}
