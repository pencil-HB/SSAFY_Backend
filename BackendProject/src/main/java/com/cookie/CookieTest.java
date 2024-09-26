package com.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class cookieTest
 */
public class CookieTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//요청 정보로부터 모든 쿠키 정보를 알아냄
		Cookie[] cookies = request.getCookies();
		if(cookies == null || cookies.length == 0) {
			out.println("<html><body>");
			out.println("<h1>쿠키가엄슴..</h1>");
			out.println("</body></html>");
		} else {
			out.println("<html><body><h1>쿠키 정보:</h>");
			for(Cookie c : cookies) {
				String name = c.getName();
				String val = c.getValue();
				out.println(name + " : " + val+"<hr>");
			}
			
			out.println("<a href='CookieTest'>다시 방문하기</a>");
			out.println("</body></html>");
		}
	}

	// 사용자 입력 값 받아와서 쿠키에 저장하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");// MIME TYPE

		// 2.클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//쿠키 생성
		Cookie idCookie = new Cookie("id", id);
		Cookie pwCookie = new Cookie("pw", pw);
		
//		idCookie.setMaxAge(60*60*24*365); // 초단위 유지
		idCookie.setMaxAge(-1); // 브라우저가 열려있는 동안 유지 
		pwCookie.setMaxAge(-1); // 브라우저가 열려있는 동안 유지 
		
		//응답객체에 쿠키 저장
		response.addCookie(idCookie);
		response.addCookie(pwCookie);
		
		out.println("<html><body>");
		out.println("<h1>쿠키에 저장되었습니다</h1>");
		out.println("<hr><a href='CookieTest'>다시 방문하기</a>");
		out.println("</body></html>");
	}

}
