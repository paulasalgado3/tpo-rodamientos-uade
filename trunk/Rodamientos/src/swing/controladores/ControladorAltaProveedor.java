package swing.controladores;

import javax.swing.JFrame;

public class ControladorAltaProveedor {
	private JFrame ventana;
	
	public void agregarProveedor(String razonSocial, String cuit,
			String telefono) {
		
		
	}

	public void cancelar() {
		this.ventana.dispose();
	}

	public JFrame getVentana() {
		return ventana;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}
	public ControladorAltaProveedor() {
		// Creo que acá debería obtener el objeto por rmi, para usarlo en las altas.
	}

}
