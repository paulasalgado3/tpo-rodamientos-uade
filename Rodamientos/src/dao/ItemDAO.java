package dao;

import generico.dao.GenericDAO;
import modelo.Item;

public interface ItemDAO extends GenericDAO<Item> {

	Item obtenerItems(Integer nroSerie, String marca, String paisOrigen);

}
