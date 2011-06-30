package dao;

import generico.dao.GenericDAO;
import modelo.SolicitudCompra;

public interface SolicitudCompraDAO extends GenericDAO<SolicitudCompra> {

	SolicitudCompra findById(Integer id);

}
