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
		
		int value = 0;
		try {
			value = database.selectUtente(req.getParameter("username"), req.getParameter("psw"), pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("<html> <head> </head> <body> ");
		if(value == 0) {
			pw.print("<p> Sei connesso </p>");
		} else if (value == 1) {
			pw.print("<p> Nome utente non registrato </p>");
		} else {
			pw.print("<p> Password non corretta </p>");
		}
	}
	
}
