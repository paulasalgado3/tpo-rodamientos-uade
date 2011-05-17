package generico.dao.impl;

import java.util.List;

import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import generico.dao.GenericDAO;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@Override
	public void delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		
	}

	@Override
	public List<T> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		return null;
	}

	@Override
	public void save(T entidad) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(entidad);
		
		session.getTransaction().commit();
		session.close();
	}

}
