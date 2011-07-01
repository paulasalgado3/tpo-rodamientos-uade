package service.impl;

import java.util.List;

import modelo.SolicitudCompra;
import dao.SolicitudCompraDAO;
import dao.impl.SolicitudCompraDAOImpl;
import service.SolicitudCompraService;

public class SolicitudCompraServiceImpl implements SolicitudCompraService{

	SolicitudCompraDAO solicitudCompraDAO = new SolicitudCompraDAOImpl();
	
	public void generarSolicitudCompra(){
		
		/*COMPLETAR*/
	}
	
	public void confirmarSolicitudCompra(Integer idSolicitudCompra){
	
		SolicitudCompra solicitudCompra = solicitudCompraDAO.findById(idSolicitudCompra);
		solicitudCompra.setConfirmada(true);
		solicitudCompraDAO.update(solicitudCompra);
		
		/*HACER LA PARTE DE LA FACTURACION*/
	}
	public List<SolicitudCompra> findAll(){
		return solicitudCompraDAO.findAll(SolicitudCompra.class);
	}
	
}
