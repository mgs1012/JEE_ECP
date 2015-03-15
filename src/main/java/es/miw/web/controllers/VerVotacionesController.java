package es.miw.web.controllers;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;

public class VerVotacionesController {
	
	private TemaDao temaDao;
	
	private VotoDao votoDao;
	
	public VerVotacionesController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
	}
	
	public void verVotacion(Tema tema, Voto voto){
		//temaDao.read(tema.getId());
		//votoDao.findAll();
		//Tipo nivel de estudios?
		
	}

}
