package swing.ventanas;

import java.awt.event.*;
import javax.swing.*;
import swing.controladores.ManejadorEventosDB;

public class MenuArchivo extends JMenu{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuItem menuItemIniciarConexionDB;
	private JMenuItem menuItemFinalizar;
	
	public MenuArchivo() {
		super("Archivo");
		setMenu();
	}
	
	private void setMenu() {
		
		// Tuneo los elementos que va a tener mi menu
		
		menuItemIniciarConexionDB = new JMenuItem("Conectar a DB");
		menuItemIniciarConexionDB.setToolTipText("Conectar el programa a la DataBase");
		menuItemIniciarConexionDB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ManejadorEventosDB.getInstancia().conectarADataBase();
			}
		});
		
		
		menuItemFinalizar = new JMenuItem("Cerrar");
		menuItemFinalizar.setToolTipText("Cierra la ventana");
		menuItemFinalizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		menuItemFinalizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				CasaCentralRun.cerrarVentana();
			}});
		
		
		// Cargo todos mis elementos al menu
		add(menuItemIniciarConexionDB);
		add(new JSeparator());
		add(menuItemFinalizar);
	}
}
