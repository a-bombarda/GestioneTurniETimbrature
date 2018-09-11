package gestioneTurniData;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Classe realizzata per rappresentare la chiave primaria della classe AssegnazioneTurno, che non è
 * un unico campo ma è composto da tre campi
 */

@Embeddable
public class IDAssegnazione implements Serializable {
 
	//==============================
	// Attributi
	//==============================
	
	private static final long serialVersionUID = 1L;

	@Column(name = "IDTurno")
    private int IDTurno;
	
	@Column(name = "IDBadge")
    private String IDBadge;
 
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date Data;
	
	//==============================
	// Metodi
	//==============================
    
    public int getIDTurno() {
		return IDTurno;
	}

	public void setIDTurno(int iDTurno) {
		IDTurno = iDTurno;
	}

	public String getIDBadge() {
		return IDBadge;
	}

	public void setIDBadge(String iDBadge) {
		IDBadge = iDBadge;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

    public IDAssegnazione() {  }
 
    public IDAssegnazione(int IDTurno, String IDBadge, Date Data) {
        this.IDTurno = IDTurno;
        this.IDBadge = IDBadge;
        this.Data = Data;
    }
 
    // Override del metodo di Object, per il confronto tra due oggetti di classe IDAssegnazione
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDAssegnazione)) return false;
        IDAssegnazione that = (IDAssegnazione) o;
        return Objects.equals(getIDTurno(), that.getIDTurno()) &&
                Objects.equals(getData(), that.getData()) &&
                		Objects.equals(getIDBadge(), that.getIDBadge()) ;
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getIDBadge(), getData(),getIDTurno());
    }
}