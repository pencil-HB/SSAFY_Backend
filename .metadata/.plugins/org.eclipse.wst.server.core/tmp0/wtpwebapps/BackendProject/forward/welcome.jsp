<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
<%
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
%>
<h3><%=id %>(<%=pw %>)님, 환영합니다!</h3>
loc:<%= request.getAttribute("code") %>
<a href="login.jsp">Back..</a>
</body>
</html>