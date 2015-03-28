package es.miw.web.design.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.web.controllers.RemoveTemaController;

@SessionScoped
@ManagedBean
public class RemoveTemaView {

	private String errorMsg;

	private int codigo;
	
	private static final int CODIGO_AUTORIZACION = 666;

	private Tema tema;

	private RemoveTemaController removeController;

	private List<Tema> listaTemas;

	public RemoveTemaView() {
		removeController = new RemoveTemaController();
		tema = new Tema();
		listaTemas = new ArrayList<Tema>();
		listaTemas = removeController.getListaTemas();

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

		if (this.codigo != CODIGO_AUTORIZACION){
			this.errorMsg = "Código de autenticación no válido! Inténtelo de nuevo.";
			System.out.println("ENTRA PROCESS ERROR");
			System.out.println("El tema " + tema.getTitulo() + "tiene id:" + tema.getId());
			
			System.out.println("cod erroneo :" + this.codigo);
			return "removeTema";
		} else {
			System.out.println("El tema " + tema.getTitulo() + "tiene id:" + tema.getId());

			removeController.removeTemaById(tema.getId());
			return "home";
		}
	}

}
