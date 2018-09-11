package gestioneOrariApplication;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/*
 * Componente utilizzato per l'accesso alle operazioni di persistenza tra oggetti JAVA e le tabelle del database
 */
public class DBHandler {	
	private static EntityManager em = Persistence.createEntityManagerFactory("GestioneTurniDipendenti").createEntityManager();	
	public static EntityManager getEntityManager() {
		return em;
	}	
}
