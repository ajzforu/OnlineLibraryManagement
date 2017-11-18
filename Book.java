package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOK_TABLE")
public class Book 
{
	private int bookId;
	private String subjectName;
	private String bookName;
	private String authorName;
	private String publisher;
	private String iName;
	private int stock;
	private Category category;
	private Bookdetails bookdetails;
	private Issue issue;
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String subjectName, String bookName, String authorName, String publisher, String iName,int stock) {
		super();
		this.bookId = bookId;
		this.subjectName = subjectName;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.iName = iName;
		this.stock = stock;
	}

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Column(name="SUBJECT_NAME")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Column(name="BOOK_NAME")
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name="AUTHOR_NAME")
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Column(name="PUBLISHER")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name="IMAGE_NAME")
	public String getiName() {
		return iName;
	}


	public void setiName(String iName) {
		this.iName = iName;
	}
	
	@Column(name="stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@ManyToOne
	@JoinColumn(name="category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToOne
	public Bookdetails getBookdetails() {
		return bookdetails;
	}

	public void setBookdetails(Bookdetails bookdetails) {
		this.bookdetails = bookdetails;
	}

	@OneToOne
	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", subjectName=" + subjectName + ", bookName=" + bookName + ", authorName="
				+ authorName + ", publisher=" + publisher + ", iName=" + iName + ", stock=" + stock + "]";
	}

}
