package dao;

import modelo.Cliente;
import generico.dao.GenericDAO;

public interface ClienteDAO extends GenericDAO<Cliente>{
	Cliente findByDni(String dni);

	void delete(Integer id);
}
