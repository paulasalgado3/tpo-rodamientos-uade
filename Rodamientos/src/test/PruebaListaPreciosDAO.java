package test;

import dao.ListaPreciosDAO;
import dao.impl.ListaPreciosDAOImpl;
import modelo.Item;
import modelo.ListaPrecios;

public class PruebaListaPreciosDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListaPreciosDAO lpDAO = new ListaPreciosDAOImpl();
	
		ListaPrecios lp = new ListaPrecios();
		lp.setNumeroLista(new Integer(123456));
		Item item1 = new Item();
		Item item2 = new Item();
		
		lpDAO.save(lp);
		System.out.println("Salvada la lista número " + lp.getNumeroLista());
		
		
		//Busco por numero de lista
		/*
		ListaPrecios lp2 = lpDAO.findByNumber(new Integer(123456));
		System.out.println("ID de la lista obtenida: " + lp2.getId());
		*/
		
	}

}
