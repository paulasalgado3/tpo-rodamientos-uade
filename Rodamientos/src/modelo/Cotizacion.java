package modelo;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
public class Cotizacion implements Serializable {

	private Cliente cliente;
	private Float precioVenta;

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
}
