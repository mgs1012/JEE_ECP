package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.web.controllers.RemoveTemaController;

public class RemoveTemaView {

	private String errorMsg;

	private int codigo;

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
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void update() {

		listaTemas = new ArrayList<Tema>();
		listaTemas = removeController.getListaTemas();
		// listaTemas.addAll( votarController.getListaTemas());

		LogManager.getLogger(RemoveTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar temas.");

	}

	public String process() {

		if (this.codigo != 666){
			this.errorMsg = "Código de autenticación no válido! Inténtelo de nuevo.";
			return "removeTema";
		} else {
			
			removeController.removeTemaById(tema.getId());
			// Comunicar con la capa de negocio usando controlador.
			LogManager.getLogger(RemoveTemaView.class).debug(
					"Se accede a la capa de negocio para eliminar tema seleccionado: "
							+ tema);
			return "home";
		}
	}

}
