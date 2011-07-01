package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Entity
@Table (name="cotizaciones")
public class Cotizacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Cotizacion() {
		super();
	}

	public Cotizacion(Cliente cliente, Float precioVenta) {
		super();
		this.cliente = cliente;
		this.precioVenta = precioVenta;
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cotizacion")
	private int id;
	private Cliente cliente;
	private Float precioVenta;
	private List<Item> items = new ArrayList<Item>();
	
	
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
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn (name="id")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}	
	public String toString(){
		return "Cliente:"+this.cliente+" PrecioVenta:"+ this.precioVenta + " Items:"+ this.items.toString();
	}
}
