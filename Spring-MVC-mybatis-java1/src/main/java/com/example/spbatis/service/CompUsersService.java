package com.example.spbatis.service;

import java.util.List;

import com.example.spbatis.dao.CompUsersDao;
import com.example.spbatis.model.CompUsers;

public class CompUsersService {

	private CompUsersDao dao = null;
	
	public CompUsersService() {
		dao = new CompUsersDao();
	}
	
	public List<CompUsers> getAllCompUsers() {
		return dao.selectAddress();
	}
	 
}
