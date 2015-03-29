package es.miw.web.controllers;

import java.util.ArrayList;
import java.util.List;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.utils.NivelEstudios;

public class SeleccionarTemaController {
	
private static final int NUM_VALORMAX = 10;

private TemaDao temaDao;

private ArrayList<Integer> listaValoracion;
	
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
	
	public Tema getTemaById(int id){
		return temaDao.read(id);
	}
	
	public List<NivelEstudios> obtenerListaNivelEstudios(){
		
		List<NivelEstudios> listaNivelEstudios = new ArrayList<NivelEstudios>();
		listaNivelEstudios.add(NivelEstudios.BASICOS);
		listaNivelEstudios.add(NivelEstudios.MEDIOS);
		listaNivelEstudios.add(NivelEstudios.SUPERIORES);
		listaNivelEstudios.add(NivelEstudios.DOCTORADO);
		
		return listaNivelEstudios;
	}

	public List<Integer> getListaValoracion() {
		listaValoracion = new ArrayList<Integer>();
		for(int i = 0; i <= NUM_VALORMAX; i++){
			listaValoracion.add(i);
		}		
		return listaValoracion;
	}
}
