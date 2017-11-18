package com.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Book;
import com.app.service.BookService;

@Controller
public class BookController 
{
	@Autowired
	private BookService service;
	
	@GetMapping(value="/addbook")
	public String showAddBookForm(Book book)
	{
		System.out.println("inside show add book");
		return "addBook";
	}
	
	@GetMapping(value="/deletebook")
	public String deleteBookForm(Book book,@RequestParam(value="id",required=false) int id)
	{
		System.out.println("inside show delete");
		service.deleteBook(id);
		//return "book";	
		return "redirect:book";
	}
	
	
	@GetMapping(value="/updatebook")
	public String updateBook(Model model,Book book_,@RequestParam(name="id")Integer id,HttpSession session)
	{
		session.removeAttribute("cur_id");
		session.setAttribute("cur_id",id);
		System.out.println("@@@@@@@@@@@@@@@@@@"+id); 
	
		Book bk=this.service.getBookById(id);
		System.out.println("********"+bk.toString());
		session.setAttribute("cur_obj",bk);
		//session.setAttribute("bookatr",new Book());
		model.addAttribute("bookatr",new Book());
		return "updatebook";
	}

	@PostMapping(value="/updatebook")
	public String updateBook(@Valid Book book,BindingResult result,HttpSession session)
	{
		Integer id=(Integer)session.getAttribute("cur_id");
		book.setBookId(id);
		System.out.println("&&&&&&&&&&&&&&"+book.toString());
		System.out.println("update book");
		service.updateBook(book);
		return "redirect:book";
	}
	
	
	@PostMapping(value="/addbook")
	public String processAddBookForm(FileUpload upload, Model map,Book book)throws IOException
	{
		System.out.println("inside proccess add book"+upload);
		MultipartFile file = upload.getFile();
		System.out.println("Multi Part File::"+file);
		if(file!=null && file.getSize() > 0)
		{
			
				InputStream in = file.getInputStream();
				String path = this.getClass().getResource("/../../images/").getPath();
				System.out.println("PATH:"+path);
				String fname = file.getOriginalFilename();
				System.out.println("FileName::"+fname);
				book.setiName(fname);
				Integer bid = service.addNewBook(book);
				if(bid!=null)
				{
					map.addAttribute("msg","Book is added with id "+bid);
				}
				else
				{
					map.addAttribute("msg","Error");
					return "addBook";
				}
			}
		//return "success";
		return "admin";
		
	}
	
	//***************Show Book***************
	
	@GetMapping(value="/book")
	public String showAllBooks(Model map)
	{
		List<Book> bookList = service.getAllBook();
		if(bookList!= null)
		{
			map.addAttribute("books", bookList);
		}
		return "book";
	}

	@GetMapping(value="/ubook")
	public String showBooks(Model map)
	{
		List<Book> bookList = service.getAllBook();
		if(bookList!= null)
		{
			map.addAttribute("books", bookList);
		}
		return "userShowBook";
	}


	

	
/*	@GetMapping(value="/subject")
	public String showSubjects(Model map)
	{
		List<String> subList = service.getAllSubjects();
		if(subList!= null)
		{
			map.addAttribute("subjects", subList);
		}
		return "subject";
	}*/
	

	
	
}
