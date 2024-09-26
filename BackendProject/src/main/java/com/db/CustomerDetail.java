package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerDetail")
public class CustomerDetail extends HttpServlet {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tommydb?characterEncoding=UTF-8&serverTimezone=UTC";
	String user = "tommy";
	String password = "lion";
	String query = "select * from customer where num=?";// num, name, address

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 서버에서 클라이언트로 보내는 응답의 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");// MIME TYPE

		// 클라이언트로 보낼 컨텐트의 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		String num = request.getParameter("num");
		System.out.println("num:"+num);

		try {

			// 2. Connection 생성 - network 연결
			Connection con = DriverManager.getConnection(url, user, password);

			// 3.Statement 생성
			PreparedStatement stat = con.prepareStatement(query);
			stat.setInt(1, Integer.parseInt(num));

			// 4.Query 실행
			ResultSet rs = stat.executeQuery();
			rs.next();
			
			String numGot = rs.getString(1);
			String name = rs.getString(2);
			String address = rs.getString(3);
			
			out.println("<html><body>");
			System.out.println(numGot);
			out.println("<h3>num : " +numGot+ "\tname : "+name+"\taddress : "+address+"</h3>");
			out.println("<a href='/Backend/CustomerStart'> 돌아가기");
			out.println("</body></html>");
			
			// 6. 마무리
			rs.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
