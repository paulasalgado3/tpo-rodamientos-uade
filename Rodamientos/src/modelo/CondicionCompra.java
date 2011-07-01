package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "condiciones_compra")
@SuppressWarnings("serial")
public class CondicionCompra implements Serializable{

	private Integer id;
	private String formaPago;
	//private double interes;
	
	/* contado, y de 30 a 90 días (con o sin interés). Generalmente el proveedor
	 * determina descuentos por pago contado
	 */
	
	private Proveedor proveedor;
	//private Empresa empresa;//La empresa es siempre Rodacor
	
	/*Las condiciones de compra y los descuentos de cada lista de precios 
	 * son detallados por el proveedor a la empresa en cuestión. */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
