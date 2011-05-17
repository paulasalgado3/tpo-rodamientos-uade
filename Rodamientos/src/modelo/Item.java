package modelo;

public class Item {

	private ListaPrecios listaPrecios;
	private Rodamiento rodamiento;
	private Float precio;
	
	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}
	public void setListaPrecios(ListaPrecios listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
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
	
	
}
