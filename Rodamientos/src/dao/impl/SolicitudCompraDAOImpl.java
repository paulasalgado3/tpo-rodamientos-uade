package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import generico.dao.impl.GenericDAOImpl;
import modelo.SolicitudCompra;
import dao.SolicitudCompraDAO;

public class SolicitudCompraDAOImpl extends GenericDAOImpl<SolicitudCompra>
		implements SolicitudCompraDAO {

	
	public SolicitudCompra findById(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from SolicitudCompra sc where sc.id = :id");
		q.setInteger("id", id);
		
		return (SolicitudCompra) q.uniqueResult();
	}
}
