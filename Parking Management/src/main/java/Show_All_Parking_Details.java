

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show_All_Parking_Details
 */
@WebServlet("/Show_All_Parking_Details")
public class Show_All_Parking_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_All_Parking_Details() {
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
               
        
        //boolean st =false;
        try {

        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw","upszsyyyksaxwnso","zvT431LkkJUz3qEf452q");  
            
            java.sql.Statement stmt = con.createStatement();
            
            String q="Select parking_id, parking_name, parking_location, parking_capacity, parking_used from parkingspots";
            
            ResultSet rs=stmt.executeQuery(q);
            
            if(rs.next()){ 
				do{
				
				//out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
				out.println("ID: " + rs.getInt("parking_id"));
		        out.println("<br> Name: " + rs.getString("parking_name"));
		        out.println("<br> Location: " + rs.getString("parking_location"));
		        out.println("<br> Capacity: " + rs.getInt("parking_capacity"));
		        out.println("<br> Used: " + rs.getInt("parking_used"));
		        out.println("<br><br>");
					
				
				
				}while(rs.next());
			}
			else{
				System.out.println("Record Not Found...");
			}
			con.close();
            
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
