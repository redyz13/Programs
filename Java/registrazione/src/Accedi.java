import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Accedi extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		Database database = new Database("jdbc:mysql://localhost:3306/registrazione", "root", "");
		try {
			Utente utente = database.selectUtente(req.getParameter("username"), req.getParameter("psw"));
			System.out.println(utente.toString());
		} catch (SQLException e) {
			pw.println("Operazione fallita");
			pw.print(e.getMessage());
		}
		
	}
	
}
