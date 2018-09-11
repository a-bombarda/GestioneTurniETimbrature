package gestioneOrariData;

import java.io.Serializable;
import javax.persistence.*;

import gestioneTurniData.Attività;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Dipendente database table.
 * 
 */
@Entity
@NamedQuery(name="Dipendente.findAll", query="SELECT d FROM Dipendente d")
public class Dipendente implements Serializable, QueryAggregazioneOrari, QueryMalattie, QueryOrdinari, QueryPermessiFerie, QueryStraordinari {
	
	//==============================
	// Attributi
	//==============================
	
	private static final long serialVersionUID = 1L;
	
	// Chiave primaria
	@Id
	private String IDBadge;
	
	// Campi TRANSIENT, quindi utilizzati solo per il programma JAVA ma non presenti nel database
	@Transient
	private boolean occupato;
	@Transient
	private int free;
	
	// Campi del dipendente
	
	// bi-directional many-to-many association to Attività
	@ManyToMany(mappedBy="dipendentes")
	@JoinTable(
			name="Ruolo"
			, joinColumns={
				@JoinColumn(name="IDBadge", referencedColumnName="IDBadge")
				}
			, inverseJoinColumns={
				@JoinColumn(name="IDAttività", referencedColumnName="IDAttività")
				}
			)
	private List<Attività> attivitàs;	
	private String cognome;
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	private String EMailAziendale;
	private String nome;
	private int oreContrattuali_Settimana;
	private double pagaBaseOraria;
	// bi-directional many-to-one association to Orario
	@OneToMany(mappedBy="dipendente")
	private List<Orario> orarios;

	// bi-directional many-to-one association to Timbratura
	@OneToMany(mappedBy="dipendente")
	private List<Timbratura> timbraturas;

	// bi-directional many-to-many association to Straordinario
	@ManyToMany
	@JoinTable(
		name="PrenotazioneStraordinario"
		, joinColumns={
			@JoinColumn(name="IDBadge", referencedColumnName="IDBadge")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDStraordinario", referencedColumnName="Data")
			}
		)
	private List<Straordinario> straordinarios;
	
	// bi-directional many-to-many association to Turno
	@ManyToMany
	@JoinTable(
		name="AssegnazioneTurno"
		, joinColumns={
			@JoinColumn(name="IDBadge", referencedColumnName="IDBadge")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDTurno", referencedColumnName="IDTurno")
			}
		)
	private List<Turno> turnos;
	
	//==============================
	// Metodi
	//==============================
	
	public String getIDBadge() {
		return IDBadge;
	}

	public void setIDBadge(String iDBadge) {
		IDBadge = iDBadge;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public void addFree(int free) {
		this.free += free;
	}
	
	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	
	public List<Attività> getAttivitàs() {
		return attivitàs;
	}

	public void setAttivitàs(List<Attività> attivitàs) {
		this.attivitàs = attivitàs;
	}
	
	public Dipendente() {	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEMailAziendale() {
		return this.EMailAziendale;
	}

	public void setEMailAziendale(String EMailAziendale) {
		this.EMailAziendale = EMailAziendale;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getOreContrattuali_Settimana() {
		return this.oreContrattuali_Settimana;
	}

	public void setOreContrattuali_Settimana(int oreContrattuali_Settimana) {
		this.oreContrattuali_Settimana = oreContrattuali_Settimana;
	}

	public double getPagaBaseOraria() {
		return this.pagaBaseOraria;
	}

	public void setPagaBaseOraria(double pagaBaseOraria) {
		this.pagaBaseOraria = pagaBaseOraria;
	}

	public List<Orario> getOrarios() {
		return this.orarios;
	}

	public void setOrarios(List<Orario> orarios) {
		this.orarios = orarios;
	}

	public Orario addOrario(Orario orario) {
		getOrarios().add(orario);
		orario.setDipendente(this);
		return orario;
	}

	public Orario removeOrario(Orario orario) {
		getOrarios().remove(orario);
		orario.setDipendente(null);

		return orario;
	}

	public List<Timbratura> getTimbraturas() {
		return this.timbraturas;
	}

	public void setTimbraturas(List<Timbratura> timbraturas) {
		this.timbraturas = timbraturas;
	}

	public Timbratura addTimbratura(Timbratura timbratura) {
		getTimbraturas().add(timbratura);
		timbratura.setDipendente(this);
		return timbratura;
	}

	public Timbratura removeTimbratura(Timbratura timbratura) {
		getTimbraturas().remove(timbratura);
		timbratura.setDipendente(null);
		return timbratura;
	}

	public List<Straordinario> getStraordinarios() {
		return this.straordinarios;
	}

	public void setStraordinarios(List<Straordinario> straordinarios) {
		this.straordinarios = straordinarios;
	}

	public List<Turno> getTurnos() {
		return this.turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public void updateStraordinari(float val, Date data) {	}

	@Override
	public float getStraordinari(Date data) {
		return 0;
	}

	@Override
	public void updateFerie(float val, Date data) { 	}

	@Override
	public void updatePermessi(float val, Date data) {	}

	@Override
	public float getFerie(Date data) {
		return 0;
	}

	@Override
	public float getPermessi(Date data) {
		return 0;
	}

	@Override
	public void updateOrdinari(float val, Date data) {	}

	@Override
	public float getOrdinari(Date data) {
		return 0;
	}

	@Override
	public void updateMalattie(float val, Date data) {	}

	@Override
	public float getMalattie(Date data) {
		return 0;
	}

	@Override
	public void aggregaOrari(Date data) {	}

	@Override
	public void getOrariAggregati(Date data) {	}

	// Override del metodo Equals di Object, utilizzato per confrontare due dipendenti 
	@Override
	public boolean equals(Object o) {
		if(!((Dipendente)o).cognome.equals(this.cognome)) return false;
		if(!((Dipendente)o).nome.equals(this.nome)) return false;
		if(!((Dipendente)o).dataNascita.equals(this.dataNascita)) return false;
		if(!((Dipendente)o).EMailAziendale.equals(this.EMailAziendale)) return false;
		if(((Dipendente)o).oreContrattuali_Settimana!=this.oreContrattuali_Settimana) return false;
		if(((Dipendente)o).pagaBaseOraria!=this.pagaBaseOraria) return false;	
		return true;
	}

	// Metodo utilizzato per l'inizializzazione dei due campi transient del dipendente
	public void initDipendente() {
		setOccupato(false);
		setFree(oreContrattuali_Settimana);
	}
	
}