

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete_Parking
 */
@WebServlet("/Delete_Parking")
public class Delete_Parking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Parking() {
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String nullString = "null";
        try {

        	//Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw","upszsyyyksaxwnso","zvT431LkkJUz3qEf452q");  
            
        	ConnectionDB.connect();
        	Connection con = ConnectionDB.conn;
        	PreparedStatement ps_id = con.prepareStatement("delete from parkingspots where parking_id=?");
            PreparedStatement ps_name = con.prepareStatement("delete from parkingspots where parking_name=?");
        	
        	if(id.equals(nullString) && name.equals(nullString)) {
                out.println("<script type='text/javascript'>"
                		+ "alert('Please enter id and name.');"
                		+ "</script>");
        	}
        	else if(!id.equals(nullString) && !name.equals(nullString)) {
        		ps_id.setString(1, id);
                ps_name.setString(1, name);
        	}
            int countid = ps_id.executeUpdate();
            int countname = ps_name.executeUpdate();
            if(countid>0 || countname>0) {
            	RequestDispatcher rd = request.getRequestDispatcher("deleteparking.html");
            	rd.include(request, response);
            	out.println("<script>alert('Parking Deleted Successfully');</script>");
            }
            else {
            	out.println("Parking Doesn't Exists");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
