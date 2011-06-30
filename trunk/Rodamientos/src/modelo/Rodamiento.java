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

	/*el id es para hibernate, por eso lo pongo como privado el getter y setter*/
	private Integer id;
	private String codigo;
	private String caracteristicas;
	private String marca;
	private String paisOrigen;
	/* opino lo mismo del nuemro de serie, entiendo que hay que identificarlo por codigo
 	private Integer nroSerie;
	 */
	//private Set<Rodamiento> equivalentes; //Esto despues lo vemos..

	@SuppressWarnings("unused")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Marca:"+this.marca+" Codigo:"+this.codigo + " Características:"+this.caracteristicas + " Pais Origen:"+this.paisOrigen ;
	}
}
