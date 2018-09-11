package gestioneTurniTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import gestioneTurniApplication.ListIntersect;

public class ListIntersectTest {

	@Test
	void testCorrettiInteger() {
		// ===========================
		// Test dell'intersezione tra due List, passando argomenti corretti
		// ===========================

		// Test con due ArrayList di Integer con elemento in comune
		ListIntersect<Integer> intersector = new ListIntersect<Integer>();
		ArrayList<Integer> result = intersector.intersect(Arrays.asList(1, 2, 3), Arrays.asList(1, 5, 4));
		assertTrue(result.get(0) == 1 && result.size() == 1);

		// Test con due ArrayList di Integer senza elementi in comune
		result = intersector.intersect(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
		assertTrue(result.size() == 0);
	}

	@Test
	void testCorrettiString() {
		// ===========================
		// Test dell'intersezione tra due List, passando argomenti corretti
		// ===========================

		// Test con due ArrayList di String con elemento in comune
		ListIntersect<String> intersector = new ListIntersect<String>();
		ArrayList<String> result = intersector.intersect(Arrays.asList("Ciao", "Come", "Va"),
				Arrays.asList("Va", "Tutto", "Bene"));
		assertTrue(result.get(0).equals("Va") && result.size() == 1);

		// Test con due ArrayList di String senza elementi in comune
		result = intersector.intersect(Arrays.asList("Ciao", "Come", "Va"), Arrays.asList("Tutto", "Bene", "Grazie"));
		assertTrue(result.size() == 0);
	}

	@Test
	void testElementiNull() {
		// ===========================
		// Test dell'intersezione tra una List ed un null
		// ===========================

		ListIntersect<String> intersector = new ListIntersect<String>();

		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			ArrayList<String> result = intersector.intersect(Arrays.asList("Ciao", "Come", "Va"), null);
		});

		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			ArrayList<String> result = intersector.intersect(null, Arrays.asList("Ciao", "Come", "Va"));
		});
		
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			ArrayList<String> result = intersector.intersect(null, null);
		});
	}

}
