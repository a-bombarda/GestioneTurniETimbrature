package gestioneOrariTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import gestioneOrariApplication.TimeValidator;

class TimeValidatorTest {

	@Test
	void testOrarioCorretto() throws Exception {
		// Test con alcuni orari corretti
		TimeValidator.validate("10:20:00");
		TimeValidator.validate("23:59:59");
		TimeValidator.validate("00:00:00");
	}
	
	@Test
	void testOrarioFormatoErrato() {
		// Test con orari con formato non corretto
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
		// Test con orario errato: le 24 devono essere scritte come 00
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("24:00:00");
		});
		// Test con orario errato: le ore sono da 00 a 23
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("25:00:00");
		});
		// Test con orario errato: i minuti vanno da 00 a 59
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("10:70:00");
		});
		// Test con orario errato: i secondi vanno da 00 a 59
		assertThrows(Exception.class,() -> {
			TimeValidator.validate("10:20:80");
		});
	}
	
	@SuppressWarnings("deprecation")
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
