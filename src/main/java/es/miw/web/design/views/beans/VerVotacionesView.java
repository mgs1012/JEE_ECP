package es.miw.web.design.views.beans;

import java.util.Map;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.VerVotacionesController;

public class VerVotacionesView {

	private String errorMsg;

	private Map<String, Integer> numVotosTema;
	
	private Map<NivelEstudios, Double> mediasVotos;

	private VerVotacionesController verController;

	public VerVotacionesView() {
		verController = new VerVotacionesController();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Map<String, Integer> getNumVotosTema() {
		return numVotosTema;
	}

	public void setNumVotosTema(Map<String, Integer> numVotosTema) {
		this.numVotosTema = numVotosTema;
	}
	
	public Map<NivelEstudios, Double> getMediasVotos() {
		return mediasVotos;
	}

	public void setMediasVotos(Map<NivelEstudios, Double> mediasVotos) {
		this.mediasVotos = mediasVotos;
	}


/*	
	public void update() {
		//numVotosTema = new HashMap<String, Integer>();
		
		numVotosTema = verController.obtenerNumeroVotos();
		
		mediasVotos = new HashMap<NivelEstudios, Double>();
		
		votos = new ArrayList<Voto>();
	}
*/
	public String process() {
		// Comunicar con la capa de negocio usando controlador.

		LogManager.getLogger(VerVotacionesView.class).debug(
				"Se accede a la capa de negocio para visualizar votaciones: ");
		
		numVotosTema = verController.obtenerNumeroVotos();
		System.out.println("El mapa que llega es: " + verController.medias());
		mediasVotos = verController.medias();
		
		return "verVotaciones";
	}
}
