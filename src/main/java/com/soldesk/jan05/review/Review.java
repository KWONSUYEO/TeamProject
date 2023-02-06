package com.soldesk.jan05.review;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



public class Review {
	private String m_id;
	private BigDecimal rr_no; // 글 번호
	private String rr_txt; // 글 내용
	private Date rr_when; // 날짜
	private String rr_color; // 색깔
	
	private List<ReviewReply> rr_replys;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String m_id, BigDecimal rr_no, String rr_txt, Date rr_when, String rr_color,
			List<ReviewReply> rr_replys) {
		super();
		this.m_id = m_id;
		this.rr_no = rr_no;
		this.rr_txt = rr_txt;
		this.rr_when = rr_when;
		this.rr_color = rr_color;
		this.rr_replys = rr_replys;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public BigDecimal getRr_no() {
		return rr_no;
	}

	public void setRr_no(BigDecimal rr_no) {
		this.rr_no = rr_no;
	}

	public String getRr_txt() {
		return rr_txt;
	}

	public void setRr_txt(String rr_txt) {
		this.rr_txt = rr_txt;
	}

	public Date getRr_when() {
		return rr_when;
	}

	public void setRr_when(Date rr_when) {
		this.rr_when = rr_when;
	}

	public String getRr_color() {
		return rr_color;
	}

	public void setRr_color(String rr_color) {
		this.rr_color = rr_color;
	}

	public List<ReviewReply> getRr_replys() {
		return rr_replys;
	}

	public void setRr_replys(List<ReviewReply> rr_replys) {
		this.rr_replys = rr_replys;
	}
	
	
	
	
	
}
