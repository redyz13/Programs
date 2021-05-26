import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ConfermaPagamento extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		Database database = new Database("jdbc:mysql://localhost:3306/database_elaborato", "root", "");
		
		int pin = Integer.parseInt(req.getParameter("pin"));
		
		int codiceCarta = -1;
		int codiceEsercente = -1;
		
		
		HttpSession session = req.getSession(false);
		
		String importo = (String) session.getAttribute("importo");
        String username;
        username = (String) session.getAttribute("username2");
		
		try {
			codiceCarta = database.selectNumeroCarta(pin, pw);
			codiceEsercente = database.selectCodiceEsercente(username, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			pw.println("Errore");
			e.printStackTrace();
		}
		
		if(codiceCarta != -1 && codiceEsercente != -1) {
			try {
				Pagamento pagamento = new Pagamento(Integer.parseInt(importo), codiceCarta, codiceEsercente);
				database.insertPagamento(pagamento);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				database.changeSaldo(codiceCarta, Integer.parseInt(importo), pw);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Movimenti movimento = new Movimenti(Integer.parseInt(importo), Date.valueOf(LocalDate.now()), codiceCarta);
				database.insertMovimento(movimento);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("pages/pagamentoEffettuato.html");
		}
		else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('PIN Errato!');");
			pw.println("location='pages_jsp/paginaEsercenti.jsp';");
			pw.println("</script>");
		}
	}
}