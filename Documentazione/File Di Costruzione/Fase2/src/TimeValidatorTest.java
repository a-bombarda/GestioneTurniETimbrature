package gestioneOrariTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import gestioneOrariApplication.TimeValidator;

class TimeValidatorTest {

	@Test
	void testOrarioCorretto() throws Exception {
		TimeValidator.validate("10:20:00");
		TimeValidator.validate("23:59:59");
		TimeValidator.validate("00:00:00");
	}
	
	@Test
	void testOrarioFormatoErrato() {
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("10-20-00");
		});
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("10:20.00");
		});
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("10.20.00");
		});
	}
	
	@Test
	void testOrarioErrato() {
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("24:00:00");
		});
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("25:00:00");
		});
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("10:70:00");
		});
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("10:20:80");
		});
	}

	@Test
	void testSetOreCorretto() {
		Date d = new Date();
		d.setHours(5);
		assertEquals(TimeValidator.HoursSet(d).getHours(),4);
	}
	
	@Test
	void testSetOreNull() {
		assertThrows(NullPointerException.class,() -> {
			TimeValidator.HoursSet(null);
		});
	}
}
