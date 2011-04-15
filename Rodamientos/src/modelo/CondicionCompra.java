package modelo;

public class CondicionCompra {

	/*
	 * contado, y de 30 a 90 días (con o sin interés). Generalmente el proveedor
	 * determina descuentos por pago contado
	 */
	private String formaPago;
	private String plazo;
	private Proveedor proveedor;
	
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
