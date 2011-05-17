package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
public class Proveedor extends Persona implements Serializable{

	private Set<ListaPrecios> listaPrecios;
	/*
	 * Independientemente que un conjunto de listas de precios pertenezcan a un
	 * mismo proveedor, se tratan como listas separadas.
	 * Tengo una coleccion de listas que heredan de ListaPrecios (abstracta).
	 */
	private CondicionCompra condicionCompra;
	//El proveedor tiene mas de una Condicion de Compra??
	
	public Set<ListaPrecios> getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(Set<ListaPrecios> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	@OneToOne(cascade = CascadeType.ALL)
	public CondicionCompra getCondicionCompra() {
		return condicionCompra;
	}
	public void setCondicionCompra(CondicionCompra condicionCompra) {
		this.condicionCompra = condicionCompra;
	}
}
