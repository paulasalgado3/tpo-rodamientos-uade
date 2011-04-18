package modelo;

public class Descuento {

	/*
	 * Es política de la empresa efectuar descuentos por pago contado o por pago
	 * a corto plazo (30 / 60 días). También puede otorgar descuentos
	 * adicionales a determinados clientes.
	 */
	private Cliente cliente;
	private String tipo;

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
