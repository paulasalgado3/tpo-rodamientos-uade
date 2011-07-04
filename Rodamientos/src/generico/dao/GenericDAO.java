package generico.dao;

import java.util.List;

public interface GenericDAO<T> {

	void save(T entidad);
	void delete(T entity);
	List<T> findAll(Class clazz);
	void update(T entidad);
	void merge(T entidad);
	
	
}
