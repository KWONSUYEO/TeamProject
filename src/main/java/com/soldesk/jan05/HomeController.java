package com.soldesk.jan05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.jan05.member.MemberDAO;

@Controller
public class HomeController {
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		mDAO.loginCheck(req);
		req.setAttribute("main", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/go", method = RequestMethod.GET)
	public String home1(HttpServletRequest req) {
		return home(req);
	}
	
}
