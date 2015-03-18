package es.miw.persistencia.models.daos;

import es.miw.persistencia.models.entities.Tema;

public interface TemaDao extends GenericDao<Tema, Integer> {

	Tema getTemaByName(String tituloTema);
	
	//public void removeTema(String titulo);
		

}


