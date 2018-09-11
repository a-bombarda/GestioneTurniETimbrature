package gestioneTurniApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
import gestioneOrariApplication.DBHandler;
import gestioneOrariData.Dipendente;
import gestioneTurniData.AssegnazioneTurno;
import gestioneTurniData.Attività;
import gestioneTurniData.Fabbisogno_Dipendenti;

public class StaffScheduler implements Scheduler<AssegnazioneTurno> {

	// Lista dei dipendenti utilizzati in giornata
	private ArrayList<String> listaBadgeUtilizzati = new ArrayList<String>();
	// Data corrente
	private Date dataCorrente = new Date();
	// Vettore risultato, da utilizzare quando si ha un fail nello schedule;
	Vector<AssegnazioneTurno> listaResultErr = new Vector<AssegnazioneTurno>();

	/*
	 * Funzione per la generazione del predicato di filtro dei dipendenti
	 * ammissibili
	 */
	private Predicate<Dipendente> getPossiblePredicate(Fabbisogno_Dipendenti d) {
		Predicate<Dipendente> byPossible = (dipendente -> (dipendente.getFree() >= 8 && dipendente.getAttivitàs()
				.stream().map(Attività::getIDAttività).collect(Collectors.toList()).contains(d.getIDAttività())
				&& !listaBadgeUtilizzati.contains(dipendente.getIDBadge())));
		return byPossible;
	}

	/*
	 * Funzione per la generazione del predicato di filtro dei dipendenti già
	 * assegnati
	 */
	private Predicate<Dipendente> getAssignedPredicate() {
		Predicate<Dipendente> byAssigned = (dipendente -> (dipendente.isOccupato()));
		return byAssigned;
	}

	/*
	 * Funzione per la generazione dello schedule
	 */
	@Override
	public Vector<AssegnazioneTurno> makeSchedule(Date dataMin, Date dataMax) throws ImpossibleSchedulingException {
		int NumeroDipendentiDaAssegnare = 0;
		// Lista da ritornare
		Vector<AssegnazioneTurno> listaResult = new Vector<AssegnazioneTurno>();
		// Lista di tutti i dipendenti
		TypedQuery<Dipendente> query = DBHandler.getEntityManager().createQuery("SELECT D FROM Dipendente D",
				Dipendente.class);
		Vector<Dipendente> listaDipendenti = (Vector<Dipendente>) query.getResultList();

		// Inizializzazione dei dipendenti
		listaDipendenti.forEach((d) -> d.initDipendente());
		// Impostazione della prima data utilizzata
		dataCorrente = dataMin;

		// Scorrimento di tutte le righe della tabella dei fabbisogni dei dipendenti
		for (Object d : DBHandler.getEntityManager()
				.createQuery("SELECT f FROM Fabbisogno_Dipendenti f ORDER BY f.data ASC, f.IDTurno, f.IDAttività",
						Fabbisogno_Dipendenti.class)
				.getResultList().toArray()) {
			// Check sulla data, per vedere se è una di quelle da programmare
			Date DataOrario = ((Fabbisogno_Dipendenti) d).getData();
			if (DataOrario.compareTo(dataMax) <= 0 && DataOrario.compareTo(dataMin) >= 0) {
				NumeroDipendentiDaAssegnare = ((Fabbisogno_Dipendenti) d).getN_Dipendenti();

				// Controllo sull'eventuale cambio di data
				if (dataCorrente.compareTo(DataOrario) != 0) {
					dataCorrente = DataOrario;
					listaBadgeUtilizzati.clear();
				}

				// Ciclo su tutti i dipendenti da assegnare
				while (NumeroDipendentiDaAssegnare > 0) {

					ArrayList<Dipendente> listaDipendentiCandidati = (ArrayList<Dipendente>) listaDipendenti.stream()
							.collect(Collectors.toList());
					// Predicato per la ricerca dei dipendenti possibili: devono avere:
					// - Almeno 8 ore libere
					// - Almeno la stessa attività che si sta programmando
					// - Non assegnato a nessun turno del giorno
					Predicate<Dipendente> byPossible = getPossiblePredicate((Fabbisogno_Dipendenti) d);

					// Filtraggio della lista dei dipendenti, per ottenere solamente quelli
					// possibili
					listaDipendentiCandidati = (ArrayList<Dipendente>) listaDipendentiCandidati.stream()
							.filter(byPossible).collect(Collectors.<Dipendente>toList());
					// Ordinamento della lista dei dipendenti ammissibili, mettendo per primi quelli
					// che hanno il minor numero di attività
					Collections.sort(listaDipendentiCandidati, new Comparator<Dipendente>() {
						public int compare(Dipendente obj1, Dipendente obj2) {
							return obj1.getAttivitàs().size() < obj2.getAttivitàs().size() ? -1
									: (obj1.getAttivitàs().size() == obj2.getAttivitàs().size() ? 0 : 1);
						}
					});

					// Filtraggio della lista dei dipendenti, per ottenere solamente quelli
					// già assegnati
					Predicate<Dipendente> byAssigned = getAssignedPredicate();
					ArrayList<Dipendente> listaDipendentiAssegnati = (ArrayList<Dipendente>) listaDipendenti.stream()
							.filter(byAssigned).collect(Collectors.<Dipendente>toList());

					// Controllo sulla fattibilità dello scheduling
					ListIntersect<Dipendente> intersector = new ListIntersect<Dipendente>();
					ArrayList<Dipendente> intersezione = intersector.intersect(listaDipendentiCandidati,
							listaDipendentiAssegnati);
					Collections.sort(intersezione, new Comparator<Dipendente>() {
						public int compare(Dipendente obj1, Dipendente obj2) {
							return obj1.getAttivitàs().size() < obj2.getAttivitàs().size() ? -1
									: (obj1.getAttivitàs().size() == obj2.getAttivitàs().size() ? 0 : 1);
						}
					});
					if (intersezione.size() > 0) {
						listaResult.add(new AssegnazioneTurno(((Fabbisogno_Dipendenti) d).getData(),
								intersezione.get(0).getIDBadge(), ((Fabbisogno_Dipendenti) d).getIDTurno()));
						listaDipendenti.get(listaDipendenti.indexOf(intersezione.get(0))).addFree(-8);
						listaBadgeUtilizzati.add(intersezione.get(0).getIDBadge());
					} else {
						if (listaDipendentiCandidati.size() > 0) {
							// Scelta del primo dipendente candidato
							listaResult.add(new AssegnazioneTurno(((Fabbisogno_Dipendenti) d).getData(),
									listaDipendentiCandidati.get(0).getIDBadge(),
									((Fabbisogno_Dipendenti) d).getIDTurno()));
							listaDipendenti.get(listaDipendenti.indexOf(listaDipendentiCandidati.get(0)))
									.setOccupato(true);
							listaDipendenti.get(listaDipendenti.indexOf(listaDipendentiCandidati.get(0))).addFree(-8);
							listaBadgeUtilizzati.add(listaDipendentiCandidati.get(0).getIDBadge());
						} else {
							// Schedule non possibile
							listaResultErr = listaResult;
							throw new ImpossibleSchedulingException(
									"Impossibile produrre uno schedule per il periodo selezionato");
						}
					}

					NumeroDipendentiDaAssegnare--;
				}
			}
		}
		return listaResult;
	}

	/*
	 * Funzione che permette comunque di risalire allo schedule parziale, qualora ci
	 * sia stato un errore
	 */
	public Vector<AssegnazioneTurno> getPartialSchedule() {
		return listaResultErr;
	}
}
