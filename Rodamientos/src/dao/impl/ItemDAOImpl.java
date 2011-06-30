package dao.impl;

import generico.dao.impl.GenericDAOImpl;

import java.util.List;

import modelo.Item;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;
import dao.ItemDAO;

public class ItemDAOImpl extends GenericDAOImpl<Item> implements ItemDAO{

	public Item obtenerItemPorMejorPrecio(String codigo, List<String> marcas, String paisOrigen, String caracteristicas){
		Session session = HibernateUtil.getSessionFactory().openSession();
		//FALTA STOCK
		String hql = "from Item as ii  where (ii.precio*(1-ii.listaPrecios.descuento))  = (select min(i.precio*(1-i.listaPrecios.descuento)) from Item as i  where i.rodamiento.codigo =:codigo and i.rodamiento.marca in(:marcas) and i.rodamiento.paisOrigen =:paisOrigen and i.rodamiento.caracteristicas =:caracteristicas)";
		
		Query query = session.createQuery(hql);
		query.setString("codigo", codigo);
		query.setParameterList("marcas", marcas);
		query.setString("paisOrigen", paisOrigen);
		query.setString("caracteristicas", caracteristicas);
		Item i = (Item) query.uniqueResult();
		return i;
	}

	@SuppressWarnings("unchecked")
	public List<Item> obtenerItemPorMejorPrecioCant(String codigo,
			List<String> marcas, String paisOrigen, String caracteristicas,
			int cantidad) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//FALTA STOCK
		String hql = " from Item as i  where i.rodamiento.codigo =:codigo and i.rodamiento.marca in(:marcas) and i.rodamiento.paisOrigen =:paisOrigen and i.rodamiento.caracteristicas =:caracteristicas order by (i.precio*(1-i.listaPrecios.descuento))desc";
		Query query = session.createQuery(hql);
		query.setString("codigo", codigo);
		query.setParameterList("marcas", marcas);
		query.setString("paisOrigen", paisOrigen);
		query.setString("caracteristicas", caracteristicas);
		
		List<Item> items=query.list();
		return items;
	}
}
