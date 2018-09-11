package gestioneTurniApplication;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import gestioneTurniGUI.PanelFabbisogno;

/*
 * Listener che si occupa di gestire il click sul pulsante "Genera turnazione setimanale" nella GUI
 */
public class ApriGestioneFabbisognoActionListener implements ActionListener{
	
	public ApriGestioneFabbisognoActionListener() {	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frameFabb = new JFrame();
		PanelFabbisogno panel = new PanelFabbisogno();
		DefaultTableModel model = new DefaultTableModel(); 
		
		// Aggiunta delle colonne alla tabella
		model.addColumn("Data");
		model.addColumn("Turno");
		model.addColumn("Attività");
		model.addColumn("Numero Dipendenti");
		
		// Impostazioni finali		
		panel.getTable().setModel(model);
		frameFabb.setSize(new Dimension(573,390));
		frameFabb.getContentPane().add(panel);
		frameFabb.show();
	}

}
