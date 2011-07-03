package service.impl;

import java.util.Set;

import modelo.Cliente;
import modelo.Cotizacion;
import modelo.Item;
import dao.ClienteDAO;
import dao.CotizacionDAO;
import dao.impl.ClienteDAOImpl;
import dao.impl.CotizacionDAOImpl;
import service.CotizacionService;

public class CotizacionServiceImpl implements CotizacionService {

	CotizacionDAO cotizacionDAO = new CotizacionDAOImpl();
	
	@Override
	public void generarCotizacion(Integer dniCliente,Set<Item> items){
	
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		Cliente cliente = clienteDAO.findByDni(dniCliente);
		
		Cotizacion cotizacion = new Cotizacion();
		cotizacion.setCliente(cliente);
		cotizacion.setItems(items);
		
		/*COMPLETAR*/
		
		cotizacionDAO.save(cotizacion);
	}
}
