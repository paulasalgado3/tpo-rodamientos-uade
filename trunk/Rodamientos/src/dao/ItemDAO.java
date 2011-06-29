package dao;

import java.util.List;

import generico.dao.GenericDAO;
import modelo.Item;

public interface ItemDAO extends GenericDAO<Item> {

	Item obtenerItemPorMejorPrecio(String codigo, List<String> marcas, String paisOrigen, String caracteristicas);


}
