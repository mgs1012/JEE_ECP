package es.miw.web.controllers;

import java.util.List;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;

public class SeleccionarTemaController {
	
private TemaDao temaDao;
	
	public SeleccionarTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}

	public List<Tema> getListaTemas() {
		return temaDao.findAll();

	}

	public Tema getTemaByTitle(String tituloTema){
		return temaDao.getTemaByTitle(tituloTema);
	}
}
