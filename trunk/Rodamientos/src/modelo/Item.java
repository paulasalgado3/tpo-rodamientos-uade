package modelo;

public class Item {

	private ListaPrecios listaPrecios;
	private Rodamiento rodamiento;
	private Float precio;
	private Integer cantidad;
	/*Al llegar una solicitud de un rodamiento, busco en cada lista de precio,
	 * si el precio es el mejor, pero no alcanza la cantidad, compro estos y sigo con el siguiente
	 * item por mejor precio.*/
	
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
