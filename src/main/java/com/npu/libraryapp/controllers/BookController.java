package com.npu.libraryapp.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.domain.BookIssue;
import com.npu.libraryapp.domain.Member;
import com.npu.libraryapp.services.BookIssueService;
import com.npu.libraryapp.services.BookService;
/**
 * Handles requests for the application book page.
 */

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	BookIssueService bookIssueService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(value = "/issueBook", method = RequestMethod.GET)
	public ModelAndView issueBook(HttpSession session) {
		
		
		Member member = (Member) session.getAttribute("member");
		session.setAttribute("member", member);
		
		List<Book> bookList;
		ModelAndView modelView;
		bookList = bookService.getAllBooks();
		modelView = new ModelAndView("issueBookForm");
		modelView.addObject("bookList", bookList);
		
		return modelView;
		
	}
	
	@RequestMapping(value = "/bookIssued", method = RequestMethod.GET)
	public ModelAndView processBookIssue(HttpServletRequest req, HttpSession session) 
	{
		BookIssue bookIssue = new BookIssue();
		ModelAndView modelView;
	
		bookIssue.setBookid(Integer.parseInt(req.getParameter("bookId")));
		bookIssue.setMemid(Integer.parseInt(req.getParameter("memId")));
		java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
        
        bookIssue.setDate(today);
			
		System.out.println("bookissue " +bookIssue);
		
		bookIssueService.addNewEntry(bookIssue);
		modelView = new ModelAndView("newBookIssued");
		modelView.addObject("bookissue", bookIssue);
		return modelView;
		
		
	}
	
	
}
