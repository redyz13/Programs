import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProvaCookie extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nomeCookie = request.getParameter("nomeCookie");
		String valoreCookie = "1";
		Cookie newCookie = null;
		
		if(nomeCookie != null && valoreCookie != null) {
			newCookie = new Cookie(nomeCookie, valoreCookie);
			response.addCookie(newCookie);
		}
		
		Cookie[] cookies = request.getCookies();
		
		if((cookies != null) && (cookies.length > 0)) {
			for(int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				
				if(cookie.getName().equalsIgnoreCase(request.getParameter("nomeCookie"))) {
					int inc = Integer.parseInt(cookie.getValue()) + 1;
					cookie.setValue(Integer.toString(inc));
				}
				
				out.print("<p><b>Cookie Memorizzato:</b><p>");
				out.print("Nome Cookie: " + cookie.getName() + "</br>");
				out.print("Valore Cookie: " + cookie.getValue() + "</br>");
			}
		}
		
		/*if(aCookie != null) {
			out.print("<p>Ultimo cookie settato<p>");
			out.print("Nome Cookie: " + aCookie.getName() + "</br>");
			out.print("Valore Cookie: " + aCookie.getValue() + "</br>");
		}*/
	}
}