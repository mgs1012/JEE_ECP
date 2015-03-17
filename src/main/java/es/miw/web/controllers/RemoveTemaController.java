package es.miw.web.controllers;

import java.util.List;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;

public class RemoveTemaController {
	
	private TemaDao temaDao;
	
	public RemoveTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();	
	}
	
	public void removeTema(Tema tema){
		temaDao.removeEntity(tema);
	}
	
	public void removeTemaById(int id){
		temaDao.deleteById(id);
		
	}
	
	public List<Tema> getListaTemas(){
		return temaDao.findAll();
	}

}
