<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>session 값 삭제</h1>
<%-- 1.세션에 저장되어 있는 값 삭제
	 2. 링크걸어 login.jsp, check.jsp로 넘어가기
--%>
<%
	session.setAttribute("id", null);
	session.setAttribute("pw", null);
%>

<a href="login.jsp">login.jsp</a>
<a href="sessionCheck.jsp">sessionCheck.jsp</a>

</body>
</html>