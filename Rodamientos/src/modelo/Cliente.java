package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "clientes")
public class Cliente implements Serializable{

	private Integer id;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private CondicionPago condicionpago;// = condicionVenta
	/*También puede otorgar descuentos adicionales a determinados clientes.*/
	private Double descuento;
	/*
	 * Las distintas condiciones de pago son propias a cada cliente, otorgando
	 * mayores facilidades de pago a clientes que son de mayor interés a la
	 * empresa. Las condiciones de pago pueden, o no, tener un recargo de
	 * interés.
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
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
