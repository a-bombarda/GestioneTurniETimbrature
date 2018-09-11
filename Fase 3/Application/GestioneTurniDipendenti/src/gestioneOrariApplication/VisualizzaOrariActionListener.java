package gestioneOrariApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JFrame;
import gestioneOrariData.Orario;
import gestioneOrariGUI.gestioneOrariView;

/*
 * Listener che si occupa di gestire il click sul pulsante "Importa XML" nella GUI
 */
public class VisualizzaOrariActionListener implements ActionListener {

	JFrame parentFrame;

	public VisualizzaOrariActionListener(JFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		String[][] matrixTimbrature;
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		try {
			// Selezione delle timbrature attualmente inserite in database
			@SuppressWarnings("unchecked")
			Vector<Orario> listaOrari = ((Vector<Orario>) DBHandler.getEntityManager()
					.createQuery("SELECT O FROM Orario O ORDER BY O.data ASC").getResultList());
			// Controllo dell'esistenza di almeno un risultato
			if (listaOrari.size() == 0)
				throw new Exception("Nessun orario inserito");
			// Composizione della matrice di stringhe
			matrixTimbrature = new String[listaOrari.size()][6];
			for (int i = 0; i < listaOrari.size(); i++) {
				matrixTimbrature[i][0] = listaOrari.get(i).getDipendente().getIDBadge();
				matrixTimbrature[i][1] = String.format("%02d", listaOrari.get(i).getData().getDate()) + "/"
						+ String.format("%02d", listaOrari.get(i).getData().getMonth() + 1) + "/"
						+ (listaOrari.get(i).getData().getYear() + 1900);
				matrixTimbrature[i][2] = (listaOrari.get(i).getIngresso1() == null ? ""
						: localDateFormat.format(TimeValidator.HoursSet(listaOrari.get(i).getIngresso1())));
				matrixTimbrature[i][3] = (listaOrari.get(i).getUscita1() == null ? ""
						: localDateFormat.format(TimeValidator.HoursSet(listaOrari.get(i).getUscita1())));
				matrixTimbrature[i][4] = (listaOrari.get(i).getIngresso2() == null ? ""
						: localDateFormat.format(TimeValidator.HoursSet(listaOrari.get(i).getIngresso2())));
				matrixTimbrature[i][5] = (listaOrari.get(i).getUscita2() == null ? ""
						: localDateFormat.format(TimeValidator.HoursSet(listaOrari.get(i).getUscita2())));
			}
			// Visualizzazione della finestra di visualizzazione degli orari
			((gestioneOrariView) parentFrame).openRecordView(matrixTimbrature);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

}
