package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
public class Cotizacion implements Serializable {

	public Cotizacion() {
		super();
	}

	public Cotizacion(Cliente cliente, Float precioVenta) {
		super();
		this.cliente = cliente;
		this.precioVenta = precioVenta;
	}

	private Cliente cliente;
	private Float precioVenta;
	private List<Item> items;
	
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
