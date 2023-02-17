package com.soldesk.jan05.detail;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.jan05.member.Member;
import com.soldesk.jan05.member.MemberDAO;
import com.soldesk.jan05.restaurants.Restaurants;

@Controller
public class DetailController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private DetailDAO dDAO;
	
	// 맛집상세정보페이지로 이동
	@RequestMapping(value = "/search.{restName}", method = RequestMethod.GET)
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
	public String regDibs(HttpServletRequest req) {
		
		Restaurants r = new Restaurants();
		r.setR_restName(req.getParameter("rn"));
		
		if (mDAO.loginCheck(req)) {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			r.setR_m_id(m.getM_id());
			
			System.out.println("로그인상태로 찜하기");
			System.out.println(req.getParameter("rn"));
			
			dDAO.searchRest(r.getR_restName(), req);
			dDAO.regiDibs(r, req);
			
			req.setAttribute("main", "restaurants/detail.jsp");
		} else {
			
			System.out.println("비 로그인상태로 찜하기");
			System.out.println(req.getParameter("rn"));

			dDAO.searchRest(r.getR_restName(), req);
			
			req.setAttribute("main", "restaurants/detail.jsp");
			req.setAttribute("dodibs_res", "비로그인");
		}
		return "index";
	}

	
}
