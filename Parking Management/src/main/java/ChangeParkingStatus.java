

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeParkingStatus
 */
@WebServlet("/ChangeParkingStatus")
public class ChangeParkingStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeParkingStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int count = 0;
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
		String status = request.getParameter("parking_status");
		String statusFull = "Full";
		
		String name = request.getParameter("parking_name");
		if(status.equals(statusFull)) {
			count=1;
		}
		else {
			count=0;
		}
		
		try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingmanagement","root","mysql");
            
            PreparedStatement ps = con.prepareStatement("update parkingspots set parking_counter=? where parking_name=?");
            ps.setInt(1, count);
            ps.setString(2, name);
            
            ps.executeUpdate();
            out.println("Parking Status Updated Successfully");
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
