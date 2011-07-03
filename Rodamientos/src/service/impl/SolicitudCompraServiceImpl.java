package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import modelo.Cliente;
import modelo.Cotizacion;
import modelo.Item;
import modelo.SolicitudCompra;
import dao.SolicitudCompraDAO;
import dao.impl.SolicitudCompraDAOImpl;
import service.SolicitudCompraService;

public class SolicitudCompraServiceImpl implements SolicitudCompraService{

	SolicitudCompraDAO solicitudCompraDAO = new SolicitudCompraDAOImpl();
	
	public void generarSolicitudCompra(List<Item> items, Cliente cli){
		/*Genero la solicitud de compra*/
		SolicitudCompra solicitud = new SolicitudCompra();
		solicitud.setCli(cli);
		
		/*primero me fijo si el pedido corresponde a una cotizacion*/
		List<Cotizacion> cotizaciones =solicitudCompraDAO.obtenerCotizacionCliente(cli);
		/*me fijo si los items corresponden a alguna de las cotizaciones anteriores*/
		List<Item> itemsCotizados = new ArrayList<Item>();
		for (Cotizacion c :cotizaciones){
			Set<Item> it = c.getItems();
			for(Item i:it){
				for(Item ii:items){
					if(ii.getId()==i.getId()){
						/*si son el mismo item quiere decir que se cotizo previamente*/
						itemsCotizados.add(ii);
						/*lo remuevo de la lista de items para que me queden unicamente los que no fueron cotizados*/
						items.remove(ii);
						/*si el item esta cotizado debo actualizar la cotizacion por lo que actualizo la misma*/
						
						
					}
				}
			}
			
		}
		
		/*me quedan dos listas itemsCotizados e items que son los no cotizados*/
		
		
		
		
	}
	
	public void confirmarSolicitudCompra1(Integer idSolicitudCompra){
	
		SolicitudCompra solicitudCompra = solicitudCompraDAO.findById(idSolicitudCompra);
		solicitudCompra.setConfirmada(true);
		solicitudCompraDAO.update(solicitudCompra);
		
		/*HACER LA PARTE DE LA FACTURACION*/
	}
	public List<SolicitudCompra> findAll(){
		return solicitudCompraDAO.findAll(SolicitudCompra.class);
	}
	@Override
	public void confirmarSolicitudCompra(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
