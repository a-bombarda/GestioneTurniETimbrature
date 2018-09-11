package gestioneTurniData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Fabbisogno_Dipendenti database table.
 * 
 */
@Entity
@NamedQuery(name="Fabbisogno_Dipendenti.findAll", query="SELECT f FROM Fabbisogno_Dipendenti f")
public class Fabbisogno_Dipendenti implements Serializable {
	
	//==============================
	// Attributi
	//==============================
	
	// Chiave primaria composta
	@EmbeddedId
	private IDFabbisogno id;
	
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private Date data;

	private int IDAttività;
	private int IDTurno;
	private int n_Dipendenti;
	
	//==============================
	// Metodi
	//==============================
	
	public Fabbisogno_Dipendenti() { }
	
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIDAttività() {
		return this.IDAttività;
	}

	public void setIDAttività(int IDAttività) {
		this.IDAttività = IDAttività;
	}

	public int getIDTurno() {
		return this.IDTurno;
	}

	public void setIDTurno(int IDTurno) {
		this.IDTurno = IDTurno;
	}

	public int getN_Dipendenti() {
		return this.n_Dipendenti;
	}

	public void setN_Dipendenti(int n_Dipendenti) {
		this.n_Dipendenti = n_Dipendenti;
	}
}