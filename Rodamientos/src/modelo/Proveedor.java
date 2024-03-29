package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable{

	// ATRIBUTOS
	private Integer id;
	private String razonSocial;
	private String cuit;
	private String telefono;
	private Set<ListaPrecios> listaPrecios;

	// CONSTRUCTORES (son una banda)
	
	public Proveedor() {}	

	public Proveedor(String razonSocial, String cuit, String telefono) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.telefono = telefono;
	}
	
	
	public Proveedor(String cuit,
			Integer id, Set<ListaPrecios> listaPrecios, String razonSocial,
			String telefono) {
		super();
		this.condicionesCompra = null;
		this.cuit = cuit;
		this.id = id;
		this.listaPrecios = listaPrecios;
		this.razonSocial = razonSocial;
		this.telefono = telefono;
	}
	
	
	/*
	 * Independientemente que un conjunto de listas de precios pertenezcan a un
	 * mismo proveedor, se tratan como listas separadas.
	 * Tengo una coleccion de listas que heredan de ListaPrecios (abstracta).
	 */
	private Set<CondicionCompra> condicionesCompra;
	/*Supongo que el proveedor tiene mas de una Condicion de Compra,
	 * una para cada empresa*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	public Integer getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(Integer id) {
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
	
	@OneToMany(mappedBy = "proveedor")
	public Set<ListaPrecios> getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(Set<ListaPrecios> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	@OneToMany(mappedBy = "proveedor")
	public Set<CondicionCompra> getCondicionesCompra() {
		return condicionesCompra;
	}
	public void setCondicionesCompra(Set<CondicionCompra> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}
	
	//como puede tener varias listas de precios (porque es un set) hago un metodo para setearle una sola y no todo el set.
	public void setunaListaPrecio(ListaPrecios lp){
		this.listaPrecios.add(lp);
	}
}
