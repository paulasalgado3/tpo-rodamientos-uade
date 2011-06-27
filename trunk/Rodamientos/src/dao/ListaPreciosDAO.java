package dao;

import generico.dao.GenericDAO;
import modelo.Item;
import modelo.ListaPrecios;

public interface ListaPreciosDAO extends GenericDAO<ListaPrecios> {

	ListaPrecios findByNumber(Integer nLista);

	void delete(Integer id);
}
