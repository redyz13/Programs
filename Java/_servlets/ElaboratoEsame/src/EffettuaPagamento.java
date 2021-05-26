import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EffettuaPagamento extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		Database database = new Database("jdbc:mysql://localhost:3306/database_elaborato", "root", "");
		HttpSession sessione = req.getSession(false);
		
		String numeroCarta = req.getParameter("numeroCarta");
		int importo = Integer.parseInt(req.getParameter("importo"));
		
		int saldo = -1;
		
		if(importo > 0) {
			try {
				saldo = database.selectSaldo(numeroCarta, pw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				saldo = database.selectSaldo(numeroCarta, pw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(saldo > 0 && saldo >= importo) {
				sessione.setAttribute("importo", Integer.toString(importo));
				resp.sendRedirect("pages/confermaPagamento.html");
			}
			else {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Saldo insufficiente o numero di carta non trovato!');");
				pw.println("location='pages_jsp/paginaEsercenti.jsp';");
				pw.println("</script>");
			}
		}
		else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Importo inserito non corretto!');");
			pw.println("location='pages_jsp/paginaEsercenti.jsp';");
			pw.println("</script>");
		}
	
	}
}