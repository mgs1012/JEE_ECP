package es.miw.persistencia.dao.jdbc;

import java.util.List;

import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao {

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

	public static String sqlToCreateTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEntity(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tema getTemaByTitle(String tituloTema) {
		// TODO Auto-generated method stub
		return null;
	}


	}