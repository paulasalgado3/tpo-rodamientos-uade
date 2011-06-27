package dao;

import java.util.List;

import generico.dao.GenericDAO;
import modelo.Item;

public interface ItemDAO extends GenericDAO<Item> {

	Item obtenerItemPorMejorPrecio(Integer nroSerie, List<String> marca, String paisOrigen);


}
