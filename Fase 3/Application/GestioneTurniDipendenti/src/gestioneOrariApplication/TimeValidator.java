package gestioneOrariApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/*
 * Classe utilizzata per validare gli orari inseriti ed, in caso, permettere la modifica
 */
public class TimeValidator{
	
	  private static Pattern pattern;
	  private static Matcher matcher;
	  // Espressione regolare che deve essere matchata
	  private static final String TIME24HOURS_PATTERN = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
	  
	  /**
	   * Validate time in 24 hours format with regular expression
	   * @param time time address for validation
	   * @return true valid time fromat, false invalid time format
	   */
	  public static void validate(final String time) throws Exception{
		  pattern = Pattern.compile(TIME24HOURS_PATTERN);
		  matcher = pattern.matcher(time);
		  if (!matcher.matches()) throw new Exception("Formato orario errato");	    	    
	  }
	  
	  /*
	   * Funzione utilizzata per adattare l'ora nel formato voluto da MySQL
	   */
	  public static Date HoursSet(Date d) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.HOUR_OF_DAY, -1);
			return cal.getTime();
	  }
}
