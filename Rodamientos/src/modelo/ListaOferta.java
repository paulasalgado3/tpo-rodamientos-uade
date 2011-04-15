package modelo;

public class ListaOferta extends ListaPrecios {

	/*
	 * Los proveedores publican listas de ofertas donde indican descuentos sobre los ítems.
	 * */
	private float descuento;
	private Rodamiento rodamiento;
	
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	
	
}
