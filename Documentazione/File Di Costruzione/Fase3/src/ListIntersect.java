package gestioneTurniApplication;

import java.util.ArrayList;
import java.util.List;

public class ListIntersect<T> implements Intersect<T>{

	/*
	 * Funzione per il calcolo dell'intersezione tra due arrayList
	 */
	@Override
	public ArrayList<T> intersect(List<T> a, List<T> b) {
		ArrayList<T> lstIntersectAB = new ArrayList<T>(a);
		lstIntersectAB.retainAll(b);
		return lstIntersectAB;
	}
	
}
