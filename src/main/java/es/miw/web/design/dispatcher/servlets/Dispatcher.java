package es.miw.web.design.dispatcher.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.miw.persistencia.models.entities.Tema;
import es.miw.persistencia.models.entities.Voto;
import es.miw.persistencia.models.utils.NivelEstudios;
import es.miw.web.design.views.beans.AddTemaView;
import es.miw.web.design.views.beans.RemoveTemaView;
import es.miw.web.design.views.beans.SeleccionarTemaView;
import es.miw.web.design.views.beans.VerVotacionesView;
import es.miw.web.design.views.beans.VotarView;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/jspFiles/";

	private AddTemaView addTemaView;

	private RemoveTemaView removeTemaView;

	private VotarView votarView;

	private VerVotacionesView verVotosView;
	
	private SeleccionarTemaView seleccionarTemaView;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;

		switch (action) {
		/*
		 * case "votar": VotarView votarview = new VotarView();
		 * votarview.setPersona(new Votar()); request.setAttribute(action,
		 * votarview); view = action; break; case "verVotaciones":
		 * VotacionesView votacionesView = new VotacionesView();
		 * request.setAttribute(action, votacionesView); view = action; break;
		 */
		case "addTema":
			view = action;
			break;
		case "removeTema":
			removeTemaView = new RemoveTemaView();
			request.setAttribute(action, removeTemaView);
			view = action;
			break;
		case "verVotaciones":
			verVotosView = new VerVotacionesView();
			view = verVotosView.process();
			request.setAttribute(action, verVotosView);
			break;
/*		case "votar":
			votarView = new VotarView();
			request.setAttribute(action, votarView);
			view = action;
			break;*/
		case "seleccionarTema":
			seleccionarTemaView = new SeleccionarTemaView();
			request.setAttribute(action, seleccionarTemaView);
			view = action;
			break;		
		default:
			view = "home";
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		Tema tema;
		Voto voto;
		switch (action) {
		case "addTema":
			tema = new Tema();
			// tema.setId(Integer.valueOf(request.getParameter("id")));
			tema.setTitulo(request.getParameter("titulo"));
			tema.setDescripcion(request.getParameter("descripcion"));
			tema.setPregunta(request.getParameter("pregunta"));
			addTemaView = new AddTemaView();
			addTemaView.setTema(tema);
			request.setAttribute(action, addTemaView);
			view = addTemaView.process();
			break;
		case "removeTema":
			tema = new Tema();
			removeTemaView = new RemoveTemaView();
			tema.setId(Integer.parseInt(request.getParameter("nombreDelTema")));
			removeTemaView.setTema(tema);
			removeTemaView.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			request.setAttribute(action, removeTemaView);
			view = removeTemaView.process();
			break;

		case "votar":
			tema = new Tema();
			voto = new Voto();
			
			voto.setIp(request.getRemoteAddr());
			voto.setNivelEstudios(NivelEstudios.valueOf(request
					.getParameter("nivelEstudios")));
			voto.setValoracion(Integer.valueOf(request
					.getParameter("valoracion")));
			votarView = new VotarView();
			tema.setTitulo(request.getParameter("nombreDelTema"));
			tema.setPregunta(request.getParameter("pregunta"));
			votarView.setTema(tema);
			votarView.setVoto(voto);
			request.setAttribute(action, votarView);
			view = votarView.process();
			break;
		case "seleccionarTema":
			tema = new Tema();
			seleccionarTemaView = new SeleccionarTemaView();	
			tema.setTitulo(request.getParameter("nombreDelTema"));
			System.out.println("Llega del form: " + request.getParameter("nombreDelTema"));
			seleccionarTemaView.setTema(tema);
			request.setAttribute(action, seleccionarTemaView);
			view = seleccionarTemaView.process();
			
		/*case "verVotaciones":
			verVotosView = new VerVotacionesView();
			request.setAttribute(action, verVotosView);
			view = verVotosView.process();*/

		/*
		 * case "rol": RolView rolView = new RolView();
		 * rolView.setRol(request.getParameter("rol"));
		 * request.setAttribute(action, rolView); view = rolView.process();
		 * break;
		 */
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}