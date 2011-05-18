package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CondicionCompra implements Serializable{

	
	private String formaPago;
	/* contado, y de 30 a 90 días (con o sin interés). Generalmente el proveedor
	 * determina descuentos por pago contado
	 */
	
	private Proveedor proveedor;
	//private Empresa empresa;//La empresa es siempre Rodacor
	
	/*Las condiciones de compra y los descuentos de cada lista de precios 
	 * son detallados por el proveedor a la empresa en cuestión. */
	
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
