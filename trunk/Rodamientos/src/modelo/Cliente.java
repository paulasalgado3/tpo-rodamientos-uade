package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Cliente implements Serializable{

	private Integer idCliente;
	private String nombre;
	private String apellido;
	private Integer dni;
	private String telefono;
	/*
	 * Las distintas condiciones de pago son propias a cada cliente, otorgando
	 * mayores facilidades de pago a clientes que son de mayor interés a la
	 * empresa. Las condiciones de pago pueden, o no, tener un recargo de
	 * interés.
	 */
	
	private CondicionPago condicionpago;
	/*También puede otorgar descuentos adicionales a determinados clientes.*/
	private Descuento descuento;
	
	
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}	
}
