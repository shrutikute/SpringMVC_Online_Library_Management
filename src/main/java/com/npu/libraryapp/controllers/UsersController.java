package com.npu.libraryapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.npu.libraryapp.domain.ApplicationModel;
import com.npu.libraryapp.domain.Member;

@Controller
public class UsersController {
	
	private Member member;

	@RequestMapping(value="/success", method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) 
	{
		ApplicationModel applicationModel = new ApplicationModel();
		member = (Member)request.getSession().getAttribute("user");
		applicationModel.setMember(member);
		return new ModelAndView("success", "applicationModel", applicationModel);
	}
}



