import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
        HttpSession sess = request.getSession();
    	sess.setAttribute("username", user);
    	sess.setAttribute("password", pass);
    	Cookie c = new Cookie("name", user);
    	Cookie cpass = new Cookie("pass",pass);
    	response.addCookie(c);
    	response.addCookie(cpass);
        out.println("<div class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">\r\n"
        		+ "  <div class=\"toast-header\">\r\n"
        		+ "    <strong class=\"me-auto\">Welcome</strong>\r\n"
        		+ "    <small>now</small>\r\n"
        		+ "    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>\r\n"
        		+ "  </div>\r\n"
        		+ "  <div class=\"toast-body\">\r\n"
        		+ "    Hello USer\r\n"
        		+ "  </div>\r\n"
        		+ "</div>");
      }
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
