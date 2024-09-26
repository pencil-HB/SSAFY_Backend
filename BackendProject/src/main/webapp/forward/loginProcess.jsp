<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Form 처리</h1>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	request.setAttribute("code", "london");
	
	if (id.equals("tommy") && pw.equals("1234")) {
	%>
	<jsp:forward page="welcome.jsp">
		<jsp:param value="<%=id %>" name="id"/>
		<jsp:param value="<%=pw %>" name="pw"/>
	</jsp:forward>
	<% } else { %>
	<jsp:forward page="login.jsp"/>
	<% } %>
	<a href="login.html">back</a>
</body>
</html>