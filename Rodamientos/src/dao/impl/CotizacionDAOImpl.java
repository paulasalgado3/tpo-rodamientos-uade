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
		
		Cotizacion c = (Cotizacion) query.uniqueResult();
		session.close();
		return c;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cotizacion> obtenerCotizacionCliente(Cliente cli) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Cotizacion as c where cliente.dni=:dni ");
		q.setInteger("dni", cli.getDni());
		return q.list();
		
	}
	@Override
	public void update(Cotizacion c){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(c);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
