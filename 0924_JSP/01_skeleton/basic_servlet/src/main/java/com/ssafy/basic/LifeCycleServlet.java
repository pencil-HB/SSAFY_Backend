package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleServlet() {
        super();
        System.out.println("Constructor Call~~");
    }
     
    @Override
    public void init() throws ServletException {
    	System.out.println("init() Call~~");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() Call~~");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() Call~~");
	}
}
