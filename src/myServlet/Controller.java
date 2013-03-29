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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			Utente u = new Utente();
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			u.setUser(user);
			u.setPassword(password);
			session.setAttribute("utente", u);
			if(u.Autenticazione()){
				if(u.getRuolo().equals("user")){
					forward(request, response,"/user.jsp");
				}else{
					forward(request, response,"/admin.jsp");
				}
			}else{
				forward(request, response,"/index.jsp");
			}
		}//fine operazione login
		
		//operazione di visualizza
		if(operazione.equals("visualizzaLibri")){
			forward(request,response,"/visualizza.jsp");
		}//fine operazione visualizza
		
		//operazione aggiungi al carrello
		if(operazione.equals("aggiungialcarrello")){
			Carrello carrello = (Carrello)session.getAttribute("carrello");
			if(carrello==null) carrello = new Carrello(); //il carrello è vuoto, è nuovo!
			int id = Integer.parseInt(request.getParameter("id"));
			carrello.aggiungiLibro(id);
			System.out.println(carrello.Visualizzacarrello());
			session.setAttribute("carrello", carrello);
			forward(request,response,"/vetrina.jsp");
		}//fine operazione aggiungi al carrello
		
		
		if(operazione.equals("logout")){
			session.invalidate();
		}
		
		
		if(operazione.equals("search")){
			System.out.println("non mi blocco 1");
			Catalogo catalogo = new Catalogo();
			System.out.println("non mi blocco 2");
			String titolo = request.getParameter("titolo");
			System.out.println("non mi blocco 3");
			String autore = request.getParameter("autore");
			System.out.println("non mi blocco 4");
			catalogo.search(titolo, autore);
			System.out.println("non mi blocco 5");
			request.setAttribute("catalogo", catalogo);
			System.out.println("non mi blocco 6");
			forward(request,response,"/visualizzaCerca.jsp");
			System.out.println("non mi blocco 7");
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
