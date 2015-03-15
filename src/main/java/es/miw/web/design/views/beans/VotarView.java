package es.miw.web.design.views.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.web.controllers.VotarController;

public class VotarView {
	
	private String errorMsg;
	
	private Tema tema;

    private Voto voto;

    private List<Voto> votos;
    
    private List<Tema> temas;
    
    private VotarController votarController;

    public VotarView() {
    	votarController = new VotarController();
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
    
    public void setVoto(Voto voto){
    	this.voto = voto;
    }

    public void update() {
    	temas = votarController.getListaTemas();
    	
        LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar temas.");
    }

    public String process() {
        if (this.tema.getId() == 666 && !this.tema.getTitulo().equals("Demonio")) {
            this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
            return "voto";
        } else {
            LogManager.getLogger(VotarView.class).debug(
                    "Se accede a la capa de negocio para registrar votacion: " + voto);
            return "home";
        }
    }
}