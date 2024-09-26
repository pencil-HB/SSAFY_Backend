package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() Call");
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("userpwd");
		String[] fruits = request.getParameterValues("fruit");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>" + userName + "(" + userPwd + ")님이 좋아하는 과일은 ");
		if(fruits != null)
			out.println(Arrays.toString(fruits) + "입니다.</h2>");
		else
			out.println("없습니다.<br />");
		out.println("<a href=\"/basic_servlet/index.html\">홈으로 go...</a>");
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() Call");
		doGet(request, response);
	}

}
