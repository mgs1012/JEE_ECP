package es.miw.web.design.dispatcher.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.miw.persistencia.models.entities.Tema;
import es.miw.web.design.views.beans.AddTemaView;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/jspFiles/";
    
    private AddTemaView addTemaView;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);

        String view;
        
        switch (action) {
/*        case "votar":
            VotarView votarview = new VotarView();
            votarview.setPersona(new Votar());
            request.setAttribute(action, votarview);
            view = action;
            break;
        case "verVotaciones":
            VotacionesView votacionesView = new VotacionesView();
            request.setAttribute(action, votacionesView);
            view = action;
            break;*/
        case "addTema":
/*            AddTemaView addTemaView = new AddTemaView();
            request.setAttribute(action, addTemaView);*/
            view = action;
            break;
    /*    case "removeTema":
        	RemoveTemaView removeTemaView = new RemoveTemaView();
            request.setAttribute(action, removeTemaView);
            view = action;
            break;*/
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
        case "addTema":
            Tema tema = new Tema();
            //tema.setId(Integer.valueOf(request.getParameter("id")));
            tema.setTitulo(request.getParameter("titulo"));
            tema.setDescripcion(request.getParameter("descripcion"));
            tema.setPregunta(request.getParameter("pregunta"));
            addTemaView = new AddTemaView();
            addTemaView.setTema(tema);
            request.setAttribute(action, addTemaView);
            view = addTemaView.process();
            break;
        /*case "rol":
            RolView rolView = new RolView();
            rolView.setRol(request.getParameter("rol"));
            request.setAttribute(action, rolView);
            view = rolView.process();
            break;*/
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}