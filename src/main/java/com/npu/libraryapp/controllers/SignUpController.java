package com.npu.libraryapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.npu.libraryapp.domain.Member;
import com.npu.libraryapp.services.MemberService;


@Controller
public class SignUpController {
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	@RequestMapping(value = "/newSignUpForm", method = RequestMethod.GET)
	public ModelAndView newSignUpForm() {
		ModelAndView modelView;
		
		modelView = new ModelAndView("memberDataForm");
 		modelView.addObject("member", new Member());
		return modelView;
	}

	
	@RequestMapping(value = "/processNewSignUpProfile", method = RequestMethod.POST)
	public ModelAndView processNewSignUpForm(@Valid Member member, BindingResult result, HttpSession session) 
	{
		
		ModelAndView modelView;
		
		if (result.hasErrors()) {
			modelView = new ModelAndView("memberDataForm", "member", member);
			return modelView;
		}
		System.out.println("here ");

		memberService.addNewMember(member);
		
		System.out.println("here ");
		modelView = new ModelAndView("home");
		System.out.println("model view " +modelView);

 		session.setAttribute("member", member);
 		modelView.addObject("member", member);
		
		System.out.println("after model view " +modelView);

		return modelView;
	
	
	}
	
	
}
