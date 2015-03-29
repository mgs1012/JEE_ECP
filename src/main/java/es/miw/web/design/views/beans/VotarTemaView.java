package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.SeleccionarTemaController;
import es.miw.web.controllers.VotarController;

@ManagedBean
@SessionScoped
public class VotarTemaView {

	private String errorMsg;

	private Tema tema;

	private Voto voto;

	private List<Tema> listaTemas;

	private SeleccionarTemaController seleccionarTemaController;

	private VotarController votarController;

	private List<NivelEstudios> listaNivelEstudios;

	private List<Integer> listaValoracion;

	public VotarTemaView() {
		tema = new Tema();
		// voto = new Voto();
		seleccionarTemaController = new SeleccionarTemaController();
		votarController = new VotarController();
		listaTemas = new ArrayList<Tema>();
		listaNivelEstudios = new ArrayList<NivelEstudios>();
		listaValoracion = new ArrayList<Integer>();
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
	
	public List<Integer> getListaValoracion() {
		return listaValoracion;
	}

	public void setListaValoracion(List<Integer> listaValoracion) {
		this.listaValoracion = listaValoracion;
	}


	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	@PostConstruct
	public void update() {
		System.out.println("UPDATE SELECCIONAR TEMA");
		listaTemas = seleccionarTemaController.getListaTemas();
		listaNivelEstudios = seleccionarTemaController
				.obtenerListaNivelEstudios();
		listaValoracion = seleccionarTemaController.getListaValoracion();

	}  

	public String process() {
		String view = "";
		System.out.println("PROCESSSSS SELECCIONAR TEMA");

		if (tema.getTitulo() != null && voto.getId() == null) {
			tema = seleccionarTemaController.getTemaById(tema.getId());
			System.out.println("me meto en el IF");

			view = "votarTema";

		}

		// tema = seleccionarTemaController.getTemaByTitle(tema.getTitulo());
		else {
			votarController.guardarVotacion(voto, tema.getTitulo());
			view = "home";

		}

		return view;
	}
}