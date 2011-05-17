package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cliente implements Serializable{

	/*
	 * Las distintas condiciones de pago son propias a cada cliente, otorgando
	 * mayores facilidades de pago a clientes que son de mayor interés a la
	 * empresa. Las condiciones de pago pueden, o no, tener un recargo de
	 * interés.
	 */
	private CondicionPago condicionpago;
	/*También puede otorgar descuentos adicionales a determinados clientes.*/
	private Descuento descuento;
	
	public Descuento getDescuento() {
		return descuento;
	}
	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}
	public CondicionPago getCondicionpago() {
		return condicionpago;
	}
	public void setCondicionpago(CondicionPago condicionpago) {
		this.condicionpago = condicionpago;
	}
	
	
}
