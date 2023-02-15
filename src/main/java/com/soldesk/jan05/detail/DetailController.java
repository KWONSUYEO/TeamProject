package com.soldesk.jan05.detail;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.jan05.member.Member;
import com.soldesk.jan05.member.MemberDAO;
import com.soldesk.jan05.restaurants.RestaurantsDAO;

@Controller
public class DetailController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private DetailDAO dDAO;
	@Autowired
	private RestaurantsDAO rDAO;
	
	// 맛집상세정보페이지로 이동
	@RequestMapping(value = "/search/{restName}", method = RequestMethod.GET)
	public String restGo(@PathVariable String restName, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			dDAO.searchRest(restName, req);
			req.setAttribute("main", "restaurants/detail.jsp");
		} else {
			dDAO.searchRest(restName, req);
			req.setAttribute("main", "restaurants/detail.jsp");
		}
		return "index";
	}
	
	
	
	
	// [찜목록]화면 전체 맛집정보세팅
	@RequestMapping(value = "/do.dibs", method = RequestMethod.GET)
	public String regDibs(Detail d, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			rDAO.getAllDibs(m, req);
			req.setAttribute("main", "restaurants/dibsList.jsp");
		} else {
			req.setAttribute("main", "home.jsp");
		}
		return "index";
	}

	
}
