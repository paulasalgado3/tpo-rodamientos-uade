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
	}
	
	public boolean modificarProveedor(String viejoCuit, String nuevoCuit, String razSoc, String tel){
		Proveedor proveedorModificado = new ProveedorDAOImpl().findByCuit(viejoCuit);
		if (proveedorModificado == null)
			return false;
		proveedorModificado.setCuit(nuevoCuit);
		proveedorModificado.setRazonSocial(razSoc);
		proveedorModificado.setTelefono(tel);
		new ProveedorDAOImpl().modificarProveedor(proveedorModificado);
		return true;
	}
	
	public boolean bajarProveedor(String CUIT){
		return new ProveedorDAOImpl().borrarProveedor(CUIT);
	}
	
	public void listarProveedores(){
		System.out.println("Mete aca el codigo para listar TODOS los proveedores");
	}
}
