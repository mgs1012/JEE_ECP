package es.miw.web.controllers;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;

public class AddTemaController {
	
	private TemaDao temaDao;
	
	public AddTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoFactory.getFactory().getTemaDao();	
	}
	
	public void addTema(Tema tema){
		temaDao.create(tema);
	}
	

}
