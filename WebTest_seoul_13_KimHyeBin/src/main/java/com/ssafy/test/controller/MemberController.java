package com.ssafy.test.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.mysql.cj.Session;
import com.ssafy.test.dto.Member;
import com.ssafy.test.model.service.MemberService;
import com.ssafy.test.model.service.MemberServiceImpl;

@WebServlet()
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService service = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");

		if (act.equals("login")) {
			this.login(request, response);
		} else if (act.equals("logout")) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", null);
			session.setAttribute("userName", null);
			response.sendRedirect("index.jsp");
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Member m = new Member(id, password, null);
		
		try {
			m = service.login(m);
			if(m == null) {
				RequestDispatcher dis = request.getRequestDispatcher("member?act=login");
				dis.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("userId", m.getId());
				session.setAttribute("userName", m.getName());
				
				if(request.getParameter("remember") != null) {
					Cookie cookie = new Cookie("rememberedUserId", id);
					cookie.setMaxAge(60*60*24*365);
					response.addCookie(cookie);
				}
				
				RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
				dis.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//톰캣 10버전부터는 post에서 한글 인코딩 안해도 문제 없음
//		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
