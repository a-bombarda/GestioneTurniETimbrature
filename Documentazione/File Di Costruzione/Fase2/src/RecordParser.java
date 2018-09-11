public interface XMLParser<T> {
	public T parserXML(String filePath);
}

public class RecordParser implements 
	XMLParser<List<Timbratura>> {
	
	@Override
	public List<Timbratura> parserXML(String filePath) {
		try {
			SAXParserFactory factory = 
				SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			XMLHandler recordHandler = new XMLHandler();
			saxParser.parse(new InputSource(
				new FileReader(filePath)), recordHandler);
			return recordHandler.getRecordList();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
