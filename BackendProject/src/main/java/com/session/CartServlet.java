package com.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");// MIME TYPE

		// 2.클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		//파라미터 얻어오기
		String id = request.getParameter("id");
		
		//Session 얻어오기
		//true:없으면 새로 만들어줌
		//false:없으면 null리턴
		HttpSession session = request.getSession(true);
		
		if(session.isNew()) {
			session.setAttribute("tomato", new int[] {0});
			session.setAttribute("orange", new int[] {0});
		}
		
		int[] tomato=(int[])session.getAttribute("tomato");
		int[] orange=(int[])session.getAttribute("orange");
		String msg="";
		
		if(id.equals("tomato")) {
			tomato[0]++;
			msg = "토마토를 장바구니에 추가했습니다.";
		} else if(id.equals("orange")){
			orange[0]++;
			msg = "오렌지를 장바구니에 추가했습니다.";
		}
		msg += "현재 토마토는 "+ tomato[0] +"개, 오렌지는 " + orange[0] +"개 입니다.";
		
		out.println("<html><body>");
		out.println(msg + "<hr>");
		out.println("<a href=ShopServlet>쇼핑하러 가기</a>");
		out.println("</body></html>");
	}
	
}
