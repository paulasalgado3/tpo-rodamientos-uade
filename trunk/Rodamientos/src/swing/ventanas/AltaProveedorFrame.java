package swing.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import swing.controladores.ManejadorEventosProveedor;


public class AltaProveedorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int anchoVentana = 400;
	private final int altoVentana = 200;
	
	private JLabel lblRazonSocial;
	private JTextField txtRazonSocial;
	private JLabel lblCuit;
	private JTextField txtCuit;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JButton btnAgregar;
	private JButton btnCancelar;
	
	public AltaProveedorFrame(final ManejadorEventosProveedor controlador) {
	
		// SETEO DE CARACTERISTICAS DE LA VENTANA 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setSize(anchoVentana, altoVentana);
		this.setVisible(true);
		this.setTitle("Agregar Proveedor");
		
		
		// SETEO DE ATRIBUTOS - ELEMENTOS DE LA VENTANA
		
		this.lblRazonSocial = new JLabel("Razón Social");
		this.lblCuit = new JLabel("Cuit");
		this.lblTelefono = new JLabel("Teléfono");
		
		this.txtCuit = new JTextField(20);
		this.txtRazonSocial = new JTextField(50);
		this.txtTelefono = new JTextField(20);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnCancelar = new JButton("Cancelar");
		
		
		//	MANEJO DE LOS EVENTOS
		
		this.btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String razonSocial = txtRazonSocial.getText();
				String cuit = txtCuit.getText();
				String telefono = txtTelefono.getText();
				controlador.agregarProveedor(razonSocial, cuit, telefono);
				CasaCentralRun.panelSur.getDisplay().setText("Carga del Proveedor:\n"+
						"\tRazon Social: "+razonSocial+"\n"+
						"\tCUIT: "+cuit+"\n"+
						"\tTelefono: "+telefono);
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
		this.add(lblRazonSocial);
		this.add(txtRazonSocial);
		this.add(lblCuit);
		this.add(txtCuit);
		this.add(lblTelefono);
		this.add(txtTelefono);
		this.add(btnAgregar);
		this.add(btnCancelar);		
	}
}
