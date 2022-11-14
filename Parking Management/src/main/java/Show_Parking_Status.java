

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
 * Servlet implementation class Ground
 */
@WebServlet("/Show_Parking_Status")
public class Show_Parking_Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_Parking_Status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		res.setIntHeader("Refresh", 1);
		PrintWriter out = res.getWriter();  
        res.setContentType("text/html");  
        out.println("<html><body>"); 
        String status;
        try 
        {  
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw","upszsyyyksaxwnso","zvT431LkkJUz3qEf452q");  
              
            java.sql.Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select parking_name, parking_capacity, parking_used, parking_counter from parkingspots");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Parking Name</th><th>Parking Status</th><tr>");  
            while (rs.next()) 
            {  
                String name = rs.getString("parking_name");  
                int capacity = rs.getInt("parking_capacity"); 
                int used = rs.getInt("parking_used");
                int counter = rs.getInt("parking_counter");
                
                if(capacity == used || counter == 1) {
                	status = "Full";
                }
                else {
                	status = "Empty";
                }
          
                out.println("<tr><td>" + name + "</td><td>" + status + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            	e.printStackTrace();  
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
