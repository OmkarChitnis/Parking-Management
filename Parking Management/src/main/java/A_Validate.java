import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class A_Validate {
	public static boolean checkUser(String user,String pass) 
    {
        boolean st =false;
        try {

        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw","upszsyyyksaxwnso","zvT431LkkJUz3qEf452q");  
            PreparedStatement ps = con.prepareStatement("select * from admin where a_username=? and a_password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }
}
