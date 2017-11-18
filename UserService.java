package com.app.service;

import java.util.List;

import com.app.pojo.Book;
import com.app.pojo.Users;

public interface UserService {
	public Users validateUser(String email,String password);
	public Integer registerUser(Users user);
	public List<Users> getAllUser() ;
	// void deleteuser(int id);
	public void deleteuser(int uid);
	//public Book getStock(int stock);
	public Book getStock(int stock);

}
