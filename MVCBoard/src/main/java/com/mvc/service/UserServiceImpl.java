package com.mvc.service;

import com.mvc.dao.UserDAO;
import com.mvc.dao.UserDAOImpl;
import com.mvc.vo.User;

public class UserServiceImpl implements UserService {
	UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	@Override
	public boolean check(User u) {
		return dao.check(u);
	}

	@Override
	public void logout(User u) {
		// TODO Auto-generated method stub
		
	}

	
}
