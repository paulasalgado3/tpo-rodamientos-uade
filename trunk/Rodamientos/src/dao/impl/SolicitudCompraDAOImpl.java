package dao.impl;

import generico.dao.impl.GenericDAOImpl;

import java.util.List;

import modelo.SolicitudCompra;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.hibernate.HibernateUtil;
import dao.SolicitudCompraDAO;

public class SolicitudCompraDAOImpl extends GenericDAOImpl<SolicitudCompra>
		implements SolicitudCompraDAO {

	
	public SolicitudCompra findById(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from SolicitudCompra sc where sc.id = :id");
		q.setInteger("id", id);
		
		return (SolicitudCompra) q.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudCompra> obtenerNoConfirmadas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(SolicitudCompra.class);
		criteria.add(Restrictions.ne("confirmada", true));
		return (List<SolicitudCompra>)criteria.list();
	}

	
}
