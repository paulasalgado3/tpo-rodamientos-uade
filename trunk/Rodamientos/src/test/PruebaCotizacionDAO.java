package test;

import java.util.List;

import modelo.Cotizacion;
import modelo.Item;
import dao.CotizacionDAO;
import dao.ItemDAO;
import dao.impl.ClienteDAOImpl;
import dao.impl.CotizacionDAOImpl;
import dao.impl.ItemDAOImpl;

public class PruebaCotizacionDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cotizacion cot = new Cotizacion();
		ClienteDAOImpl cDAO = new ClienteDAOImpl();
		cot.setCliente(cDAO.findByDni(99999999));
		//no tengo idea de que es este precio de venta....del total de la cotizacion???
		cot.setPrecioVenta((float) 234.32);
		//le pongo todos los items para probar
		ItemDAO iDAO = new ItemDAOImpl();
		List<Item> items = iDAO.findAll(Item.class);
		for(Item i : items){
			cot.getItems().add(i);
		}
		
		CotizacionDAO cotDAO = new CotizacionDAOImpl();
		cotDAO.save(cot);
		System.out.println("Se guardo la siguiente cotizacion:"+cot.toString());

	}

}
