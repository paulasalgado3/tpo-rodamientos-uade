package swing.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import swing.controladores.ControladorAltaProveedor;

@SuppressWarnings("serial")
public class AltaProveedorFrame extends JFrame {

	private JLabel lblRazonSocial;
	private JTextField txtRazonSocial;
	private JLabel lblCuit;
	private JTextField txtCuit;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JButton btnAgregar;
	private JButton btnCancelar;
	
	public AltaProveedorFrame(final ControladorAltaProveedor cap) {
	
		cap.setVentana(this);
		
		this.lblRazonSocial = new JLabel("Razón Social");
		this.lblCuit = new JLabel("Cuit");
		this.lblTelefono = new JLabel("Teléfono");
		
		this.txtCuit = new JTextField(20);
		this.txtRazonSocial = new JTextField(50);
		this.txtTelefono = new JTextField(20);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnCancelar = new JButton("Cancelar");
		
		this.btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String razonSocial = txtRazonSocial.getText();
				String cuit = txtCuit.getText();
				String telefono = txtTelefono.getText();
				cap.agregarProveedor(razonSocial, cuit, telefono);
			}
		});
		this.btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cap.cancelar();
			}
		});
		
		this.setLayout(new GridLayout(4,2));
		this.add(lblRazonSocial);
		this.add(txtRazonSocial);
		this.add(lblCuit);
		this.add(txtCuit);
		this.add(lblTelefono);
		this.add(txtTelefono);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
}
