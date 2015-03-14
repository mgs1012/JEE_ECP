package es.miw.web.design.views.beans;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.web.controllers.AddTemaController;

public class AddTemaView {
	
	private String errorMsg;

    private Tema tema;
    
    private AddTemaController addController;

    public AddTemaView() {
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


    public String process() {
        if (this.tema.getTitulo() == "" || this.tema.getPregunta() == "") {
            this.errorMsg = "No se aceptan temas con nombre o con pregunta vac�a.";
            return "tema";
        } else {
            LogManager.getLogger(AddTemaView.class).debug(
                    "Se accede a la capa de negocio para registrar tema: " + tema);
            //Comunicar con la capa de negocio usando controlador.
            
            
            return "home";
        }
    }

}
