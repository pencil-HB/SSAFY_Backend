<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"import="java.util.*,java.io.*" %>
<% 
	String userName = request.getParameter("username");	
	String userPwd = request.getParameter("userpwd");	
	String[] fruits = request.getParameterValues("fruit");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>
	<%=userName %>(<%=userPwd %>)님이 좋아하는 과일은
	<%
	if(fruits != null) {
	%>
	<%= Arrays.toString(fruits) %>
	<%
	} else { %>
	<%
	}
	%>
	
	</h2>
</body>
</html>