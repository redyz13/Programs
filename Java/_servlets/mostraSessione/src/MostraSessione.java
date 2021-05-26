import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessione")
public class MostraSessione extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Crea una sessione se questa non esiste
		HttpSession sessione = request.getSession();
		
		out.print("<h1>Informazioni sulla sessione</h1>");
		out.print("ID Sessione: " + sessione.getId() + "</br>");
		out.print("Data creazione: " + new Date(sessione.getCreationTime()) + "</br>");
		out.print("Data Ultimo accesso: " + new Date(sessione.getLastAccessedTime()) + "</br>");
		
		// Recupera e setta il valore del contatore
		Integer tanti = (Integer) sessione.getAttribute("MostraSessione.contatore");
		
		
		if(tanti == null) {
			//tanti = new Integer(1);
			tanti = Integer.valueOf(1);
			out.print("</br> Ciao </br>");
			out.print("La serverlet è stata eseguita per la prima volta");
		}
		else {
			//tanti = new Integer(tanti.intValue()+1);
			tanti = Integer.valueOf(tanti.intValue()+1);
			out.print("</br> Bentornato </br>");
			out.print("La server è stata eseguita " + tanti + " volte");
		}
		
		sessione.setAttribute("MostraSessione.contatore", tanti);
	}

}