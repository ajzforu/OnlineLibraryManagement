package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.pojo.Book;
import com.app.pojo.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao dao;

	@Override
	public Users validateUser(String email, String password) {
		return dao.validateUser(email, password);
	}

	@Override
	public Integer registerUser(Users user) {
		return dao.registerUser(user);
	}

	@Override
	public List<Users> getAllUser() {
		return dao.getUserList();
	}

	@Override
	public void deleteuser(int uid)
	{
		dao.deleteUser(uid);
		
	}

	@Override
	public Book getStock(int stock) {
		// TODO Auto-generated method stub
		return dao.issueBook();
	}

	
}
