package es.miw.persistencia.models.dao.jpa;

import java.util.List;

import javax.persistence.Id;

import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {
	
	@Id
    private Integer id;
	
    private String titulo;

    private String descripcion;
    
	public TemaDaoJpa() {
		super(Tema.class);
	}


	@Override
	public void create(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tema read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


    

}