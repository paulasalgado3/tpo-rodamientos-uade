package test;

import java.util.List;

import modelo.Proveedor;
import dao.ProveedorDAO;
import dao.impl.ProveedorDAOImpl;

public class PruebaProveedorDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
		/*
		Proveedor proveedor = new Proveedor();
		proveedor.setCuit("20-34845905-9");
		proveedor.setRazonSocial("RodaRoda S.A.");
		proveedor.setTelefono("0800-rodaroda");
		proveedorDAO.save(proveedor);
		*/
		
		/*
		List<Proveedor> proveedores = proveedorDAO.findAll(Proveedor.class);
		System.out.println(proveedores.size());
		*/
		
		Proveedor p = proveedorDAO.findByCuit("20-34845905-9");
		System.out.println(p.getRazonSocial());
	}

}
