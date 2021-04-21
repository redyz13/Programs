import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MioBuongiono extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html><html>");

		out.println("<head>");
		out.println("<meta charset=\"UTF-8\" />");

		out.println("<title>LISTA LIBRI</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		/*
		 * out.println("<h1>CIAO A TUTTI</h1>"); out.println("<h1>COME STATE ?</h1>");
		 * out.println("<h1>OK TUTTI HANNO CAPITO :D</h1>");
		 */

		try {
			pubblicaDati(out);
		} catch (SQLException e) {
			// Errore
		}

		out.println("</body>");
		out.println("</html>");
	}

	public void pubblicaDati(PrintWriter out) throws SQLException {

		String jdbcURL = "jdbc:mysql://localhost:3306/java-libreria-mysql";
		String jdbcUsername = "root";
		String jdbcPassword = "";
		Connection jdbcConnection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			out.println("<p> Errore caricamento driver </p>");
			out.println("<p> " + e.toString() + " </p> ");
		}

		try {
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			out.println("<p> Connessione al database fallita </p>");
			out.println("<p> " + e.toString() + " </p> ");
			out.println("<p> " + e.getMessage() + "</p>");
		}

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM book"); //Restituisce
		
		int id;
		String titolo;
		String autore;
		double prezzo;
		
		out.println("<table>");
			out.println("<tr>");
				out.println("<td> id </td>");
				out.println("<td> titolo </td>");
				out.println("<td> autore </td>");
				out.println("<td> prezzo </td>");
			out.println("</tr>");
		while (resultSet.next()) {
			id = resultSet.getInt("book_id");
			titolo = resultSet.getString("title");
			autore = resultSet.getString("author");
			prezzo = resultSet.getFloat("price");
			
			out.println("<tr>");
			out.println("<td>" + id + "</td>");
			out.println("<td>" + titolo + " </td>");
			out.println("<td>" + autore +" </td>");
			out.println("<td>" + prezzo + "</td>");
			out.println("</tr>");
			
			//out.println("<p> titolo: " + titolo + "</p>");
		}
		
		out.println("</table>");
	}
}