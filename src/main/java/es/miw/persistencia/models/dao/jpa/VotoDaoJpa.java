package es.miw.persistencia.models.dao.jpa;

import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao{
	
	TemaDao temaDao;
    
	public VotoDaoJpa() {
		super(Voto.class);
	}

	public void deleteById(int id){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		temaDao.deleteById(id);
	}


}
