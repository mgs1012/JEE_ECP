package es.miw.web.design.views.beans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.VerVotacionesController;

@ManagedBean
public class VerVotacionesView {

	private String errorMsg;

	private Map<String, Integer> numVotosTema;

	private Map<NivelEstudios, Double> mediasVotos;

	private VerVotacionesController verController;

	public VerVotacionesView() {
		verController = new VerVotacionesController();
		numVotosTema = new HashMap<String, Integer>();
		mediasVotos = new HashMap<NivelEstudios, Double>();
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

	public void update() {
		numVotosTema = verController.obtenerNumeroVotos();
		mediasVotos = verController.medias();

	}

	public String process() {
		LogManager.getLogger(VerVotacionesView.class).debug(
				"Se accede a la capa de negocio para visualizar votaciones: ");

		numVotosTema = verController.obtenerNumeroVotos();
		mediasVotos = verController.medias();

		return "verVotaciones";
	}
}
