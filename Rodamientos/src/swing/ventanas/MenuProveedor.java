package swing.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import swing.controladores.ManejadorEventosProveedor;

public class MenuProveedor extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuItem menuItemAgregarProveedor;
	private JMenuItem menuItemModificarProveedor;
	private JMenuItem menuItemBorrarProveedor;
	private JMenuItem menuItemListarProveedores;
	
	public MenuProveedor() {
		super("Proveedores");
		setMenu();
	}
	
	private void setMenu() {
		menuItemAgregarProveedor = new JMenuItem("Agregar Proveedor");
		menuItemAgregarProveedor.setToolTipText("Carga de datos del nuevo Proveedor");
//		menuItemAgregarProvedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));	// Esta linea es para agregar un atajo de teclado
		menuItemAgregarProveedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//	Aca hay que poner el controlador que lo maneja
				new AltaProveedorFrame(ManejadorEventosProveedor.getInstancia());
			}
		});
		
		menuItemModificarProveedor = new JMenuItem("Modificar datos proveedor");
		menuItemModificarProveedor.setToolTipText("Permite la modificacion del dato de los proveedores");
//		menuItemFinalizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));	// Esta linea es para agregar un atajo de teclado
		menuItemModificarProveedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//	Aca hay que poner el controlador que lo maneja
				ManejadorEventosProveedor.getInstancia().modificarProveedor();
			}
		});
		
		menuItemBorrarProveedor = new JMenuItem("Borrar un Proveedor");
		menuItemBorrarProveedor.setToolTipText("Permite dar de baja un proveedor");
//		menuItemFinalizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));	// Esta linea es para agregar un atajo de teclado
		menuItemBorrarProveedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//	Aca hay que poner el controlador que lo maneja
				ManejadorEventosProveedor.getInstancia().bajarProveedor("Conseguir el numero de la ventana bajar");
			}
		});
		
		menuItemListarProveedores = new JMenuItem("Listar Proveedores");
//		menuItemFinalizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));	// Esta linea es para agregar un atajo de teclado
		menuItemBorrarProveedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//	Aca hay que poner el controlador que lo maneja
				ManejadorEventosProveedor.getInstancia().listarProveedores();
			}
		});
		
		add(menuItemAgregarProveedor);
		add(menuItemModificarProveedor);
		add(menuItemBorrarProveedor);
		add(new JSeparator());
		add(menuItemListarProveedores);
	}
}
