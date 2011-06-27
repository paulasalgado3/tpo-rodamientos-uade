package test;

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
		
		Item i = itemDAO.obtenerItems(1, "SKF", "Argentina");
		System.out.println(i.toString());
		
		//1	1	caract 1	SKF	Argentina	1
	}

}
