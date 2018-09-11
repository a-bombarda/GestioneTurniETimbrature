package gestioneOrariData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Turno database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int IDTurno;
	
	
	public int getIDTurno() {
		return IDTurno;
	}

	public void setIDTurno(int iDTurno) {
		IDTurno = iDTurno;
	}

	private String descrizione;

	//bi-directional many-to-many association to Dipendente
	@ManyToMany(mappedBy="turnos")
	private List<Dipendente> dipendentes;

	public Turno() {
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Dipendente> getDipendentes() {
		return this.dipendentes;
	}

	public void setDipendentes(List<Dipendente> dipendentes) {
		this.dipendentes = dipendentes;
	}

}