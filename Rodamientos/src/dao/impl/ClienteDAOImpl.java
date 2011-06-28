package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import dao.ClienteDAO;
import modelo.Cliente;
import generico.dao.impl.GenericDAOImpl;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente> implements ClienteDAO{

	@Override
	public Cliente findByDni(String dni) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Cliente c where c.dni = :dni";
		Query query = session.createQuery(hql);
		query.setParameter("dni", dni);
		
		return (Cliente)query.uniqueResult();
	}
	
	@Override
	public void delete(Integer id) {//tiene qe volar, heredar usando generics.
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = (Cliente)session.get(Cliente.class, id);
		if(cliente != null){
			super.delete(cliente);
			System.out.println("Borrado cliente " + cliente.getNombre() + " " + cliente.getApellido());
		}else {
			System.out.println("No existe un cliente con ese id");
		}
		session.close();
		
	}
}
