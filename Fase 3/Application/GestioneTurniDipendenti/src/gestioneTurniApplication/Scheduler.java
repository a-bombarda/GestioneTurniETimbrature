package gestioneTurniApplication;

import java.util.Vector;
import java.util.Date;

public interface Scheduler<T> {
	public Vector<T> makeSchedule(Date dataMin, Date dataMax) throws ImpossibleSchedulingException;
}
