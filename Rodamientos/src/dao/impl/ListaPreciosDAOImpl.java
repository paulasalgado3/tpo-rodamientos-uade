package dao.impl;

import generico.dao.impl.GenericDAOImpl;

import java.util.List;

import modelo.ListaPrecios;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.ListaPreciosDAO;

import util.hibernate.HibernateUtil;

public class ListaPreciosDAOImpl extends GenericDAOImpl<ListaPrecios> implements ListaPreciosDAO{

	@SuppressWarnings("unchecked")
	public List<Object> obtenerItems(Integer nroSerie, String marca, String paisOrigen){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from ListaPrecios lp join lp.items i where i.rodamiento.nroSerie = :nroSerie and i.rodamiento.marca = :marca and " +
				"i.rodamiento.paisOrigen = :paisOrigen";
		Query query = session.createQuery(hql);
		/*Seguro no anda..aprendé HQL ladri...*/
		
		return query.list();
	}

	@Override
	public ListaPrecios findByNumber(Integer nLista) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from ListaPrecios lp where lp.numeroLista = :numeroLista";
		Query query = session.createQuery(hql);
		query.setParameter("numeroLista", nLista);
		
		return (ListaPrecios) query.uniqueResult();
	}
}
