

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A_Logout
 */
@WebServlet("/A_Logout")
public class A_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.html")
            .include(request,
                     response); // This statement includes
                                // link.html in this servlet
 
        // cookie with blank value is used to delete
        // a cookie to sign out the user
        Cookie admin_username = new Cookie("admin","");
    	Cookie admin_password = new Cookie("password","");
       
        // setMaxAge will set the expiration of cookie.
        // This cookie will expire in 0seconds
        admin_username.setMaxAge(0);
        admin_password.setMaxAge(0);
       
        // Attach cookie to response
        response.addCookie(admin_username);
        response.addCookie(admin_password);
 
        //out.println("<h1>You have logged out!</h1>");
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
