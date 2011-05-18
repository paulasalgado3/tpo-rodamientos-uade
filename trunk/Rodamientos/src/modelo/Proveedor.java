package modelo;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Proveedor extends Persona implements Serializable{

	private Set<ListaPrecios> listaPrecios;
	/*
	 * Independientemente que un conjunto de listas de precios pertenezcan a un
	 * mismo proveedor, se tratan como listas separadas.
	 * Tengo una coleccion de listas que heredan de ListaPrecios (abstracta).
	 */
	private Set<CondicionCompra> condicionesCompra;
	/*Supongo que el proveedor tiene mas de una Condicion de Compra,
	 * una para cada empresa*/
	
	public Set<ListaPrecios> getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(Set<ListaPrecios> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	public Set<CondicionCompra> getCondicionesCompra() {
		return condicionesCompra;
	}
	public void setCondicionesCompra(Set<CondicionCompra> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}
}
