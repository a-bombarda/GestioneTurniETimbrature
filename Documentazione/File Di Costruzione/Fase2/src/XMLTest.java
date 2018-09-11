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
		RecordParser rp = new RecordParser();
		assertNull(rp.parserXML("1234"));
	}
	
	@Test
	void fileCorretto() {
		RecordParser rp = new RecordParser();
		createTestXML();
		assertNotNull(rp.parserXML("fileTestRecord.xml"));
	}

}
