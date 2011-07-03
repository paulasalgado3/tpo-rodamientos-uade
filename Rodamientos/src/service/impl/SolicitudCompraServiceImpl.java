package service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import modelo.Cliente;
import modelo.Cotizacion;
import modelo.Item;
import modelo.ItemCotizacion;
import modelo.SolicitudCompra;
import dao.CotizacionDAO;
import dao.SolicitudCompraDAO;
import dao.impl.CotizacionDAOImpl;
import dao.impl.SolicitudCompraDAOImpl;
import service.SolicitudCompraService;

public class SolicitudCompraServiceImpl implements SolicitudCompraService{

	SolicitudCompraDAO solicitudCompraDAO = new SolicitudCompraDAOImpl();
	
	public void generarSolicitudCompra(Set<Item> items, Cliente cli){
		/*genero un set de solicitudes de compra ya que si hay items cotizados y 
		 * sin cotizar ya son dos solicitudes, y si hay items de mas de una cotizacion es una solicitud por cada cotizacion
		 * */
		Set<SolicitudCompra> solicitudes = new HashSet<SolicitudCompra>();

		/*primero me fijo si el cliente tiene una o varias cotizaciones*/
		List<Cotizacion> cotizaciones =solicitudCompraDAO.obtenerCotizacionCliente(cli);
		/*me fijo si los items corresponden a alguna de las cotizaciones anteriores*/
		Set<ItemCotizacion> itemsCotizados = new HashSet<ItemCotizacion>();
		for (Cotizacion c :cotizaciones){
			Set<Item> it = c.getItems();
			for(Item i:it){
				for(Item ii:items){
					if(ii.getId()==i.getId()){
						/*si son el mismo item quiere decir que se cotizo previamente*/
						itemsCotizados.add(new ItemCotizacion(ii,c));
						/*lo remuevo de la lista de items para que me queden unicamente los que no fueron cotizados*/
						items.remove(ii);
					}
				}
			}
			
		}
		
		/*me quedan dos listas itemsCotizados(con el item y si cotizacion correspondiente) e items no cotizados*/
		/*con los items no cotizados genero una cotizacion*/
		if(!items.isEmpty()){
			//CotizacionServiceImpl csi = new CotizacionServiceImpl();
			//csi.generarCotizacion(cli.getDni(),items);
			//COMENTADO PORQUE EL METODO DE GENERAR COTIZACION NO ESTA
		
		
		}
		/*CREAR SOLICITUD COMPRA (UNA SOLA POR COTIZACION)
		 * PONERLE ITEMS
		 * ACTUALIZAR COTIZACION CON EL NUMERO DE SOLICITUD DE COMPRA
		 */
		/*con los items cotizados genero las solicitudes de compra correspondientes (una por cotizacion)*/
		CotizacionDAO cDAO = new CotizacionDAOImpl();
		Integer solicitudcotizaciongenerada =0;
		for(ItemCotizacion ic:itemsCotizados){
			solicitudcotizaciongenerada=0;
			for(SolicitudCompra sol:solicitudes){
				if(sol.getId()==ic.getCot().getId()){
					solicitudcotizaciongenerada=1;
					sol.getItems().add(ic.getItem());
					
				}
			}
			//si no hay una solicitud para ese numero de cotizacion la creo
			if(solicitudcotizaciongenerada==0){
				SolicitudCompra solicitud1 = new SolicitudCompra();
				solicitud1.setCli(cli);
				solicitud1.setItems(new HashSet<Item>());
				solicitud1.getItems().add(ic.getItem());
				solicitudes.add(solicitud1);
				/*les seteo a las cotizaciones las solicitudes*/
				Cotizacion c=cDAO.findById(ic.getCot().getId());
				c.setSolicitudCompra(solicitud1);
				cDAO.update(c);
			}
			
			
		}
		/*guardo las solicitudes de compra*/
		SolicitudCompraDAO sDAO = new SolicitudCompraDAOImpl();
		for(SolicitudCompra s:solicitudes){
			sDAO.save(s);
		}
		
		
	
		
		
		
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
