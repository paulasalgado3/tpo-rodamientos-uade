package dao.impl;

import generico.dao.impl.GenericDAOImpl;
import modelo.Item;
import modelo.ListaPrecios;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;
import dao.ListaPreciosDAO;

public class ListaPreciosDAOImpl extends GenericDAOImpl<ListaPrecios> implements ListaPreciosDAO{

	

	@Override
	public ListaPrecios findByNumber(Integer nLista) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from ListaPrecios lp where lp.numeroLista = :numeroLista";
		Query query = session.createQuery(hql);
		query.setParameter("numeroLista", nLista);
		
		return (ListaPrecios) query.uniqueResult();
	}
	@Override
	public void delete(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ListaPrecios lp = (ListaPrecios)session.get(ListaPrecios.class, id);
		if(lp != null){
			super.delete(lp);
			System.out.println("Eliminada lista numero " + lp.getNumeroLista());
		}else{
			System.out.println("No existe ninguna lista con id = " + id);
		}
		session.getTransaction().commit();
		session.close();
	}
}
