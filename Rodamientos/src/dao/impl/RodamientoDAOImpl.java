package dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.hibernate.HibernateUtil;

import generico.dao.impl.GenericDAOImpl;
import modelo.Rodamiento;
import dao.RodamientoDAO;

public class RodamientoDAOImpl extends GenericDAOImpl<Rodamiento> implements
		RodamientoDAO {

	@Override
	public Rodamiento findByCodigo(Integer codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Rodamiento.class);
		criteria.add(Restrictions.eq("codigo", codigo));
		
		return (Rodamiento) criteria.uniqueResult();
	}

}
