package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="cotizaciones")
public class Cotizacion implements Serializable {

	private int id;
	private Cliente cliente;
	private Float precioVenta;
	private Set<Item> items = new HashSet<Item>();


	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cotizacion")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cotizacion() {
		super();
	}

	public Cotizacion(Cliente cliente, Float precioVenta) {
		super();
		this.cliente = cliente;
		this.precioVenta = precioVenta;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
	public String toString(){
		return "Cliente:"+this.cliente+" PrecioVenta:"+ this.precioVenta + " Items:"+ this.items.toString();
	}

	@OneToMany(mappedBy = "cotizacion", cascade=CascadeType.ALL)
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
