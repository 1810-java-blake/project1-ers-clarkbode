package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.daos.UserDao;
import com.revature.dto.Credential;
import com.revature.model.User;

public class UserServiceImpl implements UserService{

	private UserDao ud = UserDao.currentImplementation;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ud.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return ud.findById(id);
	}

	@Override
	public User findbyUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return ud.findbyUsernameAndPassword(username, password);
	}
	
	@Override
	public boolean login(Credential cred, HttpSession session) {
		User u = ud.findbyUsernameAndPassword(cred.getUsername(), cred.getPassword());
		if (u != null) {
			session.setAttribute("role", u.getRole().getName());  //u.getRole().getName());
			return true;
		} 
		return false;
	}

}
