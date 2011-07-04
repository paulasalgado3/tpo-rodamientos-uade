package test;

import java.util.HashSet;
import java.util.Set;

import modelo.Cliente;
import modelo.Item;
import service.SolicitudCompraService;
import service.impl.SolicitudCompraServiceImpl;
import dao.SolicitudCompraDAO;
import dao.impl.ClienteDAOImpl;
import dao.impl.ItemDAOImpl;
import dao.impl.SolicitudCompraDAOImpl;

public class PruebaSolicitudCompra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SolicitudCompraDAO solicitudCompraDAO = new SolicitudCompraDAOImpl();
		ClienteDAOImpl cDAO = new ClienteDAOImpl();
		ItemDAOImpl iDAO = new ItemDAOImpl();
		/*el cliente*/
		Cliente cli = (cDAO.findByDni(99999999));
		/*los items*/
		Set<Item> items= new HashSet<Item>();
		/*cotizacion 5*/
		items.add(iDAO.findById(1));
		/*cotizacion 6*/
		items.add(iDAO.findById(2));
		/*sin cotizacion*/

		items.add(iDAO.findById(15));
		items.add(iDAO.findById(16));
		items.add(iDAO.findById(17));
		
		SolicitudCompraService scs = new SolicitudCompraServiceImpl();
		
		scs.generarSolicitudCompra(items, cli);
		
		
		/*SolicitudCompra sc1 = new SolicitudCompra();
		sc1.setConfirmada(true);
		
		SolicitudCompra sc2 = new SolicitudCompra();
		sc2.setConfirmada(true);
		
		SolicitudCompra sc3 = new SolicitudCompra();
		sc3.setConfirmada(true);
		
		solicitudCompraDAO.save(sc1);
		solicitudCompraDAO.save(sc2);
		solicitudCompraDAO.save(sc3);
	*/
	}
	

}
