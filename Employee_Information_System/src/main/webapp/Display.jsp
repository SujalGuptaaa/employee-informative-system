<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import ="com.datamanager.*,java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Registration Data</title>
</head>
<body>
	<%
	DataManager dm = new DataManager();
	ResultSet rs = dm.displayInf();
	while(rs.next())
	{
		out.print("<table>");
			out.print("<tr>");
				out.print("<td>"+rs.getString(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getString(5)+"</td>");
			out.print("</tr>");
		out.print("</table>");
	}
	%>
</body>
</html>