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

public class RegistrazioneTitolare extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		Titolare titolare = new Titolare(req.getParameter("nome"), req.getParameter("cognome"), req.getParameter("username"), req.getParameter("pword"),
				req.getParameter("email"), req.getParameter("indirizzo"));
		
		Database database = new Database("jdbc:mysql://localhost:3306/database_elaborato", "root", "");
		
		
		Carta carta = registraCarta(titolare.getCodiceTitolare());
		
		try {
			database.insertTitolare(titolare);
			database.insertCarta(carta);
			resp.sendRedirect("pages/registrazioneEffettuata.html");
		} catch (SQLException e) {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Operazione fallita!');");
			pw.println("location='pages/utenti.jsp';");
			pw.println("</script>");
		}
		
	}
	
	public Carta registraCarta(int codiceTitolare) {
		RandomGenerator randomGenerator = new RandomGenerator();
		
		String numero = randomGenerator.getNumeroCasuale(20);
		int pin = Integer.parseInt(randomGenerator.getNumeroCasuale(4));
		int ccv = Integer.parseInt(randomGenerator.getNumeroCasuale(3));
		Date dataScadenza = randomGenerator.getDataCasuale();
		Date dataCreazione = Date.valueOf(LocalDate.now());
		int saldo = 0;
		
		Carta carta = new Carta(numero, pin, ccv, dataScadenza, dataCreazione, saldo, codiceTitolare);
		
		return carta;
	}
}