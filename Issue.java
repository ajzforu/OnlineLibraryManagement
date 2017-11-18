package com.app.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ISSUE_TABLE")
public class Issue 
{
	private int issueid;
	private Date issuedate;
	private Date returndate;
	private Book book;
	private Users user;
	private int userid;
	
	public Issue() {
		// TODO Auto-generated constructor stub
	}


	public Issue(int issueid, Date issuedate, Date returndate, int userid) {
		super();
		this.issueid = issueid;
		this.issuedate = issuedate;
		this.returndate = returndate;
		this.userid = userid;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="issue_id")
	public int getIssueid() {
		return issueid;
	}

	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}

	
	@Column(name="issue_date")
	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	@Column(name="return_date")
	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}


	@OneToOne
	@JoinColumn(name="issueid")
	public Book getBook() {
		return book;
	}
    
	public void setBook(Book book) {
		this.book = book;
	}
	
	@ManyToOne
	@JoinColumn(name="userid")
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
