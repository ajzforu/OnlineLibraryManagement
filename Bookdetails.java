package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOKDETAILS_TABLE")
public class Bookdetails
{
	private int detailsid;
	private Book book;
	private int stock;
	private boolean status;
	
	public Bookdetails() {
		// TODO Auto-generated constructor stub
	}

	public Bookdetails(int detailsid, Book book, int stock, boolean status) {
		super();
		this.detailsid = detailsid;
		this.book = book;
		this.stock = stock;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="details_id")
	public int getDetailsid() {
		return detailsid;
	}

	public void setDetailsid(int detailsid) {
		this.detailsid = detailsid;
	}

	
    @OneToOne
    @JoinColumn(name="bookid")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
	@Column(name="stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	@Column(name="status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bookdetails [detailsid=" + detailsid + ", book=" + book + ", stock=" + stock + ", status=" + status
				+ "]";
	}
	
	
}
