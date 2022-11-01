

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class U_Login
 */
@WebServlet("/U_Login")
public class U_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public U_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        if(U_Validate.checkUser(user, pass))
        {
        	HttpSession sess = request.getSession();
        	sess.setAttribute("username", user);
        	sess.setAttribute("password", pass);
        	Cookie c = new Cookie("name", user);
        	Cookie cpass = new Cookie("pass",pass);
        	response.addCookie(c);
        	response.addCookie(cpass);
            RequestDispatcher rs = request.getRequestDispatcher("u_home.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("<div class='not_found' style='width:30rem; color: #E31A1A;'>Username or Password incorrect</div>");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
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
