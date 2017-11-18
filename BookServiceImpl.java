package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookDao;
import com.app.pojo.Book;

@Service
@Transactional
public class BookServiceImpl  implements BookService
{
	@Autowired
	private BookDao dao;

	@Override
	public Integer addNewBook(Book book) {
		System.out.println("inside service add book");
		return dao.addNewBook(book);
	}

	@Override
	public List<Book> getAllBook() {
		return dao.getAllBook();
	}
	@Override
	public List<String> getAllSubjects() {
		return dao.getAllSubjects();
	}

	@Override
	public List<Book> getBookBySubject(String subject) {
		return dao.getBookBySubject(subject);
	}

	@Override
	public void deleteBook(int id) {
		dao.deleteBook(id);
		
	}

	@Override
	public void updateBook(Book book) {
	dao.updateBook(book);
		
	}

	@Override
	public Book getBookById(Integer bookid) {
		return this.dao.getBookById(bookid);
	}

	
}
