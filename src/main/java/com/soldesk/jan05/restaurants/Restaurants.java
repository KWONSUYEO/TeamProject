package com.soldesk.jan05.restaurants;

public class Restaurants {
	private String r_level;
	private String r_restName;
	private String r_m_id;
	private String r_addr;
	private String r_tel;
	private String r_category;
	private String r_priceRange;
	private String r_parking;
	private String r_openHours;
	private String r_lastOrder;
	private String r_holiday;
	public Restaurants() {
		// TODO Auto-generated constructor stub
	}
	public Restaurants(String r_level, String r_restName, String r_m_id, String r_addr, String r_tel, String r_category,
			String r_priceRange, String r_parking, String r_openHours, String r_lastOrder, String r_holiday) {
		super();
		this.r_level = r_level;
		this.r_restName = r_restName;
		this.r_m_id = r_m_id;
		this.r_addr = r_addr;
		this.r_tel = r_tel;
		this.r_category = r_category;
		this.r_priceRange = r_priceRange;
		this.r_parking = r_parking;
		this.r_openHours = r_openHours;
		this.r_lastOrder = r_lastOrder;
		this.r_holiday = r_holiday;
	}
	public String getR_level() {
		return r_level;
	}
	public void setR_level(String r_level) {
		this.r_level = r_level;
	}
	public String getR_restName() {
		return r_restName;
	}
	public void setR_restName(String r_restName) {
		this.r_restName = r_restName;
	}
	public String getR_m_id() {
		return r_m_id;
	}
	public void setR_m_id(String r_m_id) {
		this.r_m_id = r_m_id;
	}
	public String getR_addr() {
		return r_addr;
	}
	public void setR_addr(String r_addr) {
		this.r_addr = r_addr;
	}
	public String getR_tel() {
		return r_tel;
	}
	public void setR_tel(String r_tel) {
		this.r_tel = r_tel;
	}
	public String getR_category() {
		return r_category;
	}
	public void setR_category(String r_category) {
		this.r_category = r_category;
	}
	public String getR_priceRange() {
		return r_priceRange;
	}
	public void setR_priceRange(String r_priceRange) {
		this.r_priceRange = r_priceRange;
	}
	public String getR_parking() {
		return r_parking;
	}
	public void setR_parking(String r_parking) {
		this.r_parking = r_parking;
	}
	public String getR_openHours() {
		return r_openHours;
	}
	public void setR_openHours(String r_openHours) {
		this.r_openHours = r_openHours;
	}
	public String getR_lastOrder() {
		return r_lastOrder;
	}
	public void setR_lastOrder(String r_lastOrder) {
		this.r_lastOrder = r_lastOrder;
	}
	public String getR_holiday() {
		return r_holiday;
	}
	public void setR_holiday(String r_holiday) {
		this.r_holiday = r_holiday;
	}
}
