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
		
		ListaPrecios lp = new ListaPrecios();
		lp.setNumeroLista(new Integer(9999));
		lp.setDescuento(new Double (0.22));
		lp.setTipo(new String ("Listinga"));
		lp.setVigencia(new Integer(1));
		
		Rodamiento rodamiento = new Rodamiento();
		rodamiento.setCaracteristicas("las caracteristicas");
		rodamiento.setCodigo("Cod99");
		rodamiento.setMarca("FCK");
		rodamiento.setPaisOrigen("Chipre");
		
		rodamientoDAO.save(rodamiento);
		
		Item item1 = new Item();
		Item item2 = new Item();
		
		item1.setCantidad(3);
		item1.setPrecio(new Float(0.5));
		item1.setListaPrecios(lp);
		item1.setRodamiento(rodamiento);
		
		item2.setCantidad(5);
		item2.setPrecio(new Float(0.5));
		item2.setListaPrecios(lp);
		item2.setRodamiento(rodamiento);
		
		lp.getItems().add(item1);
		lp.getItems().add(item2);
		
		listaPreciosDAO.save(lp);
		
		System.out.println("Salvada la lista numero " + lp.getNumeroLista());
		
	}

}
