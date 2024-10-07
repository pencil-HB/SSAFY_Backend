package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.dto.Member;

public interface MemberService {
	
	Member login(Member member) throws SQLException;
}
