package gestioneOrariApplication;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import gestioneOrariData.Dipendente;
import gestioneOrariData.Orario;
import gestioneOrariData.Timbratura;

public class RecordAggregator implements Aggregator{

	/* Funzione per tutto il processo di aggregazione degli orari, a partire dalle timbrature fino ad arrivare
	 * agli orari aggregati per giorno, con già un precalcolo delle componenti di ordinario, straordinario e ferie
	 */
	@Override
	public void aggregate() {
		try {
			// Selezione della minima e della massima data
			TypedQuery<Date> queryMax = DBHandler.getEntityManager().createQuery("SELECT MAX(T.data) FROM Timbratura T",Date.class);
			TypedQuery<Date> queryMin = DBHandler.getEntityManager().createQuery("SELECT MIN(T.data) FROM Timbratura T",Date.class);
			// Creazione delle righe vuote
			creaRigheVuoteOrari(queryMax.getSingleResult(),queryMin.getSingleResult());
			// Posizionamento (aggregazione) delle timbrature nella riga corretta 
			posizionaOrari(queryMax.getSingleResult(),queryMin.getSingleResult());
			// Elaborazione degli orari per il calcolo di ordinari, straordinari, ferie e permessi
			elaboraOrari(queryMax.getSingleResult(),queryMin.getSingleResult());
			// Eliminazione di tutti i dati nella tabella delle Timbrature
			eliminaDatiTimbrature();		
			// Messaggio di conferma
			JOptionPane.showMessageDialog(null, 
                    "Operazione di importazione ed aggregazione delle timbrature completata correttamente", 
                    "Conferma operazione", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Funzione che permette di creare le righe vuote per tutti i giorni compresi tra la minima data di
	 * importazione e l'ultima data di importazione
	 */
	public void creaRigheVuoteOrari(Date dataMin, Date dataMax) {
		// Selezione di tutti i dipendenti
		TypedQuery<Dipendente> queryDip = DBHandler.getEntityManager().createQuery("SELECT D FROM Dipendente D",Dipendente.class);
		// Per ogni dipendente e per ogni data, tra quella minima e quella massima, creazione di una riga vuota
		// nella tabella degli orari
		for(Object d:queryDip.getResultList().toArray()) {
			Date dateCur = new Date();
			dateCur=dataMin;
			while(dateCur.compareTo(dataMax)<=0) {
				Orario o = new Orario();
				o.setDipendente((Dipendente)d);
				o.setData(DateValidator.addDays(dateCur,1));
				DBHandler.getEntityManager().getTransaction().begin();
				DBHandler.getEntityManager().persist(o);
				DBHandler.getEntityManager().getTransaction().commit();
				dateCur = DateValidator.addDays(dateCur,1);
			}
		}
	}

	/*
	 * Funzione che si occupa di prendere tutte le timbrature e comporre la riga nella tabella degli orari,
	 * raggruppando tutte le timbrature del giorno
	 */
	@SuppressWarnings("deprecation")
	public void posizionaOrari(Date dataMin, Date dataMax) throws Exception {
		// Selezione di tutti i dipendenti
		TypedQuery<Dipendente> queryDip = DBHandler.getEntityManager().createQuery("SELECT D FROM Dipendente D",Dipendente.class);
		// Per ogni dipendente e per ogni data, tra quella minima e quella massima, si compongono gli orari
		for(Object d:queryDip.getResultList().toArray()) {
			Date dateCur = new Date();
			dateCur=dataMin;
			while(dateCur.compareTo(dataMax)<=0) {
				DBHandler.getEntityManager().getTransaction().begin();
				// Selezione dell'orario relativo al dipendente selezionarto
				TypedQuery<Orario> queryOrario = DBHandler.getEntityManager().createQuery("SELECT O FROM Orario O JOIN O.dipendente D WHERE D.IDBadge='" + 
						((Dipendente)d).getIDBadge() + "'",Orario.class);
				// Selezione dell'orario del dipendente selezionato e per la data considerata
				Orario tbMod = null;
				for(Object o: queryOrario.getResultList().toArray()) {
					Date dataOrario = DateValidator.addDays(((Orario)o).getData(),-1);
					dataOrario.setHours(0);
					dataOrario.setMinutes(0);
					dataOrario.setSeconds(0);
					dateCur.setHours(0);
					dateCur.setMinutes(0);
					dateCur.setSeconds(0);
					if(dataOrario.equals(dateCur)) {
						tbMod = (Orario)o;
						break;
					}
				}
				if (tbMod==null) throw new Exception("Errore nell'inserimento dei dati");
				// Selezione delle timbrature del dipendente selezionato
				TypedQuery<Timbratura> queryTimbratura = DBHandler.getEntityManager().createQuery("SELECT T FROM Timbratura T JOIN T.dipendente D WHERE " +
						"D.IDBadge='" + 	((Dipendente)d).getIDBadge() + "' ORDER BY T.IDTimbratura ASC",Timbratura.class);
				// Selezione delle sole timbrature della data selezionata
				ArrayList<Timbratura> orari = new ArrayList<Timbratura>();
				for(Object o: queryTimbratura.getResultList().toArray()) {
					Date DataTimbratura = DateValidator.addDays(((Timbratura)o).getData(),-1);
					DataTimbratura.setHours(0);
					DataTimbratura.setMinutes(0);
					DataTimbratura.setSeconds(0);
					dateCur.setHours(0);
					dateCur.setMinutes(0);
					dateCur.setSeconds(0);
					if(DataTimbratura.equals(dateCur)) {
						orari.add((Timbratura)o);
					}
				}				
				// Impostazione degli orari
				if(orari.size()>=1 && orari.get(0).getOra()!=null)
					tbMod.setIngresso1(orari.get(0).getOra());
				if(orari.size()>=2 && orari.get(1).getOra()!=null)
					tbMod.setUscita1(orari.get(1).getOra());
				if(orari.size()>=3 && orari.get(2).getOra()!=null)
					tbMod.setIngresso2(orari.get(2).getOra());
				if(orari.size()>=4 && orari.get(3).getOra()!=null)
					tbMod.setUscita2(orari.get(3).getOra());
				// Salvataggio dei dati
				DBHandler.getEntityManager().getTransaction().commit();				
				// Passaggio al giorno successivo
				dateCur = DateValidator.addDays(dateCur,1);
			}
		}		
	}
	
	/*
	 * Funzione per l'arrotondamento al 0,5 più vicino
	 */
	public static double roundToHalf(double d) {
	    return Math.round(d * 2) / 2.0;
	}

	/*
	 * Funzione per l'elaborazione degli orari e calcolo di ordinari, straordinari, ferie e permessi
	 */
	@SuppressWarnings("deprecation")
	public void elaboraOrari(Date dataMin, Date dataMax) {
		TypedQuery<Orario> queryOrario = DBHandler.getEntityManager().createQuery("SELECT O FROM Orario O",Orario.class);
		for(Object orari:queryOrario.getResultList().toArray()) {
			DBHandler.getEntityManager().getTransaction().begin();
			// Scorrimento di tutti gli orari inseriti e selezione delle sole righe con la data compresa
			// tra quella minima e quella massima
			Date DataOrario = DateValidator.addDays(((Orario)orari).getData(),-1);
			if(DataOrario.compareTo(dataMax)<=0 && DataOrario.compareTo(dataMin)>=0) {
				// Impostazione delle ore di ordinario
				double oreOrd = 0;
				if (((Orario)orari).getIngresso1()!=null && ((Orario)orari).getUscita1()!=null) 
					// Controllo se sono a cavallo della mezzanotte
					if ((((Orario)orari).getUscita1().getHours()-1 < 0 ? 23 : ((Orario)orari).getUscita1().getHours()-1)<(((Orario)orari).getIngresso1().getHours()-1 < 0 ? 23 : ((Orario)orari).getIngresso1().getHours()-1)) 
						oreOrd += (new Time(23,59,59).getTime() - ((Orario)orari).getIngresso1().getTime()) + (((Orario)orari).getUscita1().getTime()-new Time(0,0,0).getTime());
					else
						oreOrd += ((Orario)orari).getUscita1().getTime()-((Orario)orari).getIngresso1().getTime();
				if (((Orario)orari).getIngresso2()!=null && ((Orario)orari).getUscita2()!=null) 
					oreOrd += ((Orario)orari).getUscita2().getTime()-((Orario)orari).getIngresso2().getTime();
				oreOrd /= 3600000;				// Espresso in ore
				((Orario)orari).setOre_Ordinario(roundToHalf(oreOrd) > 8 ? 8 : roundToHalf(oreOrd));
				// Impostazione delle ore di straordinario
				((Orario)orari).setOre_Straordinario(roundToHalf(oreOrd)<=8 ? 0 : roundToHalf(oreOrd) - 8);
				// Impostazione delle ore di malattia
				((Orario)orari).setOre_Malattia(0);
				// Impostazione delle ore di ferie/Permessi
				((Orario)orari).setOre_FeriePermessi(8-((Orario)orari).getOre_Ordinario());
			}
			DBHandler.getEntityManager().getTransaction().commit();
		}
	}
	
	/*
	 * Funzione che svuota la tabella temporanea delle timbrature, dopo aver elaborato tutti i dati
	 */
	public void eliminaDatiTimbrature() {
		try {
			DBHandler.getEntityManager().getTransaction().begin();
			DBHandler.getEntityManager().createQuery("DELETE FROM Timbratura").executeUpdate();
			DBHandler.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
