package com.app.dao;

import java.util.List;

import com.app.pojo.Book;

public interface BookDao 
{
	public Integer addNewBook(Book book);
	public List<Book> getAllBook();
	public List<String> getAllSubjects();
	public List<Book> getBookBySubject(String subject);
	public void deleteBook(int id);
	//void updateBook(Book book);
	public  void updateBook(Book book);
	Book getBookById(Integer bookid);
}
