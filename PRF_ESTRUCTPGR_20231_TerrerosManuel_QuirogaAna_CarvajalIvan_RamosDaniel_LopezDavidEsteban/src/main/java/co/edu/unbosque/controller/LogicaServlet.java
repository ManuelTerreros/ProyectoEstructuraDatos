package co.edu.unbosque.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.model.Carta;
import co.edu.unbosque.model.LogicaPrincipal;


/**
 * Servlet implementation class LogicaServlet
 */
@WebServlet("/LogicaServlet")
public class LogicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LogicaPrincipal log;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicaServlet() {
        super();
        // TODO Auto-generated constructor stub
        log = new LogicaPrincipal();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jug1 = request.getParameter("usuario1");
		String jug2 = request.getParameter("usuario2");
		String apren = request.getParameter("apren");
		
		log.setJug1(jug1);
		log.setJug2(jug2);
		log.setJug3(apren);
		
		log.distribuirCartasYJugadores();
		
		request.setAttribute("jug1", jug1);
		request.setAttribute("jug2", jug2);
		request.setAttribute("apren", apren);

		
		
	
		
		String html = "/Juego.jsp";
		RequestDispatcher despechador = getServletContext().getRequestDispatcher(html);
		despechador.forward(request, response);
	}

}
