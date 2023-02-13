package com.soldesk.jan05.detail;

public class Detail {
	private String restName;
	private String addr;
	private String tel;
	private String category;
	private String priceRange;
	private String parking;
	private String openHours;
	private String lastOrder;
	private String holiday;
	
	public Detail() {
		// TODO Auto-generated constructor stub
	}
	
	public Detail(String restName, String addr, String tel, String category, String priceRange, String parking,
			String openHours, String lastOrder, String holiday) {
		super();
		this.restName = restName;
		this.addr = addr;
		this.tel = tel;
		this.category = category;
		this.priceRange = priceRange;
		this.parking = parking;
		this.openHours = openHours;
		this.lastOrder = lastOrder;
		this.holiday = holiday;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getOpenHours() {
		return openHours;
	}

	public void setOpenHours(String openHours) {
		this.openHours = openHours;
	}

	public String getLastOrder() {
		return lastOrder;
	}

	public void setLastOrder(String lastOrder) {
		this.lastOrder = lastOrder;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

}
