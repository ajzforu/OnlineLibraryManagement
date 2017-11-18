package com.app.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Book;
import com.app.pojo.Users;

@Repository
public class UserDaoImpl implements UserDao 
{
	@Autowired
	private SessionFactory factory;

	@Override
	public Users validateUser(String email, String password) {
		String hql = "select u from Users u where u.email=:em and u.password=:pass";
		return factory.getCurrentSession().createQuery(hql, Users.class).setParameter("em", email).setParameter("pass", password).getSingleResult();
	}

	@Override
	public Integer registerUser(Users user) 
	{
		return (Integer) factory.getCurrentSession().save(user);
	}
	
	@Override
	public List<Users> getUserList() {
		String hql = "select b from Users b";
		return (List<Users>) factory.getCurrentSession().createQuery(hql, Users.class).getResultList();
	}

	@Override
	public void deleteUser(int uid) {
		 Users user = factory.getCurrentSession().get(Users.class, uid);
		factory.getCurrentSession().remove(user);
		
	}

	public Book IssueBook() {
		String hql = "select b from Book b where b.stock=:bstock";;
		return null;
	}

	@Override
	public Book issueBook() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
