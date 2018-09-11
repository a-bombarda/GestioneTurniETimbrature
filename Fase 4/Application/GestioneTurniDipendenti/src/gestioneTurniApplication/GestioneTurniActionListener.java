package gestioneTurniApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestioneTurniGUI.GestioneTurniView;

/*
 * Listener che si occupa di gestire il click sul pulsante "Importa XML" nella GUI
 */
public class GestioneTurniActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {	   
			try {
				GestioneTurniView frameV = new GestioneTurniView();
				frameV.getFrame().setName("GestioneTurni");
				frameV.getFrame().setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}	
		} catch (Exception ex) {
			ex.printStackTrace();
	    }
	}

}
