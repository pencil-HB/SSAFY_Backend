package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mvc.util.DBUtil;
import com.mvc.vo.User;

public class UserDAOImpl implements UserDAO {
	DBUtil util;
	
	public UserDAOImpl() {
		util = DBUtil.getInstance();
	}
	
	public boolean check(User u) {
		boolean flag = false;
		String q= "select id from user where id=? and pw=?";
		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, u.getId());
			stat.setString(2, u.getPw());
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()) flag = true;
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
