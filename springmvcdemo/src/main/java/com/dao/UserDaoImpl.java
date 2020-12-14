package com.dao;

import org.springframework.stereotype.Repository;

import com.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public User getUserName(User user) {
		if (user.getUserId() > 0 && user.getPassword().length() > 0 && user.getPassword().contentEquals("hello")) {
			user.setUserName("Good afternoon from dao");
		}
		return user;
	}

}
