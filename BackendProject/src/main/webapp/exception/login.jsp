<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Form 처리</h1>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	int pw2 = Integer.parseInt(pw);
	%>
	<h3>id : <%=id %></h3>
	<h3>pw : <%= ++pw2 %></h3>
	<a href="login.html">back</a>
</body>
</html>