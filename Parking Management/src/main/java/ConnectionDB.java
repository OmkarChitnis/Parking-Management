import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.lang.*;

public class ConnectionDB {

public static String username="upszsyyyksaxwnso";
public static String password="zvT431LkkJUz3qEf452q";
public static Connection conn = null;


public static Connection connect()
{
	//Properties props = new Properties();
	try
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw";
        conn = DriverManager.getConnection(url,username,password);
        
    }
	
//	 ResourceBundle reader = null;
//	 try{ 
//	     reader = ResourceBundle.getBundle("dbconfig.properties");
//	     Connection conn=DriverManager.getConnection(reader.getString("db.url"),reader.getString("db.username"),reader.getString("db.password"));
//	 }


    catch(Exception e)
    {
    	
        System.out.println(e);
    }
	return conn;        
 }
}