package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.sample.dto.Movie;
import com.ssafy.sample.model.service.MovieService;
import com.ssafy.sample.model.service.MovieServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieController
 */

public class MovieController extends HttpServlet {
	MovieService service = new MovieServiceImpl();

	public void list(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RequestDispatcher dis = request.getRequestDispatcher("/movie/list.jsp");
		request.setAttribute("list", service.selectAll());
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void read(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dis = request.getRequestDispatcher("movie/read.jsp");
		try {
			request.setAttribute("movie", service.selectByCode(request.getParameter("code")));
			dis.forward(request, response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("movie/regist.jsp");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertProcess(HttpServletRequest request, HttpServletResponse response) {
		String mcode = request.getParameter("code");
		String mtitle = request.getParameter("title");
		int mtime = Integer.parseInt(request.getParameter("time"));
		String mdirector =  request.getParameter("director");
		String mgenre = request.getParameter("genre");
		
		Movie m = new Movie(mcode, mtitle, mtime, mdirector, mgenre);
		
		try {
			if(service.insert(m)>0) {
				System.out.println("good");
				response.sendRedirect("movie?act=list");
			} else {
				System.out.println("insert failed");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	public void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
}
