<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--  ���� ó�� �������� �ݵ�� �Ʒ� �Ӽ��� ������ �� --%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���� �߻�</h1>
���� ����: <%=exception.getClass().getSimpleName() %> <br>
���� �޼���: <%=exception.getMessage() %>
</body>
</html>