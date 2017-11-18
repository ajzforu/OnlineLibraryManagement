package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojo.Book;
import com.app.pojo.Users;
import com.app.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	private MailSender mailSender;
	
	
	@GetMapping(value="/login")
	public String showLoginForm(Users user)
	{
		return "login";
	}
	
	@PostMapping(value="/login")
	public String processLoginForm(Users user,HttpSession session)
	{
		Users us = service.validateUser(user.getEmail(), user.getPassword());
		if(us!=null)
		{
			session.setAttribute("userSuccess", us);
			if(us.getRole().equals("Customer"))
			{
				return "subject";
			}
			
			else
			{
				return "admin";
			}
		}
		else
		{

			return "login";
		}
	}
	
	@GetMapping(value="/home")
	public String showAdmin()
	{
		return "admin";
	}
	
	@GetMapping(value="/UserHome")
	public String showUserHome()
	{
		return "subject";
	}
	
	@GetMapping(value="/logout")
	public String logout()
	{
		return "login";
	}
	
	
	@GetMapping(value="/register")
	public String showRegisterForm(Users user)
	{
		return "register";
	}
	
	@PostMapping(value="/register")
	public String processRegisterForm(Users users,Model map)
	{
		Integer regId = service.registerUser(users);
		if(regId!=null)
		{
			map.addAttribute("regSuccess", "User Registration done with id "+regId);
			String msg="Thank you for registration Your  Username is "+users.getEmail() +" and Password "+users.getPassword();
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(users.getEmail());
			mailMessage.setSubject("Registration Details");
			mailMessage.setText(msg);
			
			try
			{
				mailSender.send(mailMessage);
			}
			catch (MailException e) 
			{
				System.out.println("inside mail exception");
				e.printStackTrace();
			}
			return "redirect:login";
		}
		else
		{
			return "register";
		}
	}
	
	@GetMapping(value="/adminHome")
	public String showAdminForm()
	{
		return "admin";
	}
	/*@GetMapping(value="/user")
	public String showSellerForm()
	{
		return "seller";
	}*/
	
	@GetMapping(value="/user")
	public String showAllUser(Model map)
	{
		List<Users> userList = service.getAllUser();
		if(userList!= null)
		{
			map.addAttribute("users", userList);
		}
		
		return "members";
	}
	@GetMapping(value="/deleteuser")
	public String deleteUserForm(Users user,@RequestParam(value="uid",required=false) int uid)
	{
		System.out.println("inside show delete");
		service.deleteuser(uid);
		//return "book";	
		return "redirect:user";
	}
	
	@GetMapping(value="/IssueBook")
	public String issueBook()
	{
		/*Book b = service.getStock(book.getStock());*/
		/*if(b.getStock()!=0)
		{
			System.out.println("Stock="+b.getStock());
		}*/
		return "book";
	}
	
}
