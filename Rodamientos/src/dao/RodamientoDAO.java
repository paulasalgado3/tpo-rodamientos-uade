package dao;

import generico.dao.GenericDAO;
import modelo.Rodamiento;

public interface RodamientoDAO extends GenericDAO<Rodamiento> {

	Rodamiento findByCodigo(String codigo);

}
