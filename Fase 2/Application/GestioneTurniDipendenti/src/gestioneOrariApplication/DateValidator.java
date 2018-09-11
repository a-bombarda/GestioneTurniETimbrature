package gestioneOrariApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Classe utilizzata per validare le date inserite ed, in caso, permettere la modifica
 */
public class DateValidator {

	/*
	 * Funzione utilizzata per detrminare se una stringa rappresenta una data valida, in base ad un determinato pattern
	 */
	public static void isThisDateValid(String dateToValidate, String dateFromat) throws ParseException{
		if(dateToValidate == null){
			throw new ParseException("Data vuota", 0);
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		// Creazione della data usando i dati inseriti. Nel caso in cui il formato sia sbagliato viene lanciata una ParseException
		@SuppressWarnings("unused")
		Date date = sdf.parse(dateToValidate);		
	}
	
	/* 
	 * Funzione utilizzata per l'incremento della data di un certo numero di giorni
	 */
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	
}
