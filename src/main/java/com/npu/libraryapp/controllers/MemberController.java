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

/**
 * Handles requests for the application Member page.
 */

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/newMemberDataForm", method = RequestMethod.GET)

	public ModelAndView newMemberDataForm() {
		ModelAndView modelView;
		modelView = new ModelAndView("memberDataForm");
 		modelView.addObject("member", new Member());
		return modelView;
	}
	
	
	@RequestMapping(value = "/processNewMemberProfile", method = RequestMethod.POST)
	public ModelAndView processNewMemberForm(@Valid Member member, BindingResult result, HttpSession session) 
	{
		ModelAndView modelView;
		
		if (result.hasErrors()) {
			modelView = new ModelAndView("memberDataForm", "member", member);
			return modelView;
		}
		
 		modelView = new ModelAndView("editOrSubmitNewMemForm");
 		session.setAttribute("member", member);
 		modelView.addObject("member", member);
		
		return modelView;
	}
	
	@RequestMapping(value = "/editOrStoreMemberProfile", method = RequestMethod.POST, params="editProfile")
	public ModelAndView editNewMemberProfile(HttpSession session) {
		ModelAndView modelView;
		Member mem;
		
		mem = (Member) session.getAttribute("member");
		modelView = new ModelAndView("memberDataFormWithSession");
		modelView.addObject("member", mem);
		return modelView;
	}
	
	@RequestMapping(value = "/editOrStoreMemberProfile", method = RequestMethod.POST, params="createProfile")
	public ModelAndView storeNewMemberProfile(HttpSession session) 
	{
		Member newMember;
		ModelAndView modelView;
		
		newMember = (Member) session.getAttribute("member");
		memberService.addNewMember(newMember);
		logger.info("Adding new member in procesNewMemberForm:   " + newMember.getName());
		modelView = new ModelAndView("newMemberProfileSuccess");
		modelView.addObject("member", newMember);
		return modelView;
		
	}
	
	@RequestMapping(value = "/deleteMemberForm", method = RequestMethod.GET)
	public String deleteMemberDataForm() {
		return "enterMemberIdForm";

	}
	
	
	@RequestMapping(value = "/deleteSuccess.html", method = RequestMethod.GET)
	public ModelAndView deleteMemberProcess(int memberId, HttpSession session) {
		
		System.out.println(memberId);
		
		Member member;
		ModelAndView modelView;
		
		member = (Member) session.getAttribute("member");
		memberService.deleteByMemberId(memberId);
		modelView = new ModelAndView("deleteSuccess");
		return modelView;
	
	}
	
}
