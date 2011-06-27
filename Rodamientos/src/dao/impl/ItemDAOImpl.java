package dao.impl;

import generico.dao.impl.GenericDAOImpl;
import modelo.Item;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;
import dao.ItemDAO;

public class ItemDAOImpl extends GenericDAOImpl<Item> implements ItemDAO{

	@Override
	public Item obtenerItems(Integer nroSerie, String marca, String paisOrigen){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Item as i where i.rodamiento.nroSerie = :nroSerie and i.rodamiento.marca = :marca and i.rodamiento.paisOrigen = :paisOrigen";
		Query query = session.createQuery(hql);
		query.setInteger("nroSerie", nroSerie);
		query.setString("marca", marca);
		query.setString("paisOrigen", paisOrigen);
		
		return (Item) query.uniqueResult();
	}
}
