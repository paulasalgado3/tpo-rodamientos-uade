package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({ "serial", "rawtypes" })
public abstract class ListaPrecios implements Comparable, Serializable{

	/*Esta es la lista de un proveedor*/
	
	private Integer numeroLista;
	private Date fecha;
	private Integer vigencia;
	private Proveedor proveedor;
	private String tipo;//Oferta - Normal - etc.
	private Set<Item> items = new HashSet<Item>();
	private Double descuento;//descuento por lista de precio, no por item.
	
	@SuppressWarnings("deprecation")
	public int compareTo(Object otraLista) {
		if (!(otraLista instanceof ListaPrecios)) {
			throw new ClassCastException("Objeto Invalido para comparar");
		}
		ListaPrecios otra = (ListaPrecios)otraLista;
		
		/*
		 * Lista de Nº 103 del 1 Mar 2011 de SKF. (La lista anterior es sustituida
		 * por la nueva).
		 * */
		if(this.getFecha().getDate() == otra.getFecha().getDate()
				&& this.getNumeroLista().intValue() == otra.getNumeroLista().intValue()
				&& this.getProveedor().equals(otra.getProveedor())
				&& this.getTipo().equalsIgnoreCase(otra.getTipo())){
			
			return 0;//son iguales
		}
		return -1;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Integer getNumeroLista() {
		return numeroLista;
	}
	
	public Integer getVigencia() {
		return vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}
	public void setNumeroLista(Integer numeroLista) {
		this.numeroLista = numeroLista;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
}
