package gestioneOrariData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Straordinario database table.
 * 
 */
@Entity
@NamedQuery(name="Straordinario.findAll", query="SELECT s FROM Straordinario s")
public class Straordinario implements Serializable {
	private static final long serialVersionUID = 1L;

	private int IDAttività;

	@Id
	private int IDStraordinario;

	private double n_Ore;

	//bi-directional many-to-many association to Dipendente
	@ManyToMany(mappedBy="straordinarios")
	private List<Dipendente> dipendentes;

	public Straordinario() {
	}

	public int getIDAttività() {
		return this.IDAttività;
	}

	public void setIDAttività(int IDAttività) {
		this.IDAttività = IDAttività;
	}

	public int getIDStraordinario() {
		return this.IDStraordinario;
	}

	public void setIDStraordinario(int IDStraordinario) {
		this.IDStraordinario = IDStraordinario;
	}

	public double getN_Ore() {
		return this.n_Ore;
	}

	public void setN_Ore(double n_Ore) {
		this.n_Ore = n_Ore;
	}

	public List<Dipendente> getDipendentes() {
		return this.dipendentes;
	}

	public void setDipendentes(List<Dipendente> dipendentes) {
		this.dipendentes = dipendentes;
	}

}