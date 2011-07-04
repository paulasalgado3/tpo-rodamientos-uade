package dao;

import java.util.List;

import generico.dao.GenericDAO;
import modelo.SolicitudCompra;

public interface SolicitudCompraDAO extends GenericDAO<SolicitudCompra> {

	SolicitudCompra findById(Integer id);

	List<SolicitudCompra> obtenerNoConfirmadas();


}
