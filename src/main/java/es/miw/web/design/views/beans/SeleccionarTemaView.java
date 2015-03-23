package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.SeleccionarTemaController;

@ManagedBean
public class SeleccionarTemaView {
	
	private String errorMsg;

	private Tema tema;
	
	private List<Tema> listaTemas;
	
	private SeleccionarTemaController seleccionarTemaController;

	private List<NivelEstudios> listaNivelEstudios;


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
	
	public List<NivelEstudios> getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(List<NivelEstudios> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}


	public void update() {

		listaTemas = new ArrayList<Tema>();
		listaTemas = seleccionarTemaController.getListaTemas();

		LogManager.getLogger(VotarView.class).debug(
				"Se accede a la capa de negocio para recuperar temas.");
		

		listaNivelEstudios = new ArrayList<NivelEstudios>();
		listaNivelEstudios.add(NivelEstudios.BASICOS);
		listaNivelEstudios.add(NivelEstudios.MEDIOS);
		listaNivelEstudios.add(NivelEstudios.SUPERIORES);
		listaNivelEstudios.add(NivelEstudios.DOCTORADO);

	}

	public String process() {

		// Comunicar con la capa de negocio usando controlador.
		LogManager.getLogger(SeleccionarTemaView.class).debug(
				"Se accede a la capa de negocio para eliminar tema seleccionado: "
						+ tema);
		
		tema = seleccionarTemaController.getTemaByTitle(tema.getTitulo());
		
		return "votar";
	}
}