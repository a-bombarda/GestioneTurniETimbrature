package gestioneTurniApplication;

public class StaffScheduler implements Scheduler<AssegnazioneTurno> {

	// Lista dei dipendenti utilizzati in giornata
	private ArrayList<String> listaBadgeUtilizzati = new ArrayList<String>();
	// Data corrente
	private Date dataCorrente = new Date();
	// Vettore risultato, da utilizzare quando si ha un fail nello schedule 
	Vector<AssegnazioneTurno> listaResultErr = new Vector<AssegnazioneTurno>();

	/*
	 * Funzione per la generazione del predicato di filtro dei dipendenti
	 * ammissibili
	 */
	private Predicate<Dipendente> getPossiblePredicate(Fabbisogno_Dipendenti d) {
		...
	}

	/*
	 * Funzione per la generazione del predicato di filtro dei dipendenti gia'
	 * assegnati
	 */
	private Predicate<Dipendente> getAssignedPredicate() {
		...
	}

	/*
	 * Funzione per la generazione dello schedule
	 */
	@Override
	public Vector<AssegnazioneTurno> makeSchedule(Date dataMin, Date dataMax) throws ImpossibleSchedulingException {
		...
	}

	/*
	 * Funzione che permette comunque di risalire allo schedule parziale, qualora ci sia stato un errore
	 */
	public Vector<AssegnazioneTurno> getPartialSchedule() {
		..
	}
}
