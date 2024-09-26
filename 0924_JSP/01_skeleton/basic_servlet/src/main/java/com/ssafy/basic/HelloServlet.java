package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
//@WebServlet(urlPatterns = "/hello", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name = "안효인";
	
	public void init() {
		System.out.println("HelloServlet init() Call!!!!");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Call!!!");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello SSAFY !!!</h1>");
		out.println("<h3>안녕 싸피 !!!</h3>");
		out.println("<h5>안녕하세요 " + name + "님~~</h5>");
		out.println("<a href=\"/basic_servlet/index.html\">홈으로 go...</a>");
		out.println("</body>");
		out.println("</html>");
	}


}
