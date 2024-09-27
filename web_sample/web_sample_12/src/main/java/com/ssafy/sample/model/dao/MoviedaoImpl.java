package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.Movie;
import com.ssafy.sample.util.DBUtil;

public class MoviedaoImpl implements MovieDao {
	
	DBUtil util = DBUtil.getInstance();

	@Override
	public List<Movie> selectAll() throws SQLException {
		List<Movie> list = new ArrayList<>();
		Connection con = util.getConnection();
		String q = "select * from movies";
		
		PreparedStatement stat = con.prepareStatement(q);
		
		ResultSet rs = stat.executeQuery();
		
		while(rs.next()) {
			String mcode = rs.getString(1);
			String mtitle = rs.getString(2);
			int mtime = rs.getInt(3);
			String mdirector = rs.getString(4);
			String mgenre = rs.getString(5);
			Movie m = new Movie(mcode, mtitle, mtime, mdirector, mgenre);
			list.add(m);
		}
		
		return list;
	}

	@Override
	public Movie selectByCode(String code) throws SQLException {
		Movie m = null;
		Connection con = util.getConnection();
		String q = "select * from movies where mcode=?";
		
		PreparedStatement stat = con.prepareStatement(q);
		
		stat.setString(1, code);
		
		ResultSet rs = stat.executeQuery();
		
		while(rs.next()) {
			String mcode = rs.getString(1);
			String mtitle = rs.getString(2);
			int mtime = rs.getInt(3);
			String mdirector = rs.getString(4);
			String mgenre = rs.getString(5);
			m = new Movie(mcode, mtitle, mtime, mdirector, mgenre);
		}
		
		return m;
	}

	@Override
	public int insert(Movie product) throws SQLException {
		Connection con = util.getConnection();
		String q = "insert into movies value(?,?,?,?,?)";
		
		PreparedStatement stat = con.prepareStatement(q);
		
		stat.setString(1, product.getCode());
		stat.setString(2, product.getTitle());
		stat.setInt(3, product.getTime());
		stat.setString(4, product.getDirector());
		stat.setString(5, product.getGenre());
		
		return stat.executeUpdate();
	}

	@Override
	public int deleteByCode(String code) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Movie product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
