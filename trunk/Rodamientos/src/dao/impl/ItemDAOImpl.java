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
		//FALTA STOCK Y DESCUENTO
		String hql = "from Item as i  where i.precio*i.listaPrecios.descuento  = (select min(i.precio*(1-i.listaPrecios.descuento)) from Item as i  where i.rodamiento.codigo =:codigo and i.rodamiento.marca in(:marcas) and i.rodamiento.paisOrigen =:paisOrigen and i.rodamiento.caracteristicas =:caracteristicas)";
		
		Query query = session.createQuery(hql);
		query.setString("codigo", codigo);
		query.setParameterList("marcas", marcas);
		query.setString("paisOrigen", paisOrigen);
		query.setString("caracteristicas", caracteristicas);
		Item i = (Item) query.uniqueResult();
		return i;
	}
}
