package myServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Catalogo;
import model.Utente;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String operazione = (String) request.getParameter("operazione");
		 HttpSession session = request.getSession();
		
		 //operazione di login
		if(operazione.equals("login")){
			Utente utente = new Utente();
			String user = request.getParameter("user").toLowerCase();
			String password = request.getParameter("password");
			utente.setUser(user);
			utente.setPassword(password);
			session.setAttribute("utente", utente);
			if(utente.Autenticazione()){
				if(utente.getRuolo().equals("user")){
					Carrello carrello = (Carrello)session.getAttribute("carrello");
					if(carrello==null) carrello = new Carrello();
					String username = utente.getUser();
					carrello.setUsername(username);
					session.setAttribute("carrello", carrello);
					forward(request, response,"/user.jsp");
				}else{
					forward(request, response,"/admin.jsp");
				}
			}else{
				response.setHeader("Cache-Control", "no-cache, no-store");
				response.setHeader("Pragma", "no-cache");
				request.getSession().invalidate();
				forward(request, response,"/index.jsp");
			}
		}//fine operazione login
		
		//operazione di visualizza
		if(operazione.equals("visualizzaLibri")){
			forward(request,response,"/visualizza.jsp");
		}//fine operazione visualizza
		
		
		/*------------------operaioni sul carrello---------------------------------------------------------------*/
		
		//operazione aggiungi al carrello
		if(operazione.equals("aggiungialcarrello")){
			Carrello carrello = (Carrello)session.getAttribute("carrello");
			if(carrello==null) carrello = new Carrello(); 
			int id = Integer.parseInt(request.getParameter("id"));
			carrello.aggiungiLibro(id);
			session.setAttribute("carrello", carrello);
			forward(request,response,"/carrello.jsp");
		}//fine operazione aggiungi al carrello
		
		//operazione rimuovi dal carrello
		if(operazione.equals("rimuovi_carrello")){
			Carrello carrello = (Carrello)session.getAttribute("carrello");
			if(carrello==null) carrello = new Carrello(); 
			int id = Integer.parseInt(request.getParameter("id"));
			carrello.rimuoviLibro(id);
			session.setAttribute("carrello", carrello);
			forward(request,response,"/user.jsp");
		}//fine operazione rimuovi dal carrello
		if(operazione.equals("compra")){
			Carrello carrello = (Carrello)session.getAttribute("carrello");
			if(carrello==null) carrello = new Carrello(); 
			carrello.compra();
			session.setAttribute("carrello", carrello);
			forward(request,response,"/prenotazione.jsp");
		}
		if(operazione.equals("rimuovi_pre")){
			int codice = Integer.parseInt(request.getParameter("cod"));
			Utente utente=(Utente)session.getAttribute("utente");
			Carrello carrello = (Carrello)session.getAttribute("carrello");
			if(carrello==null)
				carrello = new Carrello();
			String username = utente.getUser();
			carrello.rimuoviPrenotazioni(codice,username);
			session.setAttribute("carrello", carrello);
			forward(request, response, "/prenotazione.jsp");
		}
		
		if(operazione.equals("conferma_condegna")){
			int cod = Integer.parseInt(request.getParameter("cod"));
			Carrello carrello = (Carrello)session.getAttribute("carrello");
			if(carrello==null)
				carrello = new Carrello();
			carrello.confermaConsegna(cod);
			session.setAttribute("carrello", carrello);
			forward(request, response, "/prenotazione.jsp");
		}
				
		/*-----------------fine operazione sul carrello-----------------------------------------------------------*/
			
		
		/*-----------------operazioni di amministratore-----------------------------------------------------------*/
		
		if(operazione.equals("inserisciLibro")){
			Catalogo catalogo = new Catalogo();
			String titolo = (String)request.getParameter("titolo");
			String autore = (String)request.getParameter("autore");
			Double prezzo = Double.parseDouble((String)request.getParameter("prezzo"));
			catalogo.inserisciLibro(titolo, autore, prezzo);
			request.setAttribute("catalogo", catalogo);
			forward(request,response,"/admin.jsp");
		}
		if(operazione.equals("rimuovi_libro")){
			Catalogo catalogo = new Catalogo();
			int id = Integer.parseInt(request.getParameter("id"));
			catalogo.rimuoviLibro(id);
			forward(request,response,"/admin.jsp");
		}
		if(operazione.equals("modificalibro")){
			Catalogo catalogo = new Catalogo();
			int id = Integer.parseInt(request.getParameter("id"));
			String titolo = (String)request.getParameter("titolo");
			String autore = (String)request.getParameter("autore");
			Double prezzo = Double.parseDouble((String)request.getParameter("prezzo"));
			catalogo.modificaLibro(id, titolo, autore, prezzo);
			forward(request,response,"/admin.jsp");
		}
		if(operazione.equals("evadi_pre")){
			Catalogo catalogo = new Catalogo();
			int codice = Integer.parseInt(request.getParameter("cod"));
			catalogo.evadiOrdine(codice);
			forward(request,response,"/prenotazioni.jsp");
		}
		if(operazione.equals("rimuovi_pre_admin")){
			Catalogo catalogo = new Catalogo();
			int cod = Integer.parseInt(request.getParameter("cod"));
			catalogo.rimuoviPrenotazioni(cod);
			forward(request, response, "/prenotazioni.jsp");
		}
		
		/*-----------------fine operazioni di amministratore------------------------------------------------------*/
		if(operazione.equals("search")){
			Catalogo catalogo = new Catalogo();
			String titolo = request.getParameter("titolo");
			String autore = request.getParameter("autore");
			catalogo.search(titolo.toLowerCase(), autore.toLowerCase());
			request.setAttribute("catalogo", catalogo);
			forward(request,response,"/visualizzaCerca.jsp");
		}
		
		if(operazione.equals("logout")){
			response.setHeader("Cache-Control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) 
		       throws ServletException, IOException
		    {
		        ServletContext sc = getServletContext();
		        RequestDispatcher rd = sc.getRequestDispatcher(page);
		        rd.forward(request,response);
		  }
}
