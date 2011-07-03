package dao;

import java.util.List;

import generico.dao.GenericDAO;
import modelo.Cliente;
import modelo.Cotizacion;
import modelo.Item;
import modelo.SolicitudCompra;

public interface SolicitudCompraDAO extends GenericDAO<SolicitudCompra> {

	SolicitudCompra findById(Integer id);

	List<Cotizacion> obtenerCotizacionCliente(Cliente cli);

}
