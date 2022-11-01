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
        HttpSession sess = request.getSession();
    	sess.setAttribute("username", user);
    	sess.setAttribute("password", pass);
    	Cookie c = new Cookie("name", user);
    	Cookie cpass = new Cookie("pass",pass);
    	response.addCookie(c);
    	response.addCookie(cpass);
        out.println("Welcome");
      }
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
