package es.miw.web.controllers;

import java.util.List;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Tema;

public class VotarController {
	
private TemaDao temaDao;

private VotoDao votoDao;
	
	public VotarController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
	}
	
	public List<Tema> getListaTemas(){
		return temaDao.findAll();
	}

	

}
