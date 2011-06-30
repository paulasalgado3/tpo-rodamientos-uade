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
		marcas.add("SKF");
		List<Item> items =  itemDAO.obtenerItemPorMejorPrecioCant("D1", marcas, "Argentina", "caract 1", 2);
		for (Item i:items){
			System.out.println(i.toString());
		}
		
		//1	1	caract 1	SKF	Argentina	1
		
		
		
		
		
		
	}

}
