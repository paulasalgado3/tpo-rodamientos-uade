package dao.impl;

import java.util.List;

import generico.dao.impl.GenericDAOImpl;
import modelo.Item;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;
import dao.ItemDAO;

public class ItemDAOImpl extends GenericDAOImpl<Item> implements ItemDAO{

	public Item obtenerItemPorMejorPrecio(String codigo, List<String> marcas, String paisOrigen, String caracteristicas){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Item as i join i.rodamiento as r where r.codigo =:codigo and r.marca in:marcas and r.paisOrigen =:paisOrigen and r.caracteristicas =:caracteristicas";
		Query query = session.createQuery(hql);
		query.setString("codigo", codigo);
		query.setParameterList("marcas", marcas);
		query.setString("paisOrigen", paisOrigen);
		query.setString("caracteristicas", caracteristicas);
		return (Item) query.uniqueResult();
	}
}
