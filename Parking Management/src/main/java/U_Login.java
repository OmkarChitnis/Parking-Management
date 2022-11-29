

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/U_Login")
public class U_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public U_Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if(U_Validate.checkUser(user, pass))
        {
        	Cookie user_cookie = new Cookie("user",user);
        	Cookie pass_cookie = new Cookie("pass",pass);
        	user_cookie.setMaxAge(60*60*60*24);
        	pass_cookie.setMaxAge(60*60*60*24);
        	response.addCookie(user_cookie);
        	response.addCookie(pass_cookie);
        	RequestDispatcher rs = request.getRequestDispatcher("u_home.html");
            rs.forward(request, response);
        }
        else
        {
           //out.println("<div class='not_found card-header' style='width:30rem; color: #E31A1A; justify-content: center; display: inline-block; text-align: center; align-items: center;'>Username or Password incorrect</div>");
           RequestDispatcher rs = request.getRequestDispatcher("u_login.html");
           rs.include(request, response);
        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
