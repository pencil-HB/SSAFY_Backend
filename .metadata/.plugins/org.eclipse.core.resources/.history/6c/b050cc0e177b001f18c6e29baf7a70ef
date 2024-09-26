package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mvc.util.DBUtil;
import com.mvc.vo.Board;

//BoardDAO 메소드를 구현한 객체
//BoardService 에서 들어온 요청을 처리
//db 작업 수행
public class BoardDAOImpl implements BoardDAO {

	DBUtil util;

	public BoardDAOImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = new ArrayList();
		String q = "select num, name, wdate, title, count from board order by num desc";

		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				int count = rs.getInt(5);
				Board b = new Board(num, name, wdate, title, count);
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Board selectOne(String num) {
		String q = "select num, name, wdate, title, count, content from board where num=?";
		Board b = null;
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);
			ResultSet rs = stat.executeQuery();

			rs.next();
			String name = rs.getString(2);
			String wdate = rs.getString(3);
			String title = rs.getString(4);
			int count = rs.getInt(5);
			b = new Board(num, name, wdate, title, count);
			b.setContent(rs.getString(6));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public boolean insert(Board b) {
		String q = "insert into board(pass, name, wdate, title, content, count) values (?,?,sysdate(),?,?,0)";
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			
			stat.setString(1, b.getPass());			
			stat.setString(2, b.getName());			
			stat.setString(3, b.getTitle());			
			stat.setString(4, b.getContent());			
			
			int rs = stat.executeUpdate();
			
			if(rs==1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String num) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public void countUp(String num) {
		String q1 = "select count from board where num=?";
		String q2 = "update board set count=? where num=?";
		try {
			Connection con = util.getConnection();
			PreparedStatement stat1 = con.prepareStatement(q1);
			stat1.setString(1, num);
			ResultSet rs = stat1.executeQuery();

			rs.next();
			int count = rs.getInt(1)+1;
			
			PreparedStatement stat2 = con.prepareStatement(q2);
			stat2.setInt(1, count);
			stat2.setString(2, num);
			stat2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
