<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
public void redirecttouserhome(HttpServletRequest req,HttpServletResponse resp)throws Exception{
	resp.sendRedirect("u_home.html");
}
public void redirecttoadminhome(HttpServletRequest req,HttpServletResponse resp)throws Exception{
	resp.sendRedirect("a_home.html");
}
%>
<%
response.setContentType("text/html");
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingmanagement","root","Stormbreaker0811");
	String user_query = "SELECT U_USERNAME FROM USER;";
	String admin_query = "SELECT A_USERNAME FROM ADMIN;";
	Cookie[] c = request.getCookies();
	if(c!=null){
		for(int i=0;i<c.length;i++){
	String cookie_name = c[i].getName();
	String cookie_value = c[i].getValue();
	out.println("<script>console.log("+cookie_name+");console.log("+cookie_value+");</script>");
	if(cookie_name.equals("user")){
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(user_query);
		while(rs.next()){
			String username = rs.getString("U_USERNAME");
			if(username.equals(cookie_value)){
				redirecttouserhome(request,response);
			}
		}
	}else if(cookie_name.equals("admin")){
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(admin_query);
		while(rs.next()){
			String username = rs.getString("A_USERNAME");
			if(username.equals(cookie_value)){
				redirecttoadminhome(request,response);
			}
		}
	}
		}
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
<form action="u_login.html">
    <input type="submit" value="User Login" />
</form>

<form action="a_login.html">
    <input type="submit" value="Admin Login" />
</form>

</body>
</html>