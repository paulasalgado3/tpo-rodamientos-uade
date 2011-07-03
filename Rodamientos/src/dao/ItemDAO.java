package dao;

import java.util.List;

import generico.dao.GenericDAO;
import modelo.Item;

public interface ItemDAO extends GenericDAO<Item> {

	List<Item> obtenerItemPorMejorPrecio(String codigo, List<String> marcas, String paisOrigen, String caracteristicas);
	List<Item> obtenerItemPorMejorPrecioCant(String codigo, List<String> marcas, String paisOrigen, String caracteristicas, int cantidad);
	Item findById(Integer id);
}
