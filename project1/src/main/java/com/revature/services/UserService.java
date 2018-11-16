package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dto.Credential;
import com.revature.model.User;

public interface UserService {


	UserService currentImplementation = new UserServiceImpl();

	List<User> findAll();
	
	User findById(int id);
	
	User findbyUsernameAndPassword(String username, String password);

	boolean login(Credential cred, HttpSession session);
}
