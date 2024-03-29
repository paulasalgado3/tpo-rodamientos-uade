package swing.ventanas;

import javax.swing.*;
import java.awt.*;

public class CasaCentralRun {
	
	static JFrame frame;
	static PanelCentral panelCentral;
	static PanelSur panelSur;
	
	public void run() {
		frame = new JFrame("Casa Central RODACOR");
		components();
		show();
	}
	
	private static void show() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
	    
	private static void components() {
		Container c = frame.getContentPane();
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// Aca voy agregando los distintos menus
		menuBar.add(new MenuArchivo());
		menuBar.add(new MenuProveedor());
		
		// Aca voy agregando los componentes
		c.add(new PanelCentral(), BorderLayout.CENTER);
		c.add(new PanelSur(), BorderLayout.SOUTH);
	} 
	
	public static void cerrarVentana() {
		frame.dispose();
		System.exit(0);
	}

}
