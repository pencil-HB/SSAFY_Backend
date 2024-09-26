<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException, java.sql.Statement"%>

<%!String driver = "com.mysql.cj.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/tommydb?characterEncoding=UTF-8&serverTimezone=UTC";%>
<%!String user = "tommy";%>
<%!String password = "lion";%>
<%!String query = "select * from customer";%>

<%!public void jspInit() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
}
%>
<%
//2. Connection 생성 - network 연결
Connection con = DriverManager.getConnection(url, user, password);

// 3.Statement 생성
Statement stat = con.createStatement();

// 4.Query 실행
ResultSet rs = stat.executeQuery(query);
%>

<html><body>
<table border=1>
<tr><th>num</th><th>name</th></tr>

<%
while(rs.next() == true) {
	String num = rs.getString(1);
	String name = rs.getString(2);
%>
	<tr>
	<td><%=num %></td>	
	<td><a href="CustomerDetail.jsp?num=<%=num %>"><%=name %></a></td>
	</tr>
<% } %>

</table>
<a href="insert.html">고객 추가</a>
</body></html>

<%
	rs.close();
	stat.close();
	con.close();
%>