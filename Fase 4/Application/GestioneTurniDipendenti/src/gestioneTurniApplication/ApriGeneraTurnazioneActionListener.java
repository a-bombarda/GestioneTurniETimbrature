package gestioneTurniApplication;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import gestioneTurniGUI.PanelTurnazione;

/*
 * Listener che si occupa di gestire il click sul pulsante "Genera turnazione setimanale" nella GUI
 */
public class ApriGeneraTurnazioneActionListener implements ActionListener{
	
	public ApriGeneraTurnazioneActionListener() {	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frameSchedule = new JFrame();
		PanelTurnazione panel = new PanelTurnazione();
		DefaultTableModel model = new DefaultTableModel(); 
		
		// Aggiunta delle colonne alla tabella
		model.addColumn("Badge");
		model.addColumn("Data");
		model.addColumn("Turno");
		
		// Impostazioni finali		
		panel.getTable().setModel(model);
		frameSchedule.setSize(new Dimension(573,390));
		frameSchedule.getContentPane().add(panel);
		frameSchedule.show();
	}

}
