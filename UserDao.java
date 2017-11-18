package com.app.dao;


import java.util.List;

import com.app.pojo.Book;
import com.app.pojo.Users;

public interface UserDao 
{
	public Users validateUser(String email,String password);
	public Integer registerUser(Users user);
	public List<Users> getUserList();
	public void deleteUser(int uid);
	//public Book issueBook(int stock);
	//public Book IssueBook();
	public Book issueBook();
}