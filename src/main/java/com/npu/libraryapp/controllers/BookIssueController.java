package com.npu.libraryapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.npu.libraryapp.domain.Member;
import com.npu.libraryapp.services.BookIssueService;


@Controller
public class BookIssueController {
	@Autowired
	BookIssueService bookIssueService;
	
	private static final Logger logger = LoggerFactory.getLogger(BookIssueController.class);
	
	@RequestMapping(value = "/bookmembers", method = RequestMethod.GET)
	public String bookMembersForm() {
		
		return "enterBookNameForm";
	}
	
	@RequestMapping(value = "/listMembers", method = RequestMethod.GET)
	public ModelAndView listStudentsInCourse(String bookName) {
		
		System.out.println(bookName);
		
		List<Member> memberList = new ArrayList<Member>();
		ModelAndView modelView;
		
		memberList = bookIssueService.findMemberDetails(bookName);
	
		modelView = new ModelAndView("viewMemberList");
		modelView.addObject("bookName", bookName);
		modelView.addObject("memberList", memberList);
		
		return modelView;
	}
	
}
