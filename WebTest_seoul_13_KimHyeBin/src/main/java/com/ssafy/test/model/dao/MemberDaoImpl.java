package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.dto.Member;
import com.ssafy.test.dto.Product;
import com.ssafy.test.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	DBUtil util = DBUtil.getInstance();
	
	@Override
	public Member login(Member member) throws SQLException {
		String id = member.getId();
		String password = member.getPassword();
		
		Connection con = util.getConnection();
		String q = "Select * from tmembers where mid=? and mpass=?";
		PreparedStatement pstat = con.prepareStatement(q);
		
		pstat.setString(1, id);
		pstat.setString(2, password);
		
		ResultSet rs = pstat.executeQuery();
		
		Member m = null;
		
		if(rs.next()) {
			m = new Member();
			m.setId(rs.getString(1));
			m.setPassword(rs.getString(2));
			m.setName(rs.getString(3));
		}
		System.out.println(m);
		
		return m;
	}

}
