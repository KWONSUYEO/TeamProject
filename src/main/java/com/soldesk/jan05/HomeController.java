package com.soldesk.jan05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("main", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/go", method = RequestMethod.GET)
	public String home1(HttpServletRequest req) {
		req.setAttribute("main", "home.jsp");
		return "index";
	}
	
}
