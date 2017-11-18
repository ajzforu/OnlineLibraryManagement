package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Book;

@Repository
public class BookDaoImpl  implements BookDao
{
	@Autowired
	private SessionFactory factory;

	@Override
	public Integer addNewBook(Book book) {
		System.out.println("inside add new book dao");
		return (Integer) factory.getCurrentSession().save(book);
	}

	@Override
	public List<Book> getAllBook() {
		String hql = "select b from Book b";
		return factory.getCurrentSession().createQuery(hql, Book.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllSubjects() {
		String hql = "select distinct b.subjectName from Book b";
		return factory.getCurrentSession().createQuery(hql).getResultList();
		
	}

	@Override
	public List<Book> getBookBySubject(String subject) {
		String hql = "select b from Book b where b.subjectName=:sub";
		return factory.getCurrentSession().createQuery(hql, Book.class).setParameter("sub", subject).getResultList();
	}
	
	public void deleteBook(int id) {
		Book book = factory.getCurrentSession().get(Book.class, id);
		factory.getCurrentSession().remove(book);
	}
/*	@Override
	public void updateBook(Book book) {
		Book b=this.getBookById(book.getBookId());
		Session session = this.factory.getCurrentSession();
		session.update(b);
		}*/
	
	@Override
	public void updateBook(Book book) {
		
		Session session = this.factory.getCurrentSession();
		session.update(book);
		
	}

	@Override
	public Book getBookById(Integer bookid) {
	
		String hql = "select b from Book b where b.bookId=:bid";
		return factory.getCurrentSession().createQuery(hql, Book.class).setParameter("bid", bookid).getSingleResult();

	}
	
}
