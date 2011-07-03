package dao.impl;

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

}
