package com.soldesk.jan05.restaurants;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/dibs.go", method = RequestMethod.GET)
	public String dibsist(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			rDAO.getAllDibs(m, req);
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
