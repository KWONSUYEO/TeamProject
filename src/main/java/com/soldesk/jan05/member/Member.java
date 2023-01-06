package com.soldesk.jan05.member;

public class Member {
	private String m_id;
	private String m_password;
	private String m_nickname;
	private String m_category;
	private String m_recommendation;
	private String m_phone;
	private String m_email;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String m_id, String m_password, String m_nickname, String m_category, String m_recommendation,
			String m_phone, String m_email) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_nickname = m_nickname;
		this.m_category = m_category;
		this.m_recommendation = m_recommendation;
		this.m_phone = m_phone;
		this.m_email = m_email;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_category() {
		return m_category;
	}
	public void setM_category(String m_category) {
		this.m_category = m_category;
	}
	public String getM_recommendation() {
		return m_recommendation;
	}
	public void setM_recommendation(String m_recommendation) {
		this.m_recommendation = m_recommendation;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

}
