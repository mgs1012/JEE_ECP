package es.miw.persistencia.models.dao.jpa;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao{
	

	@Id
    @GeneratedValue
    private Integer id;

    private String ip;

    private NivelEstudios nivelEstudios;

    @ManyToOne
    @JoinColumn
    private Tema tema;
    
	public VotoDaoJpa() {
		super(Voto.class);
	}
 

	@Override
	public void create(Voto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Voto read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
