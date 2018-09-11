package gestioneTurniData;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
/**
 * The persistent class for the AssegnazioneTurno database table.
 * 
 */
@Entity
@NamedQuery(name="AssegnazioneTurno.findAll", query="SELECT a FROM AssegnazioneTurno a")
public class AssegnazioneTurno implements Serializable {
	
	//==============================
	// Attributi
	//==============================
	
	// Chiave primaria composta
	@EmbeddedId
	private IDAssegnazione id = new IDAssegnazione();
	
	private static final long serialVersionUID = 1L;
	
	//==============================
	// Metodi
	//==============================

	public AssegnazioneTurno(Date data, String IDBadge, int IDTurno) {
		this.id.setData(data);
		this.id.setIDBadge(IDBadge);
		this.id.setIDTurno(IDTurno);
	}
	
	public AssegnazioneTurno() { }

	public Date getData() {
		return this.id.getData();
	}

	public void setData(Date data) {
		this.id.setData(data);
	}

	public String getIDBadge() {
		return this.id.getIDBadge();
	}

	public void setIDBadge(String IDBadge) {
		this.id.setIDBadge(IDBadge);
	}

	public int getIDTurno() {
		return this.id.getIDTurno();
	}

	public void setIDTurno(int IDTurno) {
		this.id.setIDTurno(IDTurno);
	}
}
