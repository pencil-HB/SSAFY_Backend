<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"import="java.util.Date,java.io.*" %>
<%!String name = "김혜빈";
	Date date = new Date();
	InputStream is = null;

	public void init() {
		System.out.println("init method");
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello SSAFY</h1>
	<h3>안녕 싸피!</h3>
	<h5><%=name%>님 안녕하세요.
	</h5>
	<a href="/basic_jsp/index.jsp">홈으로</a>
</body>
</html>