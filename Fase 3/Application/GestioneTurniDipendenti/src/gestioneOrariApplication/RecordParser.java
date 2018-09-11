package gestioneOrariApplication;

import java.io.FileReader;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

import gestioneOrariData.Timbratura;

public class RecordParser implements XMLParser<List<Timbratura>> {

	@Override
	/* 
	 * Metodo che si occupa di fare il parsing del file XML passato dalla selezione dalla GUI.
	 * 
	 * @param filePath è il percorso del file che si vuole caricare
	 * @return ritorna la lista contenente tutte le timbrature parsate
	 */
	public List<Timbratura> parserXML(String filePath) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			XMLHandler recordHandler = new XMLHandler();
			saxParser.parse(new InputSource(new FileReader(filePath)), recordHandler);
			return recordHandler.getRecordList();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
                    "Errore nel formato del file", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	}

}
