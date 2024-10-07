package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.dto.Member;
import com.ssafy.test.model.dao.MemberDao;
import com.ssafy.test.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	MemberDao dao = new MemberDaoImpl();
	@Override
	public Member login(Member member) throws SQLException {
		return dao.login(member);
	}

}
