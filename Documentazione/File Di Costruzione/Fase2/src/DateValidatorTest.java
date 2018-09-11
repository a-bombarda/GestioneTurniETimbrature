package gestioneOrariTest;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import org.junit.jupiter.api.Test;
import gestioneOrariApplication.DateValidator;

class DateValidatorTest {

	@Test
	void testDataCorretta() throws ParseException {
		DateValidator.isThisDateValid("10/04/2018", "dd/MM/yyyy");
	}
	
	@Test
	void testDataGiornoErrato() {
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("31/04/2018", "dd/MM/yyyy");
		});
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("04/14/2018", "dd/MM/yyyy");
		});
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("GGDBEJK", "dd/MM/yyyys");
		});
	}
	
	@Test
	void formatoDataErrato() {
		assertThrows(IllegalArgumentException.class,() -> {
			DateValidator.isThisDateValid("31/04/2018", "ss/mm/pqrt");
		});
	}
	
	@Test
	void annoBisestile() throws ParseException {
		DateValidator.isThisDateValid("29/02/2020", "dd/MM/yyyy");
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid("20/02/2018", "dd/MM/yyyys");
		});
	}
	
	@Test
	void dataNull() {
		assertThrows(ParseException.class,() -> {
			DateValidator.isThisDateValid(null, "dd/MM/yyyys");
		});
	}

	@Test
	void addDataCorretto() {
		assertEquals(DateValidator.addDays(new Date(2018,2,3),1).getDate(),4);
		assertEquals(DateValidator.addDays(new Date(2018,2,3),0).getDate(),3);
		assertEquals(DateValidator.addDays(new Date(2018,2,3),-1).getDate(),2);
	}
	
	@Test
	void addDataNull() {
		assertThrows(NullPointerException.class,() -> {
			DateValidator.addDays(null,1);
		});
	}
}
