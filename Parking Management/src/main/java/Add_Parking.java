

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
 * Servlet implementation class Add_Parking
 */
@WebServlet("/Add_Parking")
public class Add_Parking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Parking() {
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
        String location = request.getParameter("location");
        String capacity = request.getParameter("capacity");
        String used = request.getParameter("used");
        
        
        //boolean st =false;
        try {

        	//Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw","upszsyyyksaxwnso","zvT431LkkJUz3qEf452q");  
            
        	ConnectionDB.connect();
        	Connection con = ConnectionDB.conn;
        	
            PreparedStatement ps = con.prepareStatement("insert into parkingspots (parking_id, parking_name, parking_location, parking_capacity, parking_used) VALUES (?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, location);
            ps.setString(4, capacity);
            ps.setString(5, used);
            
            ps.executeUpdate();
            out.println("Parking Added Successfully");
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
