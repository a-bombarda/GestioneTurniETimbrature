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
import gestioneTurniData.Attività;
import gestioneTurniData.Fabbisogno_Dipendenti;
import gestioneTurniGUI.PanelFabbisogno;

/*
 * Listener che si occupa di gestire il click sul pulsante "Genera turnazione setimanale" nella GUI
 */
public class VisualizzaFabbisognoActionListener implements ActionListener {

	PanelFabbisogno parentPanel;

	public VisualizzaFabbisognoActionListener(PanelFabbisogno parentPanel) {
		this.parentPanel = parentPanel;
	}

	private String getHourTurno(int idTurno) {
		return DBHandler.getEntityManager()
				.createQuery("SELECT T FROM Turno T WHERE T.IDTurno='" + idTurno + "'", Turno.class).getSingleResult()
				.getDescrizione();
	}

	private String getAttività(int idAttività) {
		return DBHandler.getEntityManager()
				.createQuery("SELECT T FROM Attività T WHERE T.IDAttività='" + idAttività + "'", Attività.class)
				.getSingleResult().getDescrizione();
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

			// Ricerca dei dati del fabbisogno compresi tra le due date richieste
			Vector<Fabbisogno_Dipendenti> ListaFabb = new Vector<Fabbisogno_Dipendenti>();
			ListaFabb = (Vector<Fabbisogno_Dipendenti>) DBHandler.getEntityManager()
					.createQuery("SELECT F FROM Fabbisogno_Dipendenti F", Fabbisogno_Dipendenti.class).getResultList();
			// =======================
			// Visualizzazione del risultato nella tabella
			// =======================
			// Format della data
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel model = new DefaultTableModel();
			// Aggiunta delle colonne
			model.addColumn("Data");
			model.addColumn("Turno");
			model.addColumn("Attività");
			model.addColumn("Numero Dipendenti");
			for (int i = 0; i < ListaFabb.size(); i++) {
				if (ListaFabb.get(i).getData().compareTo(dateMin) >= 0
						&& ListaFabb.get(i).getData().compareTo(DateValidator.addDays(dateMax, 1)) <= 0) {
					model.addRow(new Object[] { formatter.format(ListaFabb.get(i).getData()),
							getHourTurno(ListaFabb.get(i).getIDTurno()), getAttività(ListaFabb.get(i).getIDAttività()),
							ListaFabb.get(i).getN_Dipendenti() });
				}
			}

			// Impostazioni finali
			parentPanel.getTable().setModel(model);

		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null,
					"Errore nella visualizzazione del fabbisogno. Completare correttamente le due date!",
					"Errore operazione", JOptionPane.ERROR_MESSAGE);
		}
	}

}
