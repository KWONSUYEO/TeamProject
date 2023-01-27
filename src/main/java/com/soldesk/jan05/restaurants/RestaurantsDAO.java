package com.soldesk.jan05.restaurants;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk.jan05.member.Member;

@Service
public class RestaurantsDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAllDibs(Member m, HttpServletRequest req) {
		try {
			// [dibs]객체에 찜한 맛집정보 세팅
			req.setAttribute("dibs", ss.getMapper(RestaurantsMapper.class).getAllDibs(m));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dibsMemo(Restaurants r, HttpServletRequest req) {
		try {
			// [dibs]객체에 찜한 맛집에 대한 메모 등록
			System.out.println(r.getR_m_id());
			System.out.println(r.getR_no());
			System.out.println(r.getR_memo());
			if (ss.getMapper(RestaurantsMapper.class).dibsMemo(r) == 1) {
				req.setAttribute("dr", "찜한 맛집 [No." + r.getR_no() + "] 메모등록 완료");
				System.out.println("찜한 맛집 [No." + r.getR_no() + "] 메모등록 완료");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("dr", "찜한 맛집 [No." + r.getR_no() + "] 메모등록 실패");
			System.out.println("찜한 맛집 [No." + r.getR_no() + "] 메모등록 실패");
		}
	}
	
	
	// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 임시작성
	
	// 맛집테이블 전체 조회
	public void getAllRestaurants(HttpServletRequest req) {
		try {
			// [rests]객체에 전체 맛집정보 세팅
			req.setAttribute("rests", ss.getMapper(RestaurantsMapper.class).getAllRestaurants());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllVisit(HttpServletRequest req) {
		try {
			// [visits]객체에 방문한 맛집정보 세팅
			req.setAttribute("visits", ss.getMapper(RestaurantsMapper.class).getAllVisit());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
