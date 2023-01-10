package com.soldesk.jan05.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@RequestMapping(value = "/info.go", method = RequestMethod.GET)
	public String info(HttpServletRequest req) {
		req.setAttribute("main", "member/info.jsp");
		return "index";
	}
}
