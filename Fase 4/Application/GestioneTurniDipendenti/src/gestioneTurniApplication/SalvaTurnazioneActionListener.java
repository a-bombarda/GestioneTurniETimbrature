package gestioneTurniApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import gestioneOrariApplication.DBHandler;
import gestioneOrariApplication.DateValidator;
import gestioneOrariData.Turno;
import gestioneTurniData.AssegnazioneTurno;
import gestioneTurniGUI.PanelTurnazione;

/*
 * Listener che si occupa di gestire il click sul pulsante "Genera turnazione setimanale" nella GUI
 */
public class SalvaTurnazioneActionListener implements ActionListener {

	PanelTurnazione parentPanel;

	public SalvaTurnazioneActionListener(PanelTurnazione parentPanel) {
		this.parentPanel = parentPanel;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < parentPanel.getTable().getRowCount(); i++) {
			// Creazione di un nuovo oggetto
			AssegnazioneTurno a = new AssegnazioneTurno();
			a.setIDBadge(parentPanel.getTable().getValueAt(i, 0).toString());
			a.setIDTurno(DBHandler.getEntityManager()
					.createQuery("SELECT T FROM Turno T WHERE T.descrizione='"
							+ parentPanel.getTable().getValueAt(i, 2).toString() + "'", Turno.class)
					.getSingleResult().getIDTurno());
			a.setData(new Date(
					Integer.parseInt(parentPanel.getTable().getValueAt(i, 1).toString().substring(6, 10)) - 1900,
					Integer.parseInt(parentPanel.getTable().getValueAt(i, 1).toString().substring(3, 5)) - 1,
					Integer.parseInt(parentPanel.getTable().getValueAt(i, 1).toString().substring(0, 2))));

			// Salvataggio dell'oggetto nel database
			DBHandler.getEntityManager().getTransaction().begin();
			a.setData(DateValidator.addDays(a.getData(), 1));
			DBHandler.getEntityManager().persist(a);
			DBHandler.getEntityManager().getTransaction().commit();

		}
		JOptionPane.showMessageDialog(null, "Dati inseriti correttamente nel database!", "Operazione completata",
				JOptionPane.INFORMATION_MESSAGE);
		parentPanel.getA().setText("");
		parentPanel.getTxtDa().setText("");
		parentPanel.getTable().setModel(new DefaultTableModel());
	}

}
