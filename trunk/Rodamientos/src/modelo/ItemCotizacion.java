package modelo;
/*no se persiste, la uso para la parte de generar muchas solicitudes de compra porque una cotizacion tiene muchos items pero en el momento un item puede 
 * estar asociado a muchas cotizaciones y necesito saber a que cotizacion de un cliente esta asociada*/

public class ItemCotizacion {
	public ItemCotizacion(Item item, Cotizacion cot) {
		super();
		this.item = item;
		this.cot = cot;
	}
	private Item item;
	private Cotizacion cot;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Cotizacion getCot() {
		return cot;
	}
	public void setCot(Cotizacion cot) {
		this.cot = cot;
	}
}
