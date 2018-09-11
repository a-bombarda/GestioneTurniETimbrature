package gestioneTurniApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
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
public class GeneraTurnazioneActionListener implements ActionListener {

	PanelTurnazione parentPanel;

	public GeneraTurnazioneActionListener(PanelTurnazione parentPanel) {
		this.parentPanel = parentPanel;
	}

	private String getHourTurno(int idTurno) {
		return DBHandler.getEntityManager()
				.createQuery("SELECT T FROM Turno T WHERE T.IDTurno='" + idTurno + "'", Turno.class).getSingleResult()
				.getDescrizione();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Salvataggio delle due date inserite
		String dataMin = parentPanel.getTxtDa().getText();
		String dataMax = parentPanel.getA().getText();

		try {
			// Controllo sulla validità delle date inserite
			DateValidator.isThisDateValid(dataMin, "dd/MM/yyyy");
			DateValidator.isThisDateValid(dataMax, "dd/MM/yyyy");

			// Conversione delle due date in Date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			// Creazione della data usando i dati inseriti. Nel caso in cui il formato sia
			// sbagliato viene lanciata una ParseException
			Date dateMin = sdf.parse(dataMin);
			Date dateMax = sdf.parse(dataMax);
			
			// Controllo sul fatto che tra le due date ci siano meno di 7 giorni
			if (DateValidator.getDifferenceDays(dateMin, dateMax)>=7) {
				throw new Exception("Impossibile schedulare più di una settimana");
			}

			// Generazione dello schedule
			StaffScheduler ss = new StaffScheduler();

			Vector<AssegnazioneTurno> turni = new Vector<AssegnazioneTurno>();
			try {
				turni = ss.makeSchedule(dateMin, DateValidator.addDays(dateMax, 1));
			} catch (ImpossibleSchedulingException ise) {
				turni = ss.getPartialSchedule();
				JOptionPane.showMessageDialog(null,
						"Disponibilità insufficiente per la generazione dello Schedule tra le date richieste!",
						"Errore operazione", JOptionPane.ERROR_MESSAGE);
			}

			// =======================
			// Visualizzazione del risultato nella tabella
			// =======================
			DefaultTableModel model = new DefaultTableModel();
			// Aggiunta delle colonne
			model.addColumn("Badge");
			model.addColumn("Data");
			model.addColumn("Turno");

			// Format della data
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			// Controllo sull'esistenza di un risultato
			if(turni.size()==0) {
				JOptionPane.showMessageDialog(null,
						"Impossibile generare uno schedule per le date richieste!",
						"Errore operazione", JOptionPane.ERROR_MESSAGE);
			}

			// Aggiunta delle informazioni
			for (int i = 0; i < turni.size(); i++)
				model.addRow(new Object[] { turni.get(i).getIDBadge(), formatter.format(turni.get(i).getData()),
						getHourTurno(turni.get(i).getIDTurno()) });
			// Impostazioni finali
			parentPanel.getTable().setModel(model);
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null,
					"Errore nella generazione dello Schedule. Completare correttamente le due date!",
					"Errore operazione", JOptionPane.ERROR_MESSAGE);
		}
	}

}
