package com.mvc.controller;

import java.io.IOException;

import com.mvc.service.UserService;
import com.mvc.service.UserServiceImpl;
import com.mvc.vo.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//로그인 담당 컨트롤러
public class UserController {

	UserService uservice;

	public UserController() {
		uservice = new UserServiceImpl();
	}

	public void loginForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//1. id, pw 파라메터 받기
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String url = "board?act=list";
		//2. 받은 파라메터로 db 에 존재 확인
		
		System.out.println("id:"+id+" pw:"+pw);
		
		User u = new User(id, pw);
		boolean result = uservice.check(u);
		//3. 확인 결과 받기
		//4. 결과에 따라 화면 전환
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
		} else {
			url = "board?act=loginForm";
		}
		
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		try {
			response.sendRedirect("/mvc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
