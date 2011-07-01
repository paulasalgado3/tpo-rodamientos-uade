package service.impl;

import modelo.Cliente;
import modelo.Cotizacion;
import dao.ClienteDAO;
import dao.CotizacionDAO;
import dao.impl.ClienteDAOImpl;
import dao.impl.CotizacionDAOImpl;
import service.CotizacionService;

public class CotizacionServiceImpl implements CotizacionService {

	CotizacionDAO cotizacionDAO = new CotizacionDAOImpl();
	
	@Override
	public void generarCotizacion(Integer dniCliente){
	
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		Cliente cliente = clienteDAO.findByDni(dniCliente);
		
		Cotizacion cotizacion = new Cotizacion();
		cotizacion.setCliente(cliente);
		
		/*COMPLETAR*/
		
		cotizacionDAO.save(cotizacion);
	}
}
