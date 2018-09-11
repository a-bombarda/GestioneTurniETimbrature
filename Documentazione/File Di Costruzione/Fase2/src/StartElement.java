public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
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