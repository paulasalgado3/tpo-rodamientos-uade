package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rodamientos")
@SuppressWarnings("serial")
public class Rodamiento implements Serializable{

	private Integer id;
	private Integer codigo;
	private String caracteristicas;
	private String marca;
	private String paisOrigen;
	private Integer nroSerie;
	//private Set<Rodamiento> equivalentes; //Esto despues lo vemos..

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	/*
	public Set<Rodamiento> getEquivalentes() {
		return equivalentes;
	}

	public void setEquivalentes(Set<Rodamiento> equivalentes) {
		this.equivalentes = equivalentes;
	}
	*/
	public Integer getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(Integer nroSerie) {
		this.nroSerie = nroSerie;
	}
}
