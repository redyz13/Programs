import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Registrati extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		Utente utente = new Utente(req.getParameter("username"), req.getParameter("password"), req.getParameter("nome"), req.getParameter("cognome"));
		
		Database database = new Database("jdbc:mysql://localhost:3306/registrazione", "root", "");
		try {
			database.insertUtente(utente);
			pw.println("Operazione completata.");
			pw.println(utente.toString());
		} catch (SQLException e) {
			pw.println("Operazione fallita");
			pw.print(e.getMessage());
			pw.print(utente.toString());
		}
		
		
	}

}
