package com.soldesk.jan05.restaurants;

import java.util.List;

public interface RestaurantsMapper {
	public abstract List<Restaurants> getAllDibs(); // 파라미터로 r_m_id필요(or member클래스전체) => 로그인한 회원의 찜목록만
	
	// 임시작성
	public abstract List<Restaurants> getAllRestaurants();
	public abstract List<Restaurants> getAllVisit();
}
