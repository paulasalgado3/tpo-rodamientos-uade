package test;

import modelo.SolicitudCompra;
import dao.SolicitudCompraDAO;
import dao.impl.SolicitudCompraDAOImpl;

public class PruebaSolicitudCompra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SolicitudCompraDAO solicitudCompraDAO = new SolicitudCompraDAOImpl();
		
		SolicitudCompra sc1 = new SolicitudCompra();
		sc1.setConfirmada(true);
		
		SolicitudCompra sc2 = new SolicitudCompra();
		sc2.setConfirmada(true);
		
		SolicitudCompra sc3 = new SolicitudCompra();
		sc3.setConfirmada(true);
		
		solicitudCompraDAO.save(sc1);
		solicitudCompraDAO.save(sc2);
		solicitudCompraDAO.save(sc3);
	}

}
