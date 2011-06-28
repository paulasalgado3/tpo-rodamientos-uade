package swing.ventanas;

import java.awt.event.*;
import javax.swing.*;

public class MenuArchivo extends JMenu{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuItem menuItemIniciar;
	private JMenuItem menuItemMostrarUsuarios;
	private JMenuItem menuItemNuevoUsuario;
	private JMenuItem menuItemFinalizar;
	private JMenuItem menuItemBorrarUsuario;
	private JMenuItem menuItemModificarUsuario;
	
	public MenuArchivo() {
		super("Archivo");
		setMenu();
	}
	
	private void setMenu() {
		
		// Tuneo los elementos que va a tener mi menu
		
		
		menuItemFinalizar = new JMenuItem("Cerrar");
		menuItemFinalizar.setToolTipText("Cierra la ventana");
		menuItemFinalizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		menuItemFinalizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				CasaCentralRun.cerrarVentana();
			}});
		
		
		// Cargo todos mis elementos al menu
		add(menuItemFinalizar);
	}
}
