package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.SeleccionarTemaController;

@ManagedBean
@SessionScoped
public class SeleccionarTemaView {

	private String errorMsg;

	private Tema tema;

	private List<Tema> listaTemas;

	private SeleccionarTemaController seleccionarTemaController;

	private List<NivelEstudios> listaNivelEstudios;

	public SeleccionarTemaView() {
		tema = new Tema();
		listaTemas = new ArrayList<Tema>();
		seleccionarTemaController = new SeleccionarTemaController();
		listaNivelEstudios = new ArrayList<NivelEstudios>();
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

	public List<NivelEstudios> getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(List<NivelEstudios> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}

	public void update() {
		listaTemas = seleccionarTemaController.getListaTemas();
		listaNivelEstudios = seleccionarTemaController
				.obtenerListaNivelEstudios();
	}

	public String process() {
		tema = seleccionarTemaController.getTemaByTitle(tema.getTitulo());
		return "votar";
	}
}