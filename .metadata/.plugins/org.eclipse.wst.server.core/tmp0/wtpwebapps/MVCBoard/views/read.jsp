<%@page import="com.mvc.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
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
<% Board b = (Board) request.getAttribute("b"); %>
	<div class="container text-center">
	<img src="image/f2.jpg"/>
		<h1>글읽기</h1>		
		<p>
			
			<table class="table table-bordered"><TR>
				<TH>NUM</TH>
				<TD><%=b.getNum() %></TD>
				
				<Th>NAME</TH>
				<TD><%=b.getName() %></TD>
			</TR>
			<TR>
				<TH>DATE</TH>
				<TD><%=b.getWdate() %></TD>
				
				<TH>COUNT</TH>
				<TD><%=b.getCount() %></TD>
			</TR>
			<TR>
				<TH>TITLE</TH>
				<TD COLSPAN=3><%=b.getTitle() %></TD>
			</TR>
			<TR>
				<TH>CONTENT</TH>
				<TD COLSPAN=3>
				<textarea readonly class="form-control" rows="5" id="comment" name="comment">			
				<%=b.getContent() %>
				</textarea>
			</td>
			</div>
			</TR>
		</TABLE>
	 <a href="/mvc/board?act=list">글목록</a>
	 <a href="/mvc">처음으로</a>	 
	  
	<br><br>

	</div>
</body>
</html>






