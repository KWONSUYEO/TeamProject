package com.soldesk.jan05.review;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk.jan05.SiteOption;
import com.soldesk.jan05.member.Member;



@Service
public class ReviewDAO {
	private int allMsgCount;
	private String[] colors;

	@Autowired
	private SqlSession ss;

	@Autowired
	private SiteOption so;

	public ReviewDAO() { // writeMsg method에서 활용!
		colors = new String[] { "#F44336", "#43A047", "#FF9800", "#795548", "#E91E63", "#009688" };
	}

	public void countAllMsg() {
		allMsgCount = ss.getMapper(ReviewMapper.class).getAllMsgCount();
	}

	public void deleteMsg(Review rm, HttpServletRequest req) {
		try {
			if (ss.getMapper(ReviewMapper.class).deleteMsg(rm) == 1) {
				req.setAttribute("r", "글삭제성공");
				allMsgCount--;
			} else {
				req.setAttribute("r", "글삭제실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "글삭제실패");
		}
	}

	public void deleteReply(ReviewReply rr, HttpServletRequest req) {
		try {
			if (ss.getMapper(ReviewMapper.class).deleteReply(rr) == 1) {
				req.setAttribute("r", "댓글삭제성공");
			} else {
				req.setAttribute("r", "댓글삭제실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글삭제실패");
		}
	}

	public void getMsg(int page, HttpServletRequest req) {
		req.setAttribute("curPage", page);

		String search = (String) req.getSession().getAttribute("search"); // 검색어
		int msgCount = 0;
		if (search == null) { // 전체조회
			msgCount = allMsgCount;
			search = "";
		} else { // 검색
			ReviewSelector rSel2 = new ReviewSelector(search, 0, 0);
			msgCount = ss.getMapper(ReviewMapper.class).getSearchMsgCount(rSel2);
		}
		
		
		int allPageCount = (int) Math.ceil((double) msgCount / so.getReviewMsgPerPage());
		req.setAttribute("allPageCount", allPageCount); 

		int start = (page - 1) * so.getReviewMsgPerPage() + 1;
		int end = (page == allPageCount) ? msgCount : start + so.getReviewMsgPerPage() - 1;
		
		
		ReviewSelector rSel = new ReviewSelector(search, start, end);
		
		List<Review> reviews = ss.getMapper(ReviewMapper.class).getMsg(rSel);

		for (Review review : reviews) {
			review.setRr_replys(ss.getMapper(ReviewMapper.class).getReply(review));
		}
		req.setAttribute("msgs", reviews);
	}

	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}

	public void updateMsg(Review rm, HttpServletRequest req) {
		try {
			if (ss.getMapper(ReviewMapper.class).updateMsg(rm) == 1) {
				req.setAttribute("r", "글수정성공");
			} else {
				req.setAttribute("r", "글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글수정실패");
		}
	}

	public void writeMsg(Review rm, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");

			String st2 = (String) req.getSession().getAttribute("st");

			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "글쓰기실패(새로고침)");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			rm.setM_id(m.getM_id());
			rm.setRr_color(colors[new Random().nextInt(colors.length)]);
			String txt = rm.getRr_txt();
			txt = txt.replace("\r\n", "<br>");
			rm.setRr_txt(txt);

			if (ss.getMapper(ReviewMapper.class).writeMsg(rm) == 1) {
				req.setAttribute("r", "글쓰기성공");
				req.getSession().setAttribute("st", token);
				allMsgCount++;
			} else {
				req.setAttribute("r", "글쓰기실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "글쓰기실패");
		}
	}

	public void writeReply(ReviewReply rr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String st2 = (String) req.getSession().getAttribute("st");
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "댓글쓰기실패(새로고침)");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			rr.setCr_owner(m.getM_id());

			if (ss.getMapper(ReviewMapper.class).writeReply(rr) == 1) {
				req.setAttribute("r", "댓글쓰기성공");
				req.getSession().setAttribute("st", token);
			} else {
				req.setAttribute("r", "댓글쓰기실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글쓰기실패");
		}
	}
}

