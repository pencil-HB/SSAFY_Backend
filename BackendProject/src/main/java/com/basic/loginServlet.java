package com.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
//		response.setContentType("text/html;charset=utf-8");//MIME TYPE
//		
//		//클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
//		PrintWriter out = response.getWriter();
//		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		
//		out.println("<html><body>");
//		out.println("<h1>hello," + id + ", your password is .. "+ pw+"</h1>");
//		out.println("</html></body>");
//	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    };

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");//MIME TYPE
		
		//클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] seasons = request.getParameterValues("season");
		
		out.println("<html><body>");
		out.println("<h1>hello," + id + ", your password is .. "+ pw+"</h1>");
		out.print("Your favorit Season is..");
		for(String s : seasons) {
			out.print(s+", ");
		}
		out.println();
		out.println("</html></body>");
	}
}
