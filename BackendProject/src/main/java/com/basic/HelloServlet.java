package com.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hi")
@WebServlet(urlPatterns = {"/hi", "/hello", "/HelloServlet"})
public class HelloServlet extends HttpServlet {
    
	//서비스 메소드 : 클라이언트로부터 요청이들어왔을 때 응답을 만들어내는 메소드.
	//request : 클라이언트에서 서버로 들어오는 '요청'과 관련된 모든 정보를 가지고 있는 객체
	//response : 서버에서 클라이언트로 나가는 '응답'과 관련된 모든 정보를 가지고 있는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");//MIME TYPE
		
		// 2.클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		// 3.스트림으로 보낼 내용 출력
		out.println("<html><body>");
		out.println("<h1>Hell ll o Ser   vle     t HI???</h1>");
		out.println("<a href='messageservlet'> go to MessageServlet");
		out.println("<br><a href='loginServlet?id=day6&pw=최고'> go to LoginServlet");
		out.println("</html></body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Do Post");
	}

}
