package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import dao.ClienteDAO;
import modelo.Cliente;
import generico.dao.impl.GenericDAOImpl;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente> implements ClienteDAO{

	@Override
	public Cliente findByDni(String dni) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Cliente c where c.dni = :dni";
		Query query = session.createQuery(hql);
		query.setParameter("dni", dni);
		
		return (Cliente)query.uniqueResult();
	}

}
