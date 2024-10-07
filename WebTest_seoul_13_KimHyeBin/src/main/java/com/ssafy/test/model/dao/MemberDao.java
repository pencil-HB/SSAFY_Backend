package com.ssafy.test.model.dao;

import java.sql.SQLException;

import com.ssafy.test.dto.Member;

public interface MemberDao {
	Member login(Member member) throws SQLException;
}
