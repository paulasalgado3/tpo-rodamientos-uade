package modelo;

import java.io.Serializable;
import java.util.Set;

public class Rodamiento implements Serializable{

	private int codigo;
	private String caracteristicas;
	private String marca;
	private String paisOrigen;
	private float precioUnitario;
	
	private Set<Rodamiento> equivalentes;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Set<Rodamiento> getEquivalentes() {
		return equivalentes;
	}

	public void setEquivalentes(Set<Rodamiento> equivalentes) {
		this.equivalentes = equivalentes;
	}
}
