import java.sql.*;
import java.lang.*;

public class ConnectionDB {

public static String username="upszsyyyksaxwnso";
public static String password="zvT431LkkJUz3qEf452q";
public static Connection conn = null;


public static Connection connect()
{
    try
    {
        Class.forName("com.mysql.jdbc.Driver");  
        String url="jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw";
        conn = DriverManager.getConnection(url,username,password);
        
    }

    catch(Exception e)
    {
    	
        System.out.println(e);
    }
	return conn;        
 }
}