package gestioneTurniData;

import gestioneOrariData.Dipendente;

public interface QueryAttività {
	public String getAttività();
	public int getNumDipPerAttività(String nomeAttività);
	void getOreDipendenti(Dipendente d);
}
