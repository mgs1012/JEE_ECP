package es.miw.web.design.views.beans;

import es.miw.persistencia.models.entities.Voto;

public class VotarView {
	
	private String errorMsg;

    private Voto voto;

    private String[] roles;

    public PersonaView() {
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void update() {
        LogManager.getLogger(PersonaView.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
        this.roles = new String[] {"uno", "dos", "tres"};
    }

    public String process() {
        if (this.persona.getId() == 666 && !this.persona.getNombre().equals("Demonio")) {
            this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
            return "persona";
        } else {
            LogManager.getLogger(PersonaView.class).debug(
                    "Se accede a la capa de negocio para registrar persona: " + persona);
            return "home";
        }
    }