package com.mvc.service;

import com.mvc.vo.User;

public interface UserService {

	boolean check(User u);

	void logout(User u);

}
