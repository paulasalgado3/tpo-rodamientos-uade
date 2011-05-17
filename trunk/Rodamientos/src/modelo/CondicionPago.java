package modelo;

import java.io.Serializable;

public class CondicionPago implements Serializable{

	/*
	 * Las distintas condiciones de pago son propias a cada cliente, otorgando
	 * mayores facilidades de pago a clientes que son de mayor inter�s a la
	 * empresa. Las condiciones de pago pueden, o no, tener un recargo de
	 * inter�s.
	 */
	private boolean conInteres;

	public boolean isConInteres() {
		return conInteres;
	}

	public void setConInteres(boolean conInteres) {
		this.conInteres = conInteres;
	}
}
