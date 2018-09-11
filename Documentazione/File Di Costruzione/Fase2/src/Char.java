public void characters(char[] ch, int start, int length) throws SAXException { 
	String content = new String(ch, start, length);
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