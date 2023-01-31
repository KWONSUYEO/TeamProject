package com.soldesk.jan05.restaurants;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.jan05.member.Member;
import com.soldesk.jan05.member.MemberDAO;

@Controller
public class RestaurantsController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private RestaurantsDAO rDAO;

	// [찜목록]화면 전체 맛집정보세팅
	@RequestMapping(value = "/dibs.go", method = RequestMethod.GET)
	public String dibsList(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			rDAO.getAllDibs(m, req);
			req.setAttribute("main", "restaurants/dibsList.jsp");
		} else {
			req.setAttribute("main", "home.jsp");
		}
		return "index";
	}

	// [찜목록]화면 지역별 맛집정보세팅
	@RequestMapping(value = "{addr}", method = RequestMethod.GET)
	public String dibsListWithAddr(@PathVariable String addr, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			// 지역별 맛집을 검색하기 위한 정보세팅 - r_m_id(회원ID), r_addr({addr} = 도단위 주소)
			Member m = (Member) req.getSession().getAttribute("loginMember");
			Restaurants r = new Restaurants();
			r.setR_m_id(m.getM_id());
			r.setR_addr(addr);
			
			rDAO.getLocDibs(r, req);
			req.setAttribute("main", "restaurants/dibsList.jsp");
			
		} else {
			req.setAttribute("main", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/dibs.memo", method = RequestMethod.POST)
	public String dibsMemo(Restaurants r, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			Restaurants rs = new Restaurants(); 
			rs.setR_m_id(m.getM_id());
			rs.setR_no(r.getR_no());
			rs.setR_memo(r.getR_memo());
			rDAO.dibsMemo(rs, req);
			rDAO.getAllDibs(m, req);
			req.setAttribute("main", "restaurants/dibsList.jsp");			
		} else {
			req.setAttribute("main", "home.jsp");
		}
		return "index";
	}
}
