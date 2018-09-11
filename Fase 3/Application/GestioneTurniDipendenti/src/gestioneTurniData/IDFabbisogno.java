package gestioneTurniData;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * Classe realizzata per rappresentare la chiave primaria della classe Fabbisogno_Dipendenti, che non è
 * un unico campo ma è composto da tre campi
 */
@Embeddable
public class IDFabbisogno implements Serializable {
 
	//==============================
	// Attributi
	//==============================
	
	private static final long serialVersionUID = 1L;

	@Column(name = "IDTurno")
    private int IDTurno;   

	@Column(name = "IDAttività")
    private int IDAttività;
 
    @Column(name = "Data")
    private Date Data;
    
    //==============================
  	// Metodi
  	//==============================
 
    public IDFabbisogno() {   }
 
    public IDFabbisogno(int IDTurno, int IDAttività, Date Data) {
        this.IDTurno = IDTurno;
        this.IDAttività = IDAttività;
        this.Data = Data;
    }
 
    // Override del metodo di Object, per il confronto tra due oggetti di classe IDFabbisogno
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDFabbisogno)) return false;
        IDFabbisogno that = (IDFabbisogno) o;
        return Objects.equals(getIDTurno(), that.getIDTurno()) &&
                Objects.equals(getData(), that.getData()) &&
                		Objects.equals(getIDAttività(), that.getIDAttività()) ;
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getIDAttività(), getData(),getIDTurno());
    }
    
    public int getIDTurno() {
		return IDTurno;
	}

	public void setIDTurno(int iDTurno) {
		IDTurno = iDTurno;
	}

	public int getIDAttività() {
		return IDAttività;
	}

	public void setIDAttività(int IDAttività) {
		this.IDAttività = IDAttività;
	}
	
	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}
}