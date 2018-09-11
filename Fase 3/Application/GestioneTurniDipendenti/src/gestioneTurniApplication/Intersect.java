package gestioneTurniApplication;

import java.util.ArrayList;
import java.util.List;

public interface Intersect<T> {
	ArrayList<T> intersect(List<T> a, List<T> b);
}
