package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;

@Entity
@SuppressWarnings("serial")
public class Proveedor implements Serializable{

	private Integer id;
	private String razonSocial;
	private String cuit;
	private String telefono;
	//private Set<ListaPrecios> listaPrecios;
	
	
	/*
	 * Independientemente que un conjunto de listas de precios pertenezcan a un
	 * mismo proveedor, se tratan como listas separadas.
	 * Tengo una coleccion de listas que heredan de ListaPrecios (abstracta).
	 */
	private Set<CondicionCompra> condicionesCompra;
	/*Supongo que el proveedor tiene mas de una Condicion de Compra,
	 * una para cada empresa*/
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/*
	public Set<ListaPrecios> getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(Set<ListaPrecios> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	*/
	
	public Set<CondicionCompra> getCondicionesCompra() {
		return condicionesCompra;
	}
	public void setCondicionesCompra(Set<CondicionCompra> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}
	public Proveedor(String razonSocial, String cuit, String telefono) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.telefono = telefono;
	}
	
}
