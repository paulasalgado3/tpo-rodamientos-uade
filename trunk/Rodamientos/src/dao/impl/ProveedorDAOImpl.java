package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import generico.dao.impl.GenericDAOImpl;
import modelo.Proveedor;
import dao.ProveedorDAO;

public class ProveedorDAOImpl extends GenericDAOImpl<Proveedor> implements
		ProveedorDAO {

	@Override
	public Proveedor findByCuit(String cuit) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Proveedor p where p.cuit = :cuit";
		Query query = session.createQuery(hql);
		query.setParameter("cuit", cuit);
		Proveedor p = (Proveedor) query.uniqueResult();
		session.close();
		
		return p;
	}

	public boolean borrarProveedor(String numeroCUIT) {
		if (findByCuit(numeroCUIT) == null)
			return false;
		
		else {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.delete(findByCuit(numeroCUIT));
			
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
	}

}
