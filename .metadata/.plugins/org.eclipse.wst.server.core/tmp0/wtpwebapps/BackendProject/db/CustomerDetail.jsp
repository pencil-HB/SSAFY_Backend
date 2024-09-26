<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException, java.sql.Statement, java.sql.PreparedStatement"%>

<%!String driver = "com.mysql.cj.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/tommydb?characterEncoding=UTF-8&serverTimezone=UTC";%>
<%!String user = "tommy";%>
<%!String password = "lion";%>
<%!String query = "select * from customer where num=?";%>

<%!public void jspInit() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
}
%>
<%

String num = request.getParameter("num");

//2. Connection 생성 - network 연결
Connection con = DriverManager.getConnection(url, user, password);

// 3.Statement 생성
PreparedStatement stat = con.prepareStatement(query);
stat.setInt(1, Integer.parseInt(num));

// 4.Query 실행
ResultSet rs = stat.executeQuery();
rs.next();

String numGot = rs.getString(1);
String name = rs.getString(2);
String address = rs.getString(3);
%>

<html><body>
<h3>num : <%=numGot %> name : <%=name %> address : <%=address %></h3>
<a href='/Backend/CustomerStart'> 돌아가기 </a>
</body></html>

<%
	rs.close();
	stat.close();
	con.close();
%>