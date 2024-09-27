<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>session 확인</h1>
<%-- 1.session에 저장된 값 꺼내서 출력 
	 2.링크 걸어서 sessionDelete.jsp로 넘어가기
--%>

<%
String id = (String)session.getAttribute("id");
String pw = (String)session.getAttribute("pw");
ArrayList<String> color = (ArrayList<String>)session.getAttribute("color");
%>
안녕하세요? <%=id %>님! 패스워드는 <%=pw %> 입니다앙

<h3>list 내용</h3>
<%
for(String s : color) {
%>
	<%=s %> <hr>
<%}
%>

<a href="sessionDelete.jsp">sessionDelete.jsp</a>

</body>
</html>