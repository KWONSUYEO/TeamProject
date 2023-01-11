package com.soldesk.jan05.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	public Members idCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMember(m));
	}
	
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/welcome.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
	
	public void login(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			List<Member> ms = ss.getMapper(MemberMapper.class).getMember(m);
			if (ms.size() != 0) {
				Member m1 = ms.get(0);
				if (m1.getM_id().equals(m.getM_id())) {
					req.getSession().setAttribute("loginMember", m1);
					req.getSession().setMaxInactiveInterval(60*10); 
					Cookie c = new Cookie("lastLoginID", m1.getM_id());
					c.setMaxAge(60*60*24*5);
					res.addCookie(c);
					req.setAttribute("r", "로그인 완료");
				} else {
					req.setAttribute("r", "패스워드가 일치하지 않습니다");
				}
			} else {
				req.setAttribute("r", "존재하지 않는 아이디 입니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "에러");
		}
	}
	
	public void signup(Member m, HttpServletRequest req) {
		try {
			m.setM_id(req.getParameter("m_id"));
			m.setM_password(req.getParameter("m_password"));
			m.setM_nickname(req.getParameter("m_nickname"));
			m.setM_location(req.getParameter("m_location"));
			
			if (ss.getMapper(MemberMapper.class).join(m)==1) {
				req.setAttribute("r", "회원가입을 축하드립니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "회원가입 실패");
		}
	}
	
	public void update(Member m, HttpServletRequest req) {
		try { // id는 변경 불가
			m.setM_password(req.getParameter("m_password"));
			m.setM_nickname(req.getParameter("m_nickname"));
			m.setM_location(req.getParameter("m_location"));
			
			if (ss.getMapper(MemberMapper.class).update(m)==1) {
				req.setAttribute("r", "정보변경 완료");
				req.getSession().setAttribute("loginMember", m);
				req.getSession().setAttribute("loginMember", m);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "정보변경 실패");
		}
	}
	
	public void withdraw(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			if (ss.getMapper(MemberMapper.class).withdraw(m)==1) {
				req.setAttribute("r", "탈퇴가 완료되었습니다 서비스를 이용해주셔서 감사합니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴 실패");
		}
	}
}
