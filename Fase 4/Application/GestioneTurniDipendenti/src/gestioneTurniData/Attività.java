package gestioneTurniData;

import java.io.Serializable;
import javax.persistence.*;

import gestioneOrariData.Dipendente;
import gestioneOrariData.Turno;

import java.util.List;


/**
 * The persistent class for the Attività database table.
 * 
 */
@Entity
@NamedQuery(name="Attività.findAll", query="SELECT m FROM Attività m")
public class Attività implements Serializable,QueryAttività, QueryDipendenti {
	
	//==============================
	// Attributi
	//==============================
	
	// Chiave primaria
	@Id
	private int IDAttività;
	
	private static final long serialVersionUID = 1L;
	
	@Lob
	private String descrizione;

	private String nome;
	
	//bi-directional many-to-many association to Dipendente
	@ManyToMany
	@JoinTable(
		name="Ruolo"
		, joinColumns={
			@JoinColumn(name="IDAttività", referencedColumnName="IDAttività")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDBadge", referencedColumnName="IDBadge")
			}
		)
	private List<Dipendente> dipendentes;
	
	//bi-directional many-to-many association to Turno
	@ManyToMany
	@JoinTable(
		name="Fabbisogno_Dipendenti"
		, joinColumns={
			@JoinColumn(name="IDAttività", referencedColumnName="IDAttività")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDTurno", referencedColumnName="Descrizione")
			}
		)
	private List<Turno> turnos;

	//==============================
	// Metodi
	//==============================
	
	public int getIDAttività() {
		return IDAttività;
	}

	public void setIDAttività(int iDAttività) {
		IDAttività = iDAttività;
	}

	public Attività() { 	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Dipendente> getDipendentes() {
		return this.dipendentes;
	}

	public void setDipendentes(List<Dipendente> dipendentes) {
		this.dipendentes = dipendentes;
	}

	public List<Turno> getTurnos() {
		return this.turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public void getDipendenti() {	}

	@Override
	public String getAttività() {
		return null;
	}

	@Override
	public int getNumDipPerAttività(String nomeAttività) {
		return 0;
	}

	@Override
	public void getOreDipendenti() { 	}

	@Override
	public void getOreDipendenti(Dipendente d) {	}

}