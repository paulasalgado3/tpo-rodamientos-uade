package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "clientes")
public class Cliente implements Serializable{

	private Integer id;
	private String nombre;
	private String apellido;
	private Integer dni;
	private String telefono;
	private CondicionPago condicionpago;// = condicionVenta
	/*Tambi�n puede otorgar descuentos adicionales a determinados clientes.*/
	private Double descuento;
	/*
	 * Las distintas condiciones de pago son propias a cada cliente, otorgando
	 * mayores facilidades de pago a clientes que son de mayor inter�s a la
	 * empresa. Las condiciones de pago pueden, o no, tener un recargo de
	 * inter�s.
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	public Integer getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@OneToOne
	@JoinColumn(name = "id_condicion")
	public CondicionPago getCondicionpago() {
		return condicionpago;
	}
	public void setCondicionpago(CondicionPago condicionpago) {
		this.condicionpago = condicionpago;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}	
}
