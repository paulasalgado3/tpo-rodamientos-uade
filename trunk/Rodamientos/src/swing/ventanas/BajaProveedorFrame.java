package swing.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import swing.controladores.ManejadorEventosProveedor;

public class BajaProveedorFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int anchoVentana = 400;
	private final int altoVentana = 200;
	
	private JLabel lblCUIT;
	private JTextField txtCUIT;
	private JButton btnBorrar;
	private JButton btnCancelar;
	
	public BajaProveedorFrame(final ManejadorEventosProveedor controlador) {
	
		// SETEO DE CARACTERISTICAS DE LA VENTANA 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setSize(anchoVentana, altoVentana);
		this.setVisible(true);
		this.setTitle("Borrar Proveedor");
		
		
		// SETEO DE ATRIBUTOS - ELEMENTOS DE LA VENTANA
		
		this.lblCUIT = new JLabel("Cuit");
		
		this.txtCUIT = new JTextField(20);
		
		this.btnBorrar = new JButton("Borrar");
		this.btnCancelar = new JButton("Cancelar");
		
		
		//	MANEJO DE LOS EVENTOS
		
		this.btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cuit = txtCUIT.getText();
				boolean resultadoOperacion = controlador.bajarProveedor(cuit);
				if (resultadoOperacion == true)
					CasaCentralRun.panelSur.getDisplay().setText("El CUIT del proveedor borrado es: "+cuit);
				else
					JOptionPane.showMessageDialog(null, "No existe el Proveedor: "+cuit);
				dispose();
			}
		});
		
		this.btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		//	AGREGADO DE ELEMENTOS AL FRAME
		
		this.setLayout(new GridLayout(4,2));
		this.add(lblCUIT);
		this.add(txtCUIT);
		this.add(btnBorrar);
		this.add(btnCancelar);		
	}
}
