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
		Proveedor proveedor = new Proveedor();
		proveedor.setCuit("123456789");
		proveedor.setRazonSocial("Razon Social SA");
		proveedor.setTelefono("0800-666-1111");
		
		
		proveedorDAO.save(proveedor);
		
		
		//Listo todos
		
		List<Proveedor> proveedores = proveedorDAO.findAll(Proveedor.class);
		System.out.println(proveedores.size());
		
		
		//busco por cuit
		Proveedor p = proveedorDAO.findByCuit("123456789");
		System.out.println(p.getRazonSocial());
	}

}
