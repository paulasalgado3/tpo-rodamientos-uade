package dao.impl;

import dao.ClienteDAO;
import modelo.Cliente;
import generico.dao.impl.GenericDAOImpl;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente> implements ClienteDAO{

	@Override
	public Cliente findByDni(String dni) {
		return null;
	}

}
