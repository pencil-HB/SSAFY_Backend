package com.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class CustomerInsert
 */

@WebServlet("/CustomerInsert")
public class CustomerInsert extends HttpServlet {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tommydb?characterEncoding=UTF-8&serverTimezone=UTC";
	String user = "tommy";
	String password = "lion";
	String query = "insert into customer value(?, ?, ?)";// num, name, address

	public CustomerInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// 2. Connection 생성 - network 연결
			Connection con = DriverManager.getConnection(url, user, password);

			// 3.Statement 생성
			PreparedStatement stat = con.prepareStatement(query);
			
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			
			stat.setString(1, num);
			stat.setString(2, name);
			stat.setString(3, address);

			// 4.Query 실행
			int rs = stat.executeUpdate();
			
			response.setContentType("text/html;charset=utf-8");// MIME TYPE

			// 클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
			PrintWriter out = response.getWriter();

			out.println("<html><body><h1>"+rs+"명 등록되었습니다.<br></h1>");
			out.println("<a href='/Backend/CustomerStart'> 초기화면 </body></html>");
			
			
			// 6. 마무리
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");// MIME TYPE

		// 클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();

		String num = request.getParameter("num");

		out.println("<html><body>");
		out.println("<form method=\"post\" action=\"/Backend/CustomerInsert\">");
		out.print("		<input type=\"text\" id=\"num\" name=\"num\" placeholder=\"고객번호\" required>\r\n"
				+ "		<input type=\"text\" id=\"name\" name=\"name\" placeholder=\"이름\" required>\r\n"
				+ "		<input type=\"text\" id=\"address\" name=\"address\" placeholder=\"주소\" required>\r\n"
				+ "		<hr>");
		out.println("<button type=\"submit\">고객 등록하기</button>");
		out.println("</form>");
		out.println("</body></html>");

	}

	@Override
	public void init() throws ServletException {

		// TODO Auto-generated method stub
		super.init();
		// 1.Driver 등록
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // "com.mysql.cj.jdbc.Driver". mysql에서 맨처음 생성해 놓는 시작 클래스
	}
}
