package com.app.service;

import java.util.List;

import com.app.pojo.Book;

public interface BookService 
{
	public Integer addNewBook(Book book);
	public List<Book> getAllBook();
	public List<String> getAllSubjects();
	public List<Book> getBookBySubject(String subject);
	public void deleteBook(int id);
	public void updateBook(Book book_);
	public Book getBookById(Integer bookid);
}
