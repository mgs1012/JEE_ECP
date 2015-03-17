package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.SeleccionarTemaController;

public class SeleccionarTemaView {
	
	private String errorMsg;

	private Tema tema;
	
	private List<Tema> listaTemas;
	
	private SeleccionarTemaController seleccionarTemaController;


	public SeleccionarTemaView() {
		seleccionarTemaController = new SeleccionarTemaController();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public void update() {

		listaTemas = new ArrayList<Tema>();
		listaTemas = seleccionarTemaController.getListaTemas();

		LogManager.getLogger(VotarView.class).debug(
				"Se accede a la capa de negocio para recuperar temas.");

	}

	public String process() {
		//seleccionarTemaController
		// Comunicar con la capa de negocio usando controlador.
		LogManager.getLogger(SeleccionarTemaView.class).debug(
				"Se accede a la capa de negocio para eliminar tema seleccionado: "
						+ tema);
		
		
		return "votar";
	}
}