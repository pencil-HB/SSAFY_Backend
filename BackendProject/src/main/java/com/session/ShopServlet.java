package com.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ShopServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");// MIME TYPE

		// 2.클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>dada's mall</h1>");
		out.println("<a href='CartServlet?id=tomato'>쇼핑백에 토마토 담기</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='CartServlet?id=orange'>쇼핑백에 오렌지 담기</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='CheckoutServlet?id=see'>쇼핑백 보기</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='CheckoutServlet?id=check'>계산하기</a>&nbsp;&nbsp;&nbsp;");
		out.println("</body></html>");
	}

}
