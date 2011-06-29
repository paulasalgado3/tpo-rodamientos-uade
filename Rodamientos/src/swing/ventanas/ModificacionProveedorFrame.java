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

public class ModificacionProveedorFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int anchoVentana = 400;
	private final int altoVentana = 200;
	
	private JLabel lblViejoCuit;
	private JTextField txtViejoCuit;
		
	private JLabel lblNuevoCuit;
	private JTextField txtNuevoCuit;
	
	private JLabel lblNuevaRazonSocial;
	private JTextField txtNuevaRazonSocial;
	
	private JLabel lblNuevoTelefono;
	private JTextField txtNuevoTelefono;
	
	private JButton btnAgregar;
	private JButton btnCancelar;
	
	public ModificacionProveedorFrame(final ManejadorEventosProveedor controlador) {
	
		// SETEO DE CARACTERISTICAS DE LA VENTANA 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setSize(anchoVentana, altoVentana);
		this.setVisible(true);
		this.setTitle("Modificar Datos Proveedor");
		
		
		// SETEO DE ATRIBUTOS - ELEMENTOS DE LA VENTANA
		
		this.lblViejoCuit = new JLabel("CUIT Viejo");
		this.txtViejoCuit = new JTextField(20);
		
		this.lblNuevoCuit = new JLabel("CUIT Nuevo");
		this.txtNuevoCuit = new JTextField(20);
		
		this.lblNuevaRazonSocial = new JLabel("Nueva Razón Social");
		this.txtNuevaRazonSocial = new JTextField(50);
		
		this.lblNuevoTelefono = new JLabel("Teléfono Nuevo");
		this.txtNuevoTelefono = new JTextField(20);
		
		
		this.btnAgregar = new JButton("Modificar Datos");
		this.btnCancelar = new JButton("Cancelar");
		
		
		//	MANEJO DE LOS EVENTOS
		
		this.btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String viejoCuit = txtViejoCuit.getText();
				String nuevoCuit = txtNuevoCuit.getText();
				String razonSocial = txtNuevaRazonSocial.getText();
				String telefono = txtNuevoTelefono.getText();
				
				boolean ResultadoOperacion = controlador.modificarProveedor(viejoCuit, nuevoCuit, razonSocial, telefono);
				
				if (ResultadoOperacion == true){
					CasaCentralRun.panelSur.getDisplay().setText("Nuevos datos del proveedor:\n"+
							"\tRazon Social: "+razonSocial+"\n"+
							"\tCUIT: "+nuevoCuit+"\n"+
							"\tTelefono: "+telefono);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "No existe el Proveedor: "+viejoCuit);
				}
			}
		});
		
		this.btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		//	AGREGADO DE ELEMENTOS AL FRAME
		this.setLayout(new GridLayout(5,2));
		
		this.add(lblViejoCuit);
		this.add(txtViejoCuit);
		
		this.add(lblNuevoCuit);
		this.add(txtNuevoCuit);
		
		this.add(lblNuevaRazonSocial);
		this.add(txtNuevaRazonSocial);
		
		this.add(lblNuevoTelefono);
		this.add(txtNuevoTelefono);
		
		this.add(btnAgregar);
		this.add(btnCancelar);		
	}
}
