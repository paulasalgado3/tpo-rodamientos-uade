package modelo;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class ListaOferta extends ListaPrecios implements Serializable{

	private Set<Oferta> ofertas;

	public Set<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(Set<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
}
