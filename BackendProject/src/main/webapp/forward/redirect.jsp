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
	
	if(id.equals("tommy") && pw.equals("1234")) {
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>