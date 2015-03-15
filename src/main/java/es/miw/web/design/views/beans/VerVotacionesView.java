package es.miw.web.design.views.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.web.controllers.VerVotacionesController;

public class VerVotacionesView {
	
	private String errorMsg;

    private Tema tema;
    
    private Voto voto;
    
    private List<Voto> votos;
    
	private VerVotacionesController verController;
    
    public VerVotacionesView() {
    	verController = new VerVotacionesController();
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
    public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}


    public String process() {
       
            //Comunicar con la capa de negocio usando controlador.
            verController.verVotacion(tema, voto);

            LogManager.getLogger(VerVotacionesView.class).debug(
                    "Se accede a la capa de negocio para visualizar votaciones: " + voto);
            
            return "home";
    }

}
