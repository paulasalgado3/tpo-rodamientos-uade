package swing.controladores;

public class ManejadorEventosProveedor {
	
	private static ManejadorEventosProveedor instancia = null;
	static {
		if(instancia == null) instancia = new ManejadorEventosProveedor();
	}
			
	public static ManejadorEventosProveedor getInstancia() {
		return instancia;
	}
	
	public void agregarProveedor(){
		System.out.println("Mete aca el codigo del DAO agregar");
	}
	
	public void modificarProveedor(){
		System.out.println("Mete aca el codigo del MOdificar DAO");
	}
	
	public void bajarProveedor(String CUIT){
		System.out.println("Mete el codigo del DAO, el CUIT del chabon a bajar es:"+CUIT);
	}
	
	public void listarProveedores(){
		System.out.println("Mete aca el codigo para listar TODOS los proveedores");
	}
}
