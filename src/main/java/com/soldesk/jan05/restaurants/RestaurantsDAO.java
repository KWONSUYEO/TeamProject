package com.soldesk.jan05.restaurants;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantsDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAllDibs(HttpServletRequest req) {
		try {
			// [dibs]객체에 찜한 맛집정보 세팅
			// 로그인한 회원정보 필요!!
			req.setAttribute("dibs", ss.getMapper(RestaurantsMapper.class).getAllDibs());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 임시작성
	
	// 맛집테이블 전체 조회
	public void getAllRestaurants(HttpServletRequest req) {
		try {
			// [rests]객체에 전체 맛집정보 세팅
			req.setAttribute("rests", ss.getMapper(RestaurantsMapper.class).getAllDibs());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllVisit(HttpServletRequest req) {
		try {
			// [visits]객체에 방문한 맛집정보 세팅
			req.setAttribute("visits", ss.getMapper(RestaurantsMapper.class).getAllDibs());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
