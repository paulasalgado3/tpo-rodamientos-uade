package modelo;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Proveedor implements Serializable{

	private Set<ListaPrecios> listaPrecios;
	/*
	 * Independientemente que un conjunto de listas de precios pertenezcan a un
	 * mismo proveedor, se tratan como listas separadas.
	 * Tengo una coleccion de listas que heredan de ListaPrecios (abstracta).
	 */

	public Set<ListaPrecios> getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(Set<ListaPrecios> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
}
