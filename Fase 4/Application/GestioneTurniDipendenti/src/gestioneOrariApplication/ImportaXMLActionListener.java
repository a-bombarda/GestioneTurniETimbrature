package gestioneOrariApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gestioneOrariGUI.gestioneOrariView;
import gestioneOrariData.Timbratura;

/*
 * Listener che si occupa di gestire il click sul pulsante "Importa XML" nella GUI
 */
public class ImportaXMLActionListener implements ActionListener{

	JFrame parentFrame;
	
	public ImportaXMLActionListener(JFrame parentFrame) {
		this.parentFrame=parentFrame;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		try {	   
			// Visualizzazione della finestra di selezione del file
			JFileChooser fc = new JFileChooser();
			int n = fc.showOpenDialog(parentFrame);
			RecordParser rp = new RecordParser();
			String[][] matrixTimbrature;
			// Se è stato selezionato qualcosa
	        if (n == JFileChooser.APPROVE_OPTION) {
	        		// Parsing del file XML e creazione della matrice di Stringhe che deve essere mostrata nella 
	        		// JTable della GUI 
	        		List<Timbratura> lista = rp.parserXML(fc.getSelectedFile().getAbsolutePath());
	        		matrixTimbrature = new String[lista.size()][4];
	        		for (int i=0;i<lista.size();i++) {
	        			matrixTimbrature[i][0]=lista.get(i).getDipendente().getIDBadge();
	        			matrixTimbrature[i][1]=lista.get(i).getTipo();
	        			matrixTimbrature[i][2]=String.format("%02d", lista.get(i).getData().getDate()) + "/" + 
	        					String.format("%02d", lista.get(i).getData().getMonth()+1) + "/" + 
	        					(lista.get(i).getData().getYear()+1900);
	        			matrixTimbrature[i][3]=lista.get(i).getOra().toString();	        			
	        		}
	        		// Visualizzazione della finestra di modifica degli orari
	        		((gestioneOrariView)parentFrame).openRecordMng(matrixTimbrature);
	        }
	        else {
	        		JOptionPane.showMessageDialog(null, 
	                    "Nessun file selezionato!", 
	                    "Errore operazione", JOptionPane.ERROR_MESSAGE);
	        }
		} catch (Exception ex) {
			ex.printStackTrace();
	    }
	}

}
