package gestioneOrariApplication;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import gestioneOrariData.Dipendente;
import gestioneOrariData.Timbratura;

public class XMLHandler extends DefaultHandler{

	private XMLTag tag = XMLTag.NOTAG; 
	private Date dataXML;
	private List<Timbratura> listaTimbrature = new ArrayList<Timbratura>();
	private Timbratura tempRecord = new Timbratura();
	
	@SuppressWarnings("deprecation")
	@Override 
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
		// Identificazione del nome del Tag incontrato
		switch (qName) {
			case "records": 
				tag = XMLTag.RECORDS; 
				dataXML = new Date(Integer.parseInt(attributes.getValue("date").toString().substring(6, 10))-1900,
								Integer.parseInt(attributes.getValue("date").toString().substring(3, 5))-1,
								Integer.parseInt(attributes.getValue("date").toString().substring(0, 2)));	
				break;
			case "record": tag = XMLTag.RECORD; 
				tempRecord = new Timbratura();
				tempRecord.setData(dataXML);
				tempRecord.setTipo(attributes.getValue("type"));
				break;
			case "badgeID": tag = XMLTag.BADGEID; break;
			case "time": tag = XMLTag.TIME; break;
			default: break;
		}
	}
			    
	@SuppressWarnings("deprecation")
	@Override 
	public void characters(char[] ch, int start, int length) throws SAXException { 
		String content = new String(ch, start, length);
		// In base al tag letto, si imposta il valore corretto per il campo dell'oggetto
		switch (tag) {
			case BADGEID:
				TypedQuery<Dipendente> query = DBHandler.getEntityManager().createQuery("SELECT d FROM Dipendente d WHERE d.IDBadge='" + content + "'",Dipendente.class);
				if (query.getResultList().isEmpty() || query.getResultList().size()>1) throw new SAXException();
				tempRecord.setDipendente(query.getResultList().get(0));
				break;
			case TIME:
				tempRecord.setOra(new Time(Integer.parseInt(content.substring(0, 2)),
										  Integer.parseInt(content.substring(3,5)),
										  Integer.parseInt(content.substring(6,8))));
				break;
			default: break;
		}
	}
			    
	@Override 
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (tag) {
			case TIME:
				// Aggiunta della timbratura generata alla lista
				listaTimbrature.add(tempRecord);
			default:
				tag=XMLTag.NOTAG;
		}			
	}
	  
	public List<Timbratura> getRecordList() {
		  return listaTimbrature;
	}
	
}
