package es.miw.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.miw.persistencia.models.dao.jpa.DaoJpaFactory;
import es.miw.persistencia.models.daos.DaoFactory;
import es.miw.persistencia.models.daos.TemaDao;
import es.miw.persistencia.models.daos.VotoDao;
import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;

public class VerVotacionesController {

	private TemaDao temaDao;

	private VotoDao votoDao;

	private List<Tema> listaTemas;

	public List<Voto> listaVotos;

	public List<NivelEstudios> listaNivelEstudios;

	private Map<String, Integer> lista = new HashMap<String, Integer>();
	
	private Map<NivelEstudios, Double> medias = new HashMap<NivelEstudios, Double>();


	public VerVotacionesController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
	}


	public Map<String, Integer> obtenerNumeroVotos() {

		listaTemas = temaDao.findAll();

		for (Tema t : listaTemas) {
			lista.put(t.getTitulo(), t.getVotos().size());
		}
		return lista;
	}

	public Map<NivelEstudios, Double> medias(){
		
		listaVotos = votoDao.findAll();
		
		double suma_b = 0.0, suma_m = 0.0, suma_s = 0.0, suma_d = 0.0;
		int numV_b = 0, numV_m = 0, numV_s = 0, numV_d = 0;
		
		for(Voto v : listaVotos){
			switch (v.getNivelEstudios()){
			
			case BASICOS:
				numV_b++;
				suma_b = suma_b + v.getValoracion(); 
				break;
			case MEDIOS:
				numV_b++;
				suma_b = suma_b + v.getValoracion(); 
				break;
			case SUPERIORES:
				numV_b++;
				suma_b = suma_b + v.getValoracion(); 
				break;
			case DOCTORADO:
				numV_b++;
				suma_b = suma_b + v.getValoracion(); 
				break;					
			}
			medias.put(NivelEstudios.BASICOS, (suma_b/numV_b));
			medias.put(NivelEstudios.MEDIOS, (suma_m/numV_m));
			medias.put(NivelEstudios.SUPERIORES, (suma_s/numV_s));
			medias.put(NivelEstudios.DOCTORADO, (suma_d/numV_d));		
		}
		return medias;
	}

}
