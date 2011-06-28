package swing.ventanas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class PanelCentral extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable display;
		
	public PanelCentral() {
		configurar();
		CasaCentralRun.panelCentral = this;
	}
	
	public void setDisplay(Object[][] data, String[] cabecera) {
		TableModel model = new DefaultTableModel(data,cabecera);
		display.setModel(model);
	}

	private void configurar() {
		display = new JTable(new DefaultTableModel());
		display.setEnabled(false);
		JScrollPane js = new JScrollPane(display);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(js,BorderLayout.CENTER);
	}
	
}
