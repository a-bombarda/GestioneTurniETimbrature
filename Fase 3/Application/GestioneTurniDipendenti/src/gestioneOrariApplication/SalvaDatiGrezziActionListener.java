package gestioneOrariApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import gestioneOrariData.Dipendente;
import gestioneOrariData.Timbratura;

/*
 * Listener che si occupa di gestire il click sul pulsante "Salva" nella maschera di visualizzazione 
 * degli orari grezzi importati dall'XML
 */
public class SalvaDatiGrezziActionListener implements ActionListener{

	JFrame parentFrame;
	TableModel tabella;
	
	public SalvaDatiGrezziActionListener(JFrame parentFrame, TableModel tabella) {
		this.parentFrame=parentFrame;
		this.tabella=tabella;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Timbratura tempTimb;
		RecordAggregator ra=new RecordAggregator();
		try {	   
			// Creazione degli oggetti di classe Timbratura e implementazione della persistenza
			// delle modifiche
			for(int i=0;i<tabella.getRowCount();i++) {
				// Check sulla compilazione di tutti i campi
				if (tabella.getValueAt(i, 0).toString().equals("") || tabella.getValueAt(i, 1).toString().equals("") ||
						tabella.getValueAt(i, 2).toString().equals("") || tabella.getValueAt(i, 3).toString().equals(""))
					continue;
				
				tempTimb = new Timbratura();
				// Impostazione data, con controllo preventivo sul formato
				DateValidator.isThisDateValid(tabella.getValueAt(i, 2).toString(), "dd/MM/yyyy");
				tempTimb.setData(new Date(Integer.parseInt(tabella.getValueAt(i, 2).toString().substring(6, 10))-1900,
						Integer.parseInt(tabella.getValueAt(i, 2).toString().substring(3, 5))-1,
						Integer.parseInt(tabella.getValueAt(i, 2).toString().substring(0, 2))+1));
				
				// Impostazione ora, con controllo preventivo sul formato
				TimeValidator.validate(tabella.getValueAt(i, 3).toString());
				tempTimb.setOra(new Time(Integer.parseInt(tabella.getValueAt(i, 3).toString().substring(0, 2))+1,
										  Integer.parseInt(tabella.getValueAt(i, 3).toString().substring(3,5)),
										  Integer.parseInt(tabella.getValueAt(i, 3).toString().substring(6,8))));
				
				// Impostazione tipo di timbratura
				tempTimb.setTipo(tabella.getValueAt(i,1).toString());
				
				// Impostazione del dipendente
				TypedQuery<Dipendente> query = DBHandler.getEntityManager().createQuery("SELECT d FROM Dipendente d WHERE d.IDBadge='" + 
						tabella.getValueAt(i,0).toString() + "'",Dipendente.class);
				if (query.getResultList().isEmpty() || query.getResultList().size()>1) throw new Exception("Nessun dipendente trovato corrispondente"
						+ "al badge inserito");
				tempTimb.setDipendente(query.getResultList().get(0));
				
				// Salvataggio delle modifiche nel database, per la persistenza
				DBHandler.getEntityManager().getTransaction().begin();
				DBHandler.getEntityManager().persist(tempTimb);
				DBHandler.getEntityManager().getTransaction().commit();
			}
			// Aggregazione degli orari 
			ra.aggregate();
			// Chiusura della maschera
			parentFrame.setVisible(false);
			parentFrame.dispose();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, 
                    "Errore nell'importazione dei dati nel database! Controllare il formato di date ed orari", 
                    "Errore operazione", JOptionPane.ERROR_MESSAGE);
	    }
	}

}
