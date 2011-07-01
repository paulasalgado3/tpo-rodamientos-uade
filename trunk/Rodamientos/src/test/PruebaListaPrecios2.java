package test;

import modelo.Item;
import modelo.ListaPrecios;
import modelo.Rodamiento;
import dao.ItemDAO;
import dao.ListaPreciosDAO;
import dao.RodamientoDAO;
import dao.impl.ItemDAOImpl;
import dao.impl.ListaPreciosDAOImpl;
import dao.impl.RodamientoDAOImpl;

public class PruebaListaPrecios2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Creo 2 listas de precios, con un item cada una, con el mismo rodamiento para ambas.*/
		RodamientoDAO rodamientoDAO = new RodamientoDAOImpl();
		ListaPreciosDAO listaPreciosDAO = new ListaPreciosDAOImpl();
		
		ListaPrecios lp1 = new ListaPrecios();
		ListaPrecios lp2 = new ListaPrecios();
		lp1.setNumeroLista(new Integer(1));
		lp1.setDescuento(new Double (0.20));
		lp1.setTipo(new String ("Lista1"));
		lp1.setVigencia(new Integer(1));
		
		lp2.setNumeroLista(new Integer(2));
		lp2.setDescuento(new Double (0.30));
		lp2.setTipo(new String ("Lista2"));
		lp2.setVigencia(new Integer(1));
		
		Rodamiento rodamiento = new Rodamiento();
		rodamiento.setCaracteristicas("caract 1");
		rodamiento.setCodigo("Cod10");
		rodamiento.setMarca("SFK");
		rodamiento.setPaisOrigen("Argentina");
		
		rodamientoDAO.save(rodamiento);
		
		Item item1 = new Item();
		Item item2 = new Item();
		
		item1.setCantidad(2);
		item1.setPrecio(new Float(1));
		item1.setListaPrecios(lp1);
		item1.setRodamiento(rodamiento);
		
		item2.setCantidad(2);
		item2.setPrecio(new Float(1));
		item2.setListaPrecios(lp2);
		item2.setRodamiento(rodamiento);
		
		lp1.getItems().add(item1);
		lp2.getItems().add(item2);
		
		listaPreciosDAO.save(lp1);
		listaPreciosDAO.save(lp2);
		
		System.out.println("Salvada la lista numero " + lp1.getNumeroLista());
		System.out.println("Salvada la lista numero " + lp2.getNumeroLista());
		
	}

}
