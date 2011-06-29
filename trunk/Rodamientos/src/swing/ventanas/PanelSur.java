package swing.ventanas;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelSur extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int ROWS = 10;
	private final int COLS = 10;
	
	private JTextArea display;
	
	public PanelSur() {
		configurar();
		CasaCentralRun.panelSur = this;
	}
	
	public JTextArea getDisplay() {
		return display;
	}

	private void configurar() {
		display = new JTextArea(ROWS,COLS);
		JScrollPane js = new JScrollPane(display);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(js,BorderLayout.CENTER);
	}
	
}
