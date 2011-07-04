package test;

import java.util.ArrayList;
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
	
		cot.setPrecioVenta((float) 234.32);
	
		ItemDAO iDAO = new ItemDAOImpl();
		List<Item> items = new ArrayList<Item>();
		items.add(iDAO.findById(1));
		items.add(iDAO.findById(2));
		items.add(iDAO.findById(3));
		for(Item i : items){
			cot.getItems().add(i);
		}
		
		CotizacionDAO cotDAO = new CotizacionDAOImpl();
		cotDAO.save(cot);
		
		//creo una segunda cotizacion con otro item
		
		Cotizacion cot2 = new Cotizacion();
		cot2.setCliente(cDAO.findByDni(99999999));
		
		cot2.setPrecioVenta((float) 234.32);
		
		List<Item> items2 = new ArrayList<Item>();
		items2.add(iDAO.findById(15));
		items2.add(iDAO.findById(16));
		items2.add(iDAO.findById(17));
		for(Item i : items2){
			cot2.getItems().add(i);
		}
		
		
		cotDAO.save(cot2);
		

	}

}
