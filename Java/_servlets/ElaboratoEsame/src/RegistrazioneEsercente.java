import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrazioneEsercente extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		Esercente esercente = new Esercente(req.getParameter("nome"), req.getParameter("cognome"), req.getParameter("username"), req.getParameter("pword"));
		
		Database database = new Database("jdbc:mysql://localhost:3306/database_elaborato", "root", "");
		
		try {
			database.insertEsercente(esercente);
			resp.sendRedirect("pages/registrazioneEffettuata2.html");
		} catch (SQLException e) {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Operazione fallita!');");
			pw.println("location='pages/esercenti.jsp';");
			pw.println("</script>");
		}
	}
}