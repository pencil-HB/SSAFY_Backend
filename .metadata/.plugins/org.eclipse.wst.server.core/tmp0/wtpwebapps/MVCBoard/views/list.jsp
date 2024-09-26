<%@page import="com.mvc.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>

<html>
<head>
<title>MVC Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>
	<div class="container text-center">
		<img src="image/f1.jpg" />
		<h1>MVC 게시판</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
<%
	for(Board b : list) { %>
	<tr>
	<td> <%= b.getNum() %></td>
	<td> <a href="board?act=read&num=<%=b.getNum()%>"> <%= b.getTitle() %> </a></td>
	<td> <%= b.getName() %></td>
	<td> <%= b.getWdate() %></td>
	<td> <%= b.getCount() %></td>
	</tr>
<%	
	}
%>
			</tbody>
		</table>
		<br>
	 <a href="/mvc">처음으로</a>
	 <a href="board?act=insertForm">새글쓰기</a>
		<br>
		<br>
		<br>
	</div> 
</body>
</html>



