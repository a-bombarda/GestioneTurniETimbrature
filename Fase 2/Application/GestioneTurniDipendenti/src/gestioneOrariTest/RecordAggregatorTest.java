package gestioneOrariTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.Date;

import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;

import gestioneOrariApplication.DBHandler;
import gestioneOrariApplication.RecordAggregator;
import gestioneOrariData.Dipendente;
import gestioneOrariData.Timbratura;

class RecordAggregatorTest {

	@Test
	void testTimbratureNonPresenti() {
		// Cancellazione delle timbrature eventualmente presenti
		RecordAggregator ra = new RecordAggregator();
		ra.eliminaDatiTimbrature();
		// Chiamata del metodo di aggregazione
		ra.aggregate();
	}
	
	@Test
	void testMetodiConParametriNull() {
		RecordAggregator ra = new RecordAggregator();
		assertThrows(NullPointerException.class,() -> {
			ra.elaboraOrari(null, null);
		});
		assertThrows(NullPointerException.class,() -> {
			ra.creaRigheVuoteOrari(null, null);
		});	
		assertThrows(Exception.class,() -> {
			ra.posizionaOrari(null, null);
		});		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testTimbraturaCorretta() {
		// Inserimento di una timbratura
		Timbratura t = new Timbratura();
		t.setData(new Date(2018-1900,12-1,20+1));
		t.setOra(new Time(10+1,20,00));
		t.setTipo("IN");
		// Impostazione del dipendente relativo alla timbratura
		TypedQuery<Dipendente> query = DBHandler.getEntityManager().createQuery("SELECT d FROM Dipendente d WHERE d.IDBadge='00001'",Dipendente.class);
		if (query.getResultList().isEmpty() || query.getResultList().size()>1) assert(false);
		t.setDipendente(query.getResultList().get(0));
		// Salvataggio delle modifiche nel database, per la persistenza
		DBHandler.getEntityManager().getTransaction().begin();
		DBHandler.getEntityManager().persist(t);
		DBHandler.getEntityManager().getTransaction().commit();
		// Chiamata del metodo di aggregazione nella sua interezza
		RecordAggregator ra = new RecordAggregator();
		ra.aggregate();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testTimbratureCorrette() {
		// Inserimento di 4 timbrature
		Timbratura t = new Timbratura();
		Timbratura t1 = new Timbratura();
		Timbratura t2 = new Timbratura();
		Timbratura t3 = new Timbratura();
		// Prima timbratura
		t.setData(new Date(2018-1900,12-1,20+1));
		t.setOra(new Time(10+1,20,00));
		t.setTipo("IN");
		// Seconda timbratura
		t1.setData(new Date(2018-1900,12-1,20+1));
		t1.setOra(new Time(13+1,20,00));
		t1.setTipo("OUT");
		// Terza timbratura
		t2.setData(new Date(2018-1900,12-1,20+1));
		t2.setOra(new Time(15+1,20,00));
		t2.setTipo("IN");
		// Quarta timbratura
		t3.setData(new Date(2018-1900,12-1,20+1));
		t3.setOra(new Time(20+1,20,00));
		t3.setTipo("OUT");
		// Impostazione del dipendente relativo alla timbratura
		TypedQuery<Dipendente> query = DBHandler.getEntityManager().createQuery("SELECT d FROM Dipendente d WHERE d.IDBadge='00001'",Dipendente.class);
		if (query.getResultList().isEmpty() || query.getResultList().size()>1) assert(false);
		t.setDipendente(query.getResultList().get(0));
		t1.setDipendente(query.getResultList().get(0));
		t2.setDipendente(query.getResultList().get(0));
		t3.setDipendente(query.getResultList().get(0));
		// Salvataggio delle modifiche nel database, per la persistenza
		DBHandler.getEntityManager().getTransaction().begin();
		DBHandler.getEntityManager().persist(t);
		DBHandler.getEntityManager().persist(t1);
		DBHandler.getEntityManager().persist(t2);
		DBHandler.getEntityManager().persist(t3);
		DBHandler.getEntityManager().getTransaction().commit();
		// Chiamata del metodo di aggregazione nella sua interezza
		RecordAggregator ra = new RecordAggregator();
		ra.aggregate();
	}

}
