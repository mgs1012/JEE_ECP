package es.miw.web.design.views.beans;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;

public class VerVotacionesView {
	
	private String errorMsg;

    private Tema tema;

    public VerVotacionesView() {
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
        if (this.tema.getId() == 666 && !this.tema.getTitulo().equals("Demonio")) {
            this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
            return "tema";
        } else {
            LogManager.getLogger(AddTemaView.class).debug(
                    "Se accede a la capa de negocio para registrar tema: " + tema);
            //Comunicar con la capa de negocio usando controlador.
            
            return "home";
        }
    }

}
