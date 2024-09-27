package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieController
 */
@WebServlet("/movie")
public class MovieFrontController extends HttpServlet {

	MovieController con = new MovieController();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String act = request.getParameter("act");
			if (act.equals("list")) {
				con.list(request, response);
			} else if (act.equals("read")) {
				con.read(request, response);
			} else if (act.equals("insertForm")) {
				con.insertForm(request, response);
			} else if (act.equals("insertProcess")) {
				con.insertProcess(request, response);
			} else if (act.equals("delete")) {
				con.delete(request, response);
			} else if (act.equals("update")) {
				con.update(request, response);
			}
		}
		catch (SQLException e) {
			RequestDispatcher dis = request.getRequestDispatcher("error.jsp");
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 톰캣 10버전부터는 post에서 한글 인코딩 안해도 문제 없음
//		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
