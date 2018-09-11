public void endElement(String uri, String localName, String qName) throws SAXException {
	switch (tag) {
		case TIME:
			listaTimbrature.add(tempRecord);
		default:
			tag=XMLTag.NOTAG;
	}			
}