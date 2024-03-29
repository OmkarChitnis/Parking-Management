import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class A_Login
 */
@WebServlet("/A_Login")
public class A_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_Login() {
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
        
        if(A_Validate.checkUser(user, pass))
        {
        	Cookie admin_username = new Cookie("admin", user);
        	Cookie admin_password = new Cookie("password",pass);
        	admin_username.setMaxAge(60*60*24);
        	admin_password.setMaxAge(60*60*24);
        	response.addCookie(admin_username);
        	response.addCookie(admin_password);
            RequestDispatcher rs = request.getRequestDispatcher("Admin-Home.html");
            rs.forward(request, response);
            
        }
        else
        {
           out.println("<script>alert('Username or password incorrect.');</script>");
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
		//this is a comment
	}

}
