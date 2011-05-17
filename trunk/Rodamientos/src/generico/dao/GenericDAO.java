package generico.dao;

import java.util.List;

public interface GenericDAO<T> {

	void save(T entidad);
	void delete(Integer id);
	List<T> findAll();
}
