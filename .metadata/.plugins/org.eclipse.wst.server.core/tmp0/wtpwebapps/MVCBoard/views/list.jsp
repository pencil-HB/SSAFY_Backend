<%@page import="com.mvc.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container text-center">
		<img src="image/f1.jpg" />
		<h1>MVC 게시판</h1>
		
		<jsp:include page="loginCheck.jsp"/>
		
		<form method="post" action="board?act=search">
            <div class="row g-3 align-items-center">
                <div class="col-auto">
                    <label for="inputPassword6" class="col-form-label">검 색: </label>
                </div>
                <div class="col-auto">
                    <select name="search" class="form-select"
                        aria-label="Default select example">
                        <option value="name">이 름</option>
                        <option value="title">제 목</option>
                    </select>
                </div>
                <div class="col-auto">
                    <input type="text" class="form-control" name="word">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary">검  색</button>
                </div>
            </div>
        </form>

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
			
			<c:forEach items="${requestScope.list }" var="b">
				<tr>
					<td>${b.num}</td>				
					<td><a href="board?act=read&num=${b.num}">${b.title}</a></td>				
					<td>${b.name}</td>				
					<td>${b.wdate}</td>				
					<td>${b.count}</td>				
				</tr>
			</c:forEach>			
			
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



