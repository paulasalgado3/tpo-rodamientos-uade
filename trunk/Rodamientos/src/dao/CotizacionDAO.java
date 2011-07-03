package dao;

import generico.dao.GenericDAO;
import modelo.Cliente;
import modelo.Cotizacion;

public interface CotizacionDAO extends GenericDAO<Cotizacion> {
	Cotizacion findById(Integer id);
}
