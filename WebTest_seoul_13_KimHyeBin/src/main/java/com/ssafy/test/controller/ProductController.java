package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.test.dto.Product;
import com.ssafy.test.model.service.ProductService;
import com.ssafy.test.model.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet()
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductService service = new ProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		if (act.equals("list")) {
			this.list(request, response);
		} else if (act.equals("read")) {
			this.read(request, response);
		} else if (act.equals("regist")) {
			this.regist(request, response);
		} else if (act.equals("registProcess")) {
			this.registProcess(request, response);
		} else if (act.equals("delete")) {
			this.delete(request, response);
		} else if (act.equals("update")) {
			this.update(request, response);
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("list", service.selectAll());
			RequestDispatcher dis = request.getRequestDispatcher("/product/list.jsp");
			dis.forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("product", service.selectByCode(request.getParameter("code")));
			RequestDispatcher dis = request.getRequestDispatcher("/product/detail.jsp");
			dis.forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/product/regist.jsp");
		dis.forward(request, response);
	}

	protected void registProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("code");
		String name = request.getParameter("name");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		String category = request.getParameter("category");
		
		Product p = new Product(pcode, name, quantity, category);
		
		try {
			if (service.insert(p)>0) {
				System.out.println("insert success");
				response.sendRedirect("product?act=list");
			} else {
				System.out.println("insert failed");
			}
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (service.deleteByCode(request.getParameter("code"))>0) {
				System.out.println("delete success");
				response.sendRedirect("product?act=list");
			} else {
				System.out.println("delete failed");
			}
			
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/product/update.jsp");
		dis.forward(request, response);
	}
	
	protected void updateProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("code");
		String name = request.getParameter("name");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		String category = request.getParameter("category");
		
		Product p = new Product(pcode, name, quantity, category);
		
		try {
			if (service.update(p)>0) {
				System.out.println("update success");
				response.sendRedirect("product?act=list");
			} else {
				System.out.println("update failed");
			}
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 톰캣 10버전부터는 post에서 한글 인코딩 안해도 문제 없음
//		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
