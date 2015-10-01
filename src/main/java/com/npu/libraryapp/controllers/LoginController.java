package com.npu.libraryapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.npu.libraryapp.domain.Member;

import com.npu.libraryapp.services.MemberService;

/**
 * Handles requests for the application login function.
 */

@Controller
public class LoginController {

	private Member member;

	@Autowired
	private MemberService memberService;

	private static final Logger logger = LoggerFactory
			.getLogger(MemberController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView init() {
		member = new Member();
		return new ModelAndView("login", "loginDetails", member);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginDetails") Member member,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,
					"userName", "userName", "Username can not be empty.");
			ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,
					"password", "password", "Password not be empty");

			if (bindingResult.hasErrors()) {
				return new ModelAndView("login", "loginDetails", member);
			} else {

				if (memberService.validate(member)) {

					String n = request.getParameter("userName");
					String p = request.getParameter("password");

					Member mem = new Member();
					int id = memberService.findMemberIdByName(n);
					mem.setMemid(id);
					request.getSession().setAttribute("member", mem);

					RedirectView redirectView = new RedirectView("success.do",
							true);
					return new ModelAndView(redirectView);
				} else {
					bindingResult.addError(new ObjectError("Invalid",
							"Invalid credentials. "
									+ "Username or Password is incorrect."));
					return new ModelAndView("login", "loginDetails", member);
				}
			}
		} catch (Exception e) {
			System.out
					.println("Exception in LoginController " + e.getMessage());
			e.printStackTrace();
			return new ModelAndView("login", "loginDetails", member);
		}
	}
}
