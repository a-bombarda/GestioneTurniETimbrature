package gestioneOrariData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Orario database table.
 * 
 */
@Entity
@NamedQuery(name="Orario.findAll", query="SELECT o FROM Orario o")
public class Orario implements Serializable, QueryMalattie, QueryOrdinari, QueryPermessiFerie, QueryStraordinari {
	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date data;

	private boolean ferie;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDOrario;

	@Temporal(TemporalType.TIME)
	private Date ingresso1;

	@Temporal(TemporalType.TIME)
	private Date ingresso2;

	private boolean malattia;

	private double ore_FeriePermessi;

	private double ore_Malattia;

	private double ore_Ordinario;

	private double ore_Straordinario;

	@Temporal(TemporalType.TIME)
	private Date uscita1;

	@Temporal(TemporalType.TIME)
	private Date uscita2;

	//bi-directional many-to-one association to Dipendente
	@ManyToOne
	@JoinColumn(name="IDBadge", referencedColumnName="IDBadge")
	private Dipendente dipendente;

	public Orario() {
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean getFerie() {
		return this.ferie;
	}

	public void setFerie(boolean ferie) {
		this.ferie = ferie;
	}

	public int getIDOrario() {
		return this.IDOrario;
	}

	public void setIDOrario(int IDOrario) {
		this.IDOrario = IDOrario;
	}

	public Date getIngresso1() {
		return this.ingresso1;
	}

	public void setIngresso1(Date ingresso1) {
		this.ingresso1 = ingresso1;
	}

	public Date getIngresso2() {
		return this.ingresso2;
	}

	public void setIngresso2(Date ingresso2) {
		this.ingresso2 = ingresso2;
	}

	public boolean getMalattia() {
		return this.malattia;
	}

	public void setMalattia(boolean malattia) {
		this.malattia = malattia;
	}

	public double getOre_FeriePermessi() {
		return this.ore_FeriePermessi;
	}

	public void setOre_FeriePermessi(double ore_FeriePermessi) {
		this.ore_FeriePermessi = ore_FeriePermessi;
	}

	public double getOre_Malattia() {
		return this.ore_Malattia;
	}

	public void setOre_Malattia(double ore_Malattia) {
		this.ore_Malattia = ore_Malattia;
	}

	public double getOre_Ordinario() {
		return this.ore_Ordinario;
	}

	public void setOre_Ordinario(double ore_Ordinario) {
		this.ore_Ordinario = ore_Ordinario;
	}

	public double getOre_Straordinario() {
		return this.ore_Straordinario;
	}

	public void setOre_Straordinario(double ore_Straordinario) {
		this.ore_Straordinario = ore_Straordinario;
	}

	public Date getUscita1() {
		return this.uscita1;
	}

	public void setUscita1(Date uscita1) {
		this.uscita1 = uscita1;
	}

	public Date getUscita2() {
		return this.uscita2;
	}

	public void setUscita2(Date uscita2) {
		this.uscita2 = uscita2;
	}

	public Dipendente getDipendente() {
		return this.dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	@Override
	public void updateStraordinari(float val, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getStraordinari(Date data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateFerie(float val, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePermessi(float val, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getFerie(Date data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPermessi(Date data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateOrdinari(float val, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getOrdinari(Date data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMalattie(float val, Date data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getMalattie(Date data) {
		// TODO Auto-generated method stub
		return 0;
	}

}