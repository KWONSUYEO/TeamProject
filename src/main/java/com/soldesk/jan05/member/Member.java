package com.soldesk.jan05.member;

public class Member {
	private String m_id;
	private String m_password;
	private String m_nickname;
	private String m_location;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, String m_password, String m_nickname, String m_location) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_nickname = m_nickname;
		this.m_location = m_location;
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

	public String getM_location() {
		return m_location;
	}

	public void setM_location(String m_location) {
		this.m_location = m_location;
	}
}