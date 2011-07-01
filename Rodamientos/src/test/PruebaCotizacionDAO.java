package test;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dao.CotizacionDAO;
import dao.ItemDAO;
import dao.impl.ClienteDAOImpl;
import dao.impl.CotizacionDAOImpl;
import dao.impl.ItemDAOImpl;
import modelo.Cotizacion;
import modelo.Item;

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
		cot.setItems(iDAO.findAll(Item.class));
		
		CotizacionDAO cotDAO = new CotizacionDAOImpl();
		cotDAO.save(cot);
		System.out.println("Se guardo la siguiente cotizacion:"+cot.toString());

	}

}
