package com.soldesk.jan05.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.jan05.TokenMaker;
import com.soldesk.jan05.member.MemberDAO;

@Controller
public class ReviewController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private ReviewDAO rrDAO;
	
	private boolean isFirstReq;
	
	public ReviewController() {
		isFirstReq = true;
	}
	
	@RequestMapping(value = "/review.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if(isFirstReq) {
			rrDAO.countAllMsg();
			isFirstReq =false;
		}
		mDAO.loginCheck(req);
		rrDAO.searchClear(req);
		rrDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("main", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.delete", method = RequestMethod.GET)
	public String reviewPage(HttpServletRequest req) {
		mDAO.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		rrDAO.getMsg(p, req);
		TokenMaker.makeToken(req);
		req.setAttribute("main", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.reply.delete", method = RequestMethod.GET)
	public String reviewReplyDelete(ReviewReply rr, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			rrDAO.deleteReply(rr, req);
		}
		rrDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("main", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.reply.write", method = RequestMethod.POST)
	public String reviewReplyWrite(ReviewReply rr, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			rrDAO.writeReply(rr, req);
		}
		rrDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("main", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.search", method = RequestMethod.POST)
	public String reviewSearch(HttpServletRequest req) {
		mDAO.loginCheck(req);
		rrDAO.searchMsg(req);
		rrDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("main", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.update", method = RequestMethod.GET)
	public String reviewUpdate(Review rm, HttpServletRequest req) {
		if(mDAO.loginCheck(req)) {
			rrDAO.updateMsg(rm, req);
		}
		rrDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("main", "review/review.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/review.write", method = RequestMethod.POST)
	public String reviewWrite(Review rm, HttpServletRequest req) {
		if(mDAO.loginCheck(req)) {
			rrDAO.writeMsg(rm, req);
		}
		rrDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("main", "review/review.jsp");
		return "index";
	}
	
}
