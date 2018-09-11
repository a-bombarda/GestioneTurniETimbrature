package gestioneTurniTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;
import org.junit.jupiter.api.Test;

import gestioneTurniApplication.ImpossibleSchedulingException;
import gestioneTurniApplication.StaffScheduler;

public class StaffSchedulerTest {

	@SuppressWarnings("deprecation")
	@Test
	void testMakeSchedule() {
		StaffScheduler s = new StaffScheduler();

		// Test con date corrette, ma fabbisogno non inserito
		try {
			assertTrue(s.makeSchedule(new Date(2018 - 1900, 2, 10), new Date(2018 - 1900, 2, 12)).size() == 0);
		} catch (ImpossibleSchedulingException e) {
			e.printStackTrace();
		}

		// Test con date corrette, con fabbisogno inserito e schedule possibile
		try {
			assertTrue(s.makeSchedule(new Date(2018 - 1900, 0, 1), new Date(2018 - 1900, 0, 3)).size() > 0);
		} catch (ImpossibleSchedulingException e) {
			e.printStackTrace();
		}

		// Test con date corrette, con fabbisogno inserito ma schedule non possibile
		try {
			assertTrue(s.makeSchedule(new Date(2018 - 1900, 0, 1), new Date(2018 - 1900, 0, 7)) == null);
		} catch (ImpossibleSchedulingException e) {
			e.printStackTrace();
		}

		// Test con date distanti tra di loro piu' di 7 giorni
		try {
			assertTrue(s.makeSchedule(new Date(2018 - 1900, 0, 1), new Date(2018 - 1900, 0, 10)) == null);
		} catch (ImpossibleSchedulingException e) {
			e.printStackTrace();
		}

		// Test con date null
		try {
			s.makeSchedule(null, null);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ImpossibleSchedulingException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	void testGetPartialSchedule() {
		StaffScheduler s = new StaffScheduler();
		
		// Test con date corrette, con fabbisogno inserito ma schedule non possibile ->
		// Si puo' ricavare lo schedule parziale
		try {
			assertTrue(s.makeSchedule(new Date(2018 - 1900, 0, 1), new Date(2018 - 1900, 0, 7)) == null);
		} catch (ImpossibleSchedulingException e) {
			e.printStackTrace();
		}
		assertTrue(s.getPartialSchedule().size()>0);
	}
}
