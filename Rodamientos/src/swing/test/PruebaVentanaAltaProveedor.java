package swing.test;

import java.rmi.Naming;

import swing.controladores.ControladorAltaProveedor;
import swing.ventanas.AltaProveedorFrame;

public class PruebaVentanaAltaProveedor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AltaProveedorFrame apf = new AltaProveedorFrame(new ControladorAltaProveedor());
		
	}

}
