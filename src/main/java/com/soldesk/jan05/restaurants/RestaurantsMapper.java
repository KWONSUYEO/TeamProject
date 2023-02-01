package com.soldesk.jan05.restaurants;

import java.util.List;

import com.soldesk.jan05.member.Member;

public interface RestaurantsMapper {
	public abstract List<Restaurants> getAllDibs(Member m);
	public abstract int dibsMemo(Restaurants r);
	public abstract List<Restaurants> getLocDibs(Restaurants r);
	
	// 임시작성
	public abstract List<Restaurants> getAllRestaurants();
	public abstract List<Restaurants> getAllVisit();
}
