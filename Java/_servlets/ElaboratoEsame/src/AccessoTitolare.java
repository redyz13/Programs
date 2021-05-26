import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AccessoTitolare extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		Database database = new Database("jdbc:mysql://localhost:3306/database_elaborato", "root", "");
		HttpSession sessione = req.getSession();
		
		int value = 0;
		
		try {
			value = database.selectTitolare(req.getParameter("username"), req.getParameter("pword"), pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(value == 0) {
			sessione.setAttribute("username", req.getParameter("username"));
			resp.sendRedirect("pages_jsp/login.jsp");
		} else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Username o password non corretti!');");
			pw.println("location='pages/utenti.jsp';");
			pw.println("</script>");
		}
	}
}