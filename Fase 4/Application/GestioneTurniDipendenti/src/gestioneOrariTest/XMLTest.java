package gestioneOrariTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import gestioneOrariApplication.RecordParser;

class XMLTest {

	@Test
	void testPercorsoNonEsistente() {
		// Chiamata del metodo di parsing utilizzando un percorso non esistente
		RecordParser rp = new RecordParser();
		assertNull(rp.parserXML("1234"));
	}
	
	@Test
	void fileCorretto() {
		RecordParser rp = new RecordParser();
		// Creazione di un file XML corretto di test
		createTestXML();
		// Controllo sul fatto che venga ritorntato qualcosa dall'operazione di parsing
		assertNotNull(rp.parserXML("fileTestRecord.xml"));
	}
	
	void createTestXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// Elemento root RECORDS con attributo DATE
			Document doc = docBuilder.newDocument();
			Element records = doc.createElement("records");
			records.setAttribute("date", "30/04/2018");
			doc.appendChild(records);
			// Aggiunta di un elemento di una singola timbratura
			Element record = doc.createElement("record");
			record.setAttribute("type", "IN");
			records.appendChild(record);
			// Aggiunta dei dati relativi a badge ed orario di timbratura
			Element badgeID = doc.createElement("badgeID");
			badgeID.appendChild(doc.createTextNode("00001"));
			record.appendChild(badgeID);
			Element time = doc.createElement("time");
			time.appendChild(doc.createTextNode("00:00:00"));
			record.appendChild(time);
			// Scrittura dei dati nel file XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("fileTestRecord.xml"));
			transformer.transform(source, result);
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}

}
