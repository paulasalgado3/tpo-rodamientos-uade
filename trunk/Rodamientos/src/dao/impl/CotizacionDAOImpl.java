package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;
import generico.dao.impl.GenericDAOImpl;
import modelo.Cliente;
import modelo.Cotizacion;
import dao.CotizacionDAO;

public class CotizacionDAOImpl extends GenericDAOImpl<Cotizacion> implements
		CotizacionDAO {
	
	@Override
	public Cotizacion findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Cotizacion c where c.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		
		return (Cotizacion)query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cotizacion> obtenerCotizacionCliente(Cliente cli) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Cotizacion as c where cliente.dni=:dni ");
		q.setInteger("dni", cli.getDni());
		
		return q.list();
		
	}

}
