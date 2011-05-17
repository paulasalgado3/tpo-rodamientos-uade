package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CondicionCompra implements Serializable{

	/*
	 * contado, y de 30 a 90 días (con o sin interés). Generalmente el proveedor
	 * determina descuentos por pago contado
	 */
	private String formaPago;
	private Proveedor proveedor;
	
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
