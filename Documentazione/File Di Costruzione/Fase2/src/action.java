Timbratura tempTimb = new Timbratura();
...
...
...
DBHandler.getEntityManager().getTransaction().begin();
DBHandler.getEntityManager().persist(tempTimb);
DBHandler.getEntityManager().getTransaction().commit();