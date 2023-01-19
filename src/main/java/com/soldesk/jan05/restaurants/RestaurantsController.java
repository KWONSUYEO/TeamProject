package com.soldesk.jan05.restaurants;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestaurantsController {
	
	@Autowired
	private RestaurantsDAO rDAO;
	
	@RequestMapping(value = "/dibs.go", method = RequestMethod.GET)
	public String info(HttpServletRequest req) {
		rDAO.getAllDibs(req);
		req.setAttribute("main", "restaurants/dibsList.jsp");
		return "index";
	}
}
