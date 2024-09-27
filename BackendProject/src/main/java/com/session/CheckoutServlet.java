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
 * Servlet implementation class CheckoutServlet
 */
// 세션 안의 정보 확인(id=see), 세션 안의 정보삭제(id=checkout) or 세션 삭제
public class CheckoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");// MIME TYPE

		// 2.클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		HttpSession session = request.getSession(false);
		
		//3.
		if(session == null) {
			out.println("<h1>장바구니에 물건이 없습니다.</h1>");
			out.println("<hr><a href='ShopServlet'>쇼핑하러 가기</a>");
		} else {
			int[] tomato=(int[])session.getAttribute("tomato");
			int[] orange=(int[])session.getAttribute("orange");
			
			String msg="";
			
			if(id.equals("see")) {
				msg += "현재 토마토는 "+ tomato[0] +"개, 오렌지는 " + orange[0] +"개 입니다.";
			} else if(id.equals("checkout")) {
				msg = "계산이 완료되었습니다. 장바구니는 비어있습니다.";
				session.invalidate();
				
//				session.setAttribute("tomato", null);
//				session.setAttribute("orange", null);
//				
//				session.removeAttribute("tomato");
//				session.removeAttribute("orange");
			}
			
			out.println("<html><body>");
			out.println(msg + "<hr>");
			out.println("<a href=ShopServlet>쇼핑하러 가기</a>");
			out.println("</body></html>");
		}
	}

}
