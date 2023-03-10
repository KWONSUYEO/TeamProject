package com.soldesk.jan05.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody Members memberIdCheck(Member m) {
		return mDAO.idCheck(m);
	}
	
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.login(m, req, res);
		mDAO.loginCheck(req);
		req.setAttribute("main", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.signup.go", method = RequestMethod.GET)
	public String memberSignupGo(HttpServletRequest req) {
		mDAO.loginCheck(req);
		req.setAttribute("main", "member/signup.jsp");
		return "index";
	}
		
	@RequestMapping(value = "/member.signup", method = RequestMethod.POST)
	public String memberSignup(Member m, HttpServletRequest req) {
		mDAO.signup(m, req);
		mDAO.loginCheck(req);
		req.setAttribute("main", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.loginCheck(req);
		req.setAttribute("main", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/info.go", method = RequestMethod.GET)
	public String info(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			req.setAttribute("main", "member/info.jsp");
		} else {
			req.setAttribute("main", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String memberUpdate(Member m, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			mDAO.update(m, req);
			req.setAttribute("main", "home.jsp");
		} else {
			req.setAttribute("main", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/member.withdraw", method = RequestMethod.GET)
	public String memberWithdraw(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			mDAO.withdraw(req);
			mDAO.logout(req);
			mDAO.loginCheck(req);
		}
		req.setAttribute("main", "home.jsp");
		return "index";
	}
}
