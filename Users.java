package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS_TABLE")
public class Users 
{
	private Integer id;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String role;
	private List<Issue> issue;
	private List<Fine> fine;
	public Users() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Users(Integer id, String name, String email, String mobile, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="EMAIL",unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Column(name="MOBILE")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="USER_ROLE")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
		public List<Issue> getIssue()
		{
		return issue;
	}



	public void setIssue(List<Issue> issue) {
		this.issue = issue;
	}



	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public List<Fine> getFine() {
		return fine;
	}



	public void setFine(List<Fine> fine) {
		this.fine = fine;
	}



	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + ", role=" + role + "]";
	}

	

	
}
