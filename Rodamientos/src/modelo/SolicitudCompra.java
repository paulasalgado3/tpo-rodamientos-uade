package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "solicitudes_compra")
@SuppressWarnings("serial")
public class SolicitudCompra implements Serializable {

	private Integer id;
	private Boolean confirmada = false;//valor por defecto
	private Cliente cli;
	private Set<Item> items = new HashSet<Item>();
	@Transient
	private Integer id_cotizacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_solicitud_compra")
	public Integer getId() {
		return id;
	}
	private void setId(Integer id) {
		this.id = id;
	}

	public Boolean getConfirmada() {
		return confirmada;
	}

	public void setConfirmada(Boolean confirmada) {
		this.confirmada = confirmada;
	}
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	@ManyToMany
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
@Transient
	public Integer getId_cotizacion() {
		return id_cotizacion;
	}

	public void setId_cotizacion(Integer id_cotizacion) {
		this.id_cotizacion = id_cotizacion;
	}	
}
