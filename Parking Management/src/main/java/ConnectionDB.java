import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	public static void makeConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw","upszsyyyksaxwnso","zvT431LkkJUz3qEf452q");  
		}
		catch(Exception e){ 
			System.out.println(e);
			}  
		}
}
