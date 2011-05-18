package modelo;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Empresa implements Serializable{

	/*Me parece q no iria esta clase..*/
	
	private String nombre;
	private Set<OficinaVenta> oficinasVenta;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<OficinaVenta> getOficinasVenta() {
		return oficinasVenta;
	}
	public void setOficinasVenta(Set<OficinaVenta> oficinasVenta) {
		this.oficinasVenta = oficinasVenta;
	}
}
