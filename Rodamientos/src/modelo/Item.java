package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	private Integer id;
	private ListaPrecios listaPrecios;
	private Rodamiento rodamiento;
	private Float precio;
	private Integer cantidad;
	
	/*Al llegar una solicitud de un rodamiento, busco en cada lista de precio,
	 * si el precio es el mejor, pero no alcanza la cantidad, compro estos y sigo con el siguiente
	 * item por mejor precio.*/
	
	@Id
	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_lista_precio")
	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(ListaPrecios listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	
	//si guardo el item, q guarde el rodamiento si no existe (s�lo guardar en cascada).
	@ManyToOne
	@JoinColumn(name = "id_rodamiento")
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}	
	public String toString(){
		return  this.listaPrecios.toString()+" Id Item:"+this.getId()+" Precio:"+this.getPrecio()+" Stock:"+this.getCantidad()+this.getRodamiento().toString();
	}

	
}
