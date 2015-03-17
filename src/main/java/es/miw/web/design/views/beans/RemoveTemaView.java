package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.RemoveTemaController;

public class RemoveTemaView {

	private String errorMsg;

	private Tema tema;

	private RemoveTemaController removeController;
	
	private List<Tema> listaTemas;

	public RemoveTemaView() {
		removeController = new RemoveTemaController();
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
		listaTemas = removeController.getListaTemas();
		// listaTemas.addAll( votarController.getListaTemas());

		LogManager.getLogger(RemoveTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar temas.");

	}

	public String process() {
		/*if (this.tema.getId() == 666
				&& !this.tema.getTitulo().equals("Demonio")) {
			this.errorMsg = "Sólo se acepta el nombre 'Demonio' y su id válido.";
			return "tema";
		} else {
			// Comunicar con la capa de negocio usando controlador.
			removeController.removeTema(tema);
			LogManager.getLogger(RemoveTemaView.class).debug(
					"Se accede a la capa de negocio para eliminar tema seleccionado: "
							+ tema);

			return "home";
		}*/
		LogManager.getLogger(RemoveTemaView.class).debug(
				"Se accede a la capa de negocio para eliminar tema seleccionado: "
						+ tema);

		removeController.removeTema(tema);
		return "home";
	}
}
