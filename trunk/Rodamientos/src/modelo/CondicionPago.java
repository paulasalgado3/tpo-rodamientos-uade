package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "condiciones_pago")
@SuppressWarnings("serial")
public class CondicionPago implements Serializable{

	private Integer id;
	/*
	 * Las distintas condiciones de pago son propias a cada cliente, otorgando
	 * mayores facilidades de pago a clientes que son de mayor interés a la
	 * empresa. Las condiciones de pago pueden, o no, tener un recargo de
	 * interés.
	 */
	private boolean conInteres;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isConInteres() {
		return conInteres;
	}

	public void setConInteres(boolean conInteres) {
		this.conInteres = conInteres;
	}
}
