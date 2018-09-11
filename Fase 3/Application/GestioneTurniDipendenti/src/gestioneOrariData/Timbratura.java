package gestioneOrariData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Timbratura database table.
 * 
 */
@Entity
@NamedQuery(name="Timbratura.findAll", query="SELECT t FROM Timbratura t")
public class Timbratura implements Serializable, QueryAggregazioneOrari {
	
	//==============================
	// Attributi
	//==============================
	
	// Chiave primaria
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDTimbratura;
	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Temporal(TemporalType.TIME)
	private Date ora;

	private String tipo;

	//bi-directional many-to-one association to Dipendente
	@ManyToOne
	@JoinColumn(name="IDBadge", referencedColumnName="IDBadge")
	private Dipendente dipendente;

	//==============================
	// Metodi
	//==============================
	
	public Timbratura() { }

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIDTimbratura() {
		return this.IDTimbratura;
	}

	public void setIDTimbratura(int IDTimbratura) {
		this.IDTimbratura = IDTimbratura;
	}

	public Date getOra() {
		return this.ora;
	}

	public void setOra(Date ora) {
		this.ora = ora;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Dipendente getDipendente() {
		return this.dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	@Override
	public void aggregaOrari(Date data) {	}

	@Override
	public void getOrariAggregati(Date data) {	}
	
	// Override del metodo di Object per il confronto tra due timbrature
	@Override
	public boolean equals(Object o) {
		if(((Timbratura)o).data.equals(this.data)==false) return false;
		if(((Timbratura)o).ora.equals(this.ora)==false) return false;
		if(((Timbratura)o).tipo.equals(this.tipo)==false) return false;
		if(((Timbratura)o).dipendente.equals(this.dipendente)==false) return false;		
		return true;
	}

}