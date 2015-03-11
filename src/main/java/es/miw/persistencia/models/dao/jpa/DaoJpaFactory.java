package es.miw.persistencia.models.dao.jpa;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.daos.VotoDao;

public class DaoJpaFactory extends DaoFactory{
	
	 private static final String PERSISTENCE_UNIT = "Votaciones";

	    private static EntityManagerFactory entityManagerFactory = Persistence
	            .createEntityManagerFactory(PERSISTENCE_UNIT);

	    public DaoJpaFactory() {
	        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
	    }

	    public static EntityManagerFactory getEntityManagerFactory() {
	        return entityManagerFactory;
	    }

		@Override
		public TemaDao getTemaDao() {
			return  new TemaDaoJpa();
		}

		@Override
		public VotoDao getVotoDao() {
			return  new VotoDaoJpa();
		}


}
