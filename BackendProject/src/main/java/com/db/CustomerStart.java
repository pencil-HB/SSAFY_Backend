package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerStart")
public class CustomerStart extends HttpServlet {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tommydb?characterEncoding=UTF-8&serverTimezone=UTC";
	String user = "tommy";
	String password = "lion";
	String query = "select * from customer";// num, name, address

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");// MIME TYPE

		// 클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();

		try {

			// 2. Connection 생성 - network 연결
			Connection con = DriverManager.getConnection(url, user, password);

			// 3.Statement 생성
			Statement stat = con.createStatement();

			// 4.Query 실행
			ResultSet rs = stat.executeQuery(query);

			out.println("<html><body>");
			out.println("<table border=1>");
			out.println("<tr><th>num</th><th>name</th>");

			// 5. 결과 처리
			while (rs.next() == true) {
				String num = rs.getString(1);// rs.getInt(1); rs.getString("num");
				String name = rs.getString(2);
				String address = rs.getString(3);
				out.println("<tr>");
				
				out.println("<td>" + num + "</td>");
				out.println("<td><a href='CustomerDetail?num="+num+"'>" + name + "</a></td>");
				out.println("</tr>");
			}

			out.println("</table>");
			
			out.println("<br>");
			
			out.println("<a href='/Backend/CustomerInsert'> 고객 등록하기");
			out.println("</body></html>");

			// 6. 마무리
			rs.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
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
