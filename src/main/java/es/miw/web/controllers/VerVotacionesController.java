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

	private Map<String, Integer> lista;
	private Map<NivelEstudios, Double> medias;

	public VerVotacionesController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
	}

	public Map<String, Integer> obtenerNumeroVotos() {

		lista = new HashMap<String, Integer>();

		listaTemas = temaDao.findAll();

		for (Tema t : listaTemas) {
			lista.put(t.getTitulo(), t.getVotos().size());
		}
		return lista;
	}

	public Map<NivelEstudios, Double> medias() {

		medias = new HashMap<NivelEstudios, Double>();

		listaVotos = votoDao.findAll();

		double suma_b = 0.0, suma_m = 0.0, suma_s = 0.0, suma_d = 0.0;
		int numV_b = 0, numV_m = 0, numV_s = 0, numV_d = 0;

		for (Voto v : listaVotos) {
			switch (v.getNivelEstudios()) {

			case BASICOS:
				numV_b++;
				suma_b = suma_b + v.getValoracion();
				break;
			case MEDIOS:
				numV_m++;
				suma_m = suma_m + v.getValoracion();
				break;
			case SUPERIORES:
				numV_s++;
				suma_s = suma_s + v.getValoracion();
				break;
			case DOCTORADO:
				numV_d++;
				suma_d = suma_d + v.getValoracion();
				break;
			}
		}
		
		if(numV_b == 0){
			medias.put(NivelEstudios.BASICOS, 0.0);
		}
		else{
			medias.put(NivelEstudios.BASICOS, (suma_b / numV_b));
		}
		if(numV_m == 0){
			medias.put(NivelEstudios.MEDIOS, 0.0);
		}
		else{
			medias.put(NivelEstudios.MEDIOS, (suma_m / numV_m));
		}
		if(numV_m == 0){
			medias.put(NivelEstudios.SUPERIORES, 0.0);
		}
		else{
			medias.put(NivelEstudios.SUPERIORES, (suma_s / numV_s));
		}
		if(numV_b == 0){
			medias.put(NivelEstudios.DOCTORADO, 0.0);
		}
		else{
			medias.put(NivelEstudios.DOCTORADO, (suma_d / numV_d));
		}
		
		return medias;
	}

}
