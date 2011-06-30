package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings({ "serial", "rawtypes" })
@Entity
@Table(name = "listas_precios")
public class ListaPrecios implements Comparable, Serializable{

	/*Esta es la lista de un proveedor*/
	private Integer id;
	private Integer numeroLista;//Podría ser un String tmb..
	private Date fecha;
	private Integer vigencia;
	private Proveedor proveedor;
	private String tipo;//Oferta - Normal - etc.
	private List<Item> items = new ArrayList<Item>();
	private Double descuento;//descuento por lista de precio, no por item.
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista_precio")
	public Integer getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}
	
	@SuppressWarnings("deprecation")
	public int compareTo(Object otraLista) {
		if (!(otraLista instanceof ListaPrecios)) {
			throw new ClassCastException("Objeto Invalido para comparar");
		}
		ListaPrecios otra = (ListaPrecios)otraLista;
		
		/*
		 * Lista de Nº 103 del 1 Mar 2011 de SKF. (La lista anterior es sustituida
		 * por la nueva).
		 * */
		if(this.getFecha().getDate() == otra.getFecha().getDate()
				&& this.getNumeroLista().intValue() == otra.getNumeroLista().intValue()
				&& this.getProveedor().equals(otra.getProveedor())
				&& this.getTipo().equalsIgnoreCase(otra.getTipo())){
			
			return 0;//son iguales
		}
		return -1;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//si borro la lista, q borre todos los items en cascada
	@OneToMany(mappedBy = "listaPrecios", cascade = CascadeType.ALL)
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> itemList) {
		this.items = itemList;
	}

	public Integer getNumeroLista() {
		return numeroLista;
	}
	
	public Integer getVigencia() {
		return vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}
	public void setNumeroLista(Integer numeroLista) {
		this.numeroLista = numeroLista;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public String toString(){
		return "Nro Lista Precios:"+this.numeroLista;
	}
}
