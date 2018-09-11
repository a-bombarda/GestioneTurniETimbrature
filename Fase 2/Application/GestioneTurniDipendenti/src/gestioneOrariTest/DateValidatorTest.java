package gestioneOrariTest;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import gestioneOrariApplication.DateValidator;

class DateValidatorTest {

	@Test
	void testDataCorretta() throws ParseException {
		// Test con una data corretta
		DateValidator.isThisDateValid("10/04/2018", "dd/MM/yyyy");
	}
	
	@Test
	void testDataGiornoErrato() {
		// Test con una data errata -> non esiste il 31 aprile
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("31/04/2018", "dd/MM/yyyy");
		});
		// Test con una data errata -> non esiste il mese 14
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("04/14/2018", "dd/MM/yyyy");
		});
		// Test con una data errata -> non viene passata una data
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("GGDBEJK", "dd/MM/yyyys");
		});
	}
	
	@Test
	void formatoDataErrato() {
		// Test con una data corretta ma formato di verifica errato
		assertThrows(IllegalArgumentException.class,() -> {
			DateValidator.isThisDateValid("31/04/2018", "ss/mm/pqrt");
		});
	}
	
	@Test
	void annoBisestile() throws ParseException {
		// Test con il 29 febbraio in un anno bisestile -> Non deve dare errore
		DateValidator.isThisDateValid("29/02/2020", "dd/MM/yyyy");
		// Test con il 29 febbraio in un anno non bisestile -> deve dare eccezione
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("20/02/2018", "dd/MM/yyyys");
		});
	}
	
	@Test
	void dataNull() {
		// Test passando un valore nullo per la data
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid(null, "dd/MM/yyyys");
		});
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void addDataCorretto() {
		// Test della funzione di somma dei giorni, per verificare il comportamento con 
		// numero di giorni positivo, nullo e negativo
		assertEquals(DateValidator.addDays(new Date(2018,2,3),1).getDate(),4);
		assertEquals(DateValidator.addDays(new Date(2018,2,3),0).getDate(),3);
		assertEquals(DateValidator.addDays(new Date(2018,2,3),-1).getDate(),2);
	}
	
	@Test
	void addDataNull() {
		// Test della funzione di somma dei giorni, passando una data null
		assertThrows(NullPointerException.class,() -> {
			DateValidator.addDays(null,1);
		});
	}

}
