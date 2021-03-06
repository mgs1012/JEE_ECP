package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.controllers.VotarController;

@ManagedBean
@SessionScoped
public class VotarView {

	private String errorMsg;

	private Tema tema;

	private Voto voto;

	private List<Voto> votos;

	private List<Tema> listaTemas;

	private VotarController votarController;

	private List<NivelEstudios> listaNivelEstudios;


	public VotarView() {
		votarController = new VotarController();
		listaTemas = new ArrayList<Tema>();
		listaNivelEstudios = new ArrayList<NivelEstudios>();
		voto = new Voto();
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

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public Voto getVoto() {
		return voto;
	}

	public List<NivelEstudios> getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(List<NivelEstudios> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}
	
	public String process() {

		votarController.guardarVotacion(voto, tema.getTitulo());
		return "home";

	}
}