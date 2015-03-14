package es.miw.persistencia.models.dao.jpa;

import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {
	
	/*@Id
    private Integer id;
	
    private String titulo;

    private String descripcion;*/
    
	public TemaDaoJpa() {
		super(Tema.class);
	}
    

}