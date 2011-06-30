package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SolicitudCompra implements Serializable {

	private Integer id;
	private Boolean confirmada;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getConfirmada() {
		return confirmada;
	}

	public void setConfirmada(Boolean confirmada) {
		this.confirmada = confirmada;
	}	
}
