<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Spots</title>
</head>
<body>
<form action="ChangeParkingStatus">

<%
PreparedStatement ps = null;
try
{
	ConnectionDB.connect();
	Connection con = ConnectionDB.conn;
	
	String sql = "SELECT * FROM parkingspots";
	ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
%>

<p>Select Parking Name :
<select name = "parking_name">
<%
while(rs.next())
{
String parkingname = rs.getString("parking_name"); 
%>
<option value="<%=parkingname %>"><%=parkingname %></option>
<%
}
%>
</select>
</p>

<%
}
catch(SQLException sqe)
{ 
out.println(sqe);
}
%>
<input type="radio" id="empty" name="parking_status" value="Empty">
<label for="empty">Empty</label><br>
<input type="radio" id="full" name="parking_status" value="Full">
<label for="full">Full</label><br>
<input type="submit" value="Change Status" />
</form>
</body>
</html>