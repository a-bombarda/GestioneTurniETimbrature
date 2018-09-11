public class XMLHandler extends DefaultHandler{

	private XMLTag tag = XMLTag.NOTAG; 
	private Date dataXML;
	private List<Timbratura> listaTimbrature = new ArrayList<Timbratura>();
	private Timbratura tempRecord = new Timbratura();
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
		...
	}
			    
	public void characters(char[] ch, int start, int length) throws SAXException { 
		...
	}
			    
	public void endElement(String uri, String localName, String qName) throws SAXException {
		...			
	}
	  
	public List<Timbratura> getRecordList() {
		...
	}
	
}