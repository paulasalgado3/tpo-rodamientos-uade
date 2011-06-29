package swing.controladores;

import dao.impl.ProveedorDAOImpl;
import modelo.Proveedor;

public class ManejadorEventosProveedor {
	
	private static ManejadorEventosProveedor instancia = null;
	static {
		if(instancia == null) instancia = new ManejadorEventosProveedor();
	}
			
	public static ManejadorEventosProveedor getInstancia() {
		return instancia;
	}
	
	public void agregarProveedor(String razonSocial, String CUIT, String telefono){
		Proveedor nuevoProveedor = new Proveedor(razonSocial, CUIT, telefono);
		new ProveedorDAOImpl().save(nuevoProveedor);
		System.out.println("Agregue al proveedor de CUIT"+CUIT);
	}
	
	public void modificarProveedor(){
		System.out.println("Mete aca el codigo del MOdificar DAO");
	}
	
	public void bajarProveedor(String CUIT){
		new ProveedorDAOImpl().delete(new ProveedorDAOImpl().findByCuit(CUIT));
		System.out.println("Mete el codigo del DAO, el CUIT del chabon a bajar es:"+CUIT);
	}
	
	public void listarProveedores(){
		System.out.println("Mete aca el codigo para listar TODOS los proveedores");
	}
}
