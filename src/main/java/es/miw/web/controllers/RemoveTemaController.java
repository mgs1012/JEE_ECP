package es.miw.web.controllers;

import java.util.List;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;

public class RemoveTemaController {

	private TemaDao temaDao;

	private VotoDao votoDao;

	public RemoveTemaController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}

	public void removeTema(Tema tema) {
		temaDao.removeEntity(tema);
	}

	public void removeTemaById(int id) {

		if (temaDao.read(id).getVotos() != null) {
			for (Voto v : temaDao.read(id).getVotos()) {
				votoDao.deleteById(v.getId());
			}
		}
		
		temaDao.deleteById(id);
	}
	
	public Tema encontrarTemaById(int id){
		return temaDao.read(id);
		
	}

	public List<Tema> getListaTemas() {
		return temaDao.findAll();
	}

}
