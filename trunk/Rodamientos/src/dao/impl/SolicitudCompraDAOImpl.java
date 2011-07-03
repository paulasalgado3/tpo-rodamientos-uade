package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import generico.dao.impl.GenericDAOImpl;
import modelo.Cliente;
import modelo.Cotizacion;
import modelo.Item;
import modelo.ListaPrecios;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Cotizacion> obtenerCotizacionCliente(Cliente cli) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("from Cotizacion as c where cliente.dni= ");
		q.setInteger("id", cli.getDni());
		
		return q.list();
		
	}
}
