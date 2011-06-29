package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

	public void modificarProveedor(Proveedor proveedorAModificar) {
		// TODO Auto-generated method stub
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sesion.beginTransaction();
		String hql = "Update Proveedor p set p.razonSocial = :nuevaRazonSocial, p.cuit = :nuevoCUIT," +
				"p.telefono = :nuevoTelefono where p.id = :id ";
		
		Query query = sesion.createQuery(hql);
		query.setParameter("nuevaRazonSocial", proveedorAModificar.getRazonSocial());
		query.setParameter("nuevoCUIT", proveedorAModificar.getCuit());
		query.setParameter("nuevoTelefono", proveedorAModificar.getTelefono());
		query.setParameter("id", proveedorAModificar.getId());
		query.executeUpdate();
		tx.commit();
		sesion.close();
	}

}
