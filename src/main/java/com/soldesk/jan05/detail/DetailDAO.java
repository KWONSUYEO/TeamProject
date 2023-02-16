package com.soldesk.jan05.detail;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk.jan05.restaurants.Restaurants;

@Service
public class DetailDAO {

	@Autowired
	private SqlSession ss;
	
	// 맛집정보검색
	public void searchRest(String restName, HttpServletRequest req) {
		
		String encRestName = ""; // (인코딩)맛집이름
		String url = "";
		
		// 맛집 상호명을 URL용으로 인코딩
		try {
			// 해당 상호명으로 검색한 결과 url세팅
			encRestName = URLEncoder.encode(restName, "UTF-8");
			url = "https://www.mangoplate.com/search/" + encRestName;

			// 검색결과 페이지 가져오기
			Document doc = Jsoup.connect(url).get();
			Elements hrefEle = doc.select("a[class=\"only-desktop_not\"]");
			String restHref = hrefEle.attr("abs:href");
			
			// 첫번째 검색결과에서 가져온 href로 url 재설정
			url = restHref;
			doc = Jsoup.connect(url).get();
			
			// 가게 상세정보 가져오기
			Element restEle = doc.getElementsByClass("info").first();
			Elements rowList = restEle.getAllElements();
			Detail det = new Detail();
			
			// 가게정보 [det]객체에 세팅
			det.setRestName(restName); // 가게이름
			for(int i = 0; i < rowList.size(); i++) {
//				System.out.println(i + "번째)" + rowList.get(i).text());
				
				if (rowList.get(i).text().equals("주소")) {
					det.setAddr(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("전화번호")) {
					det.setTel(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("음식 종류")) {
					det.setCategory(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("가격대")) {
					det.setPriceRange(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("주차")) {
					det.setParking((rowList.get(i + 1).text()));
					
				} else if (rowList.get(i).text().equals("영업시간")) {
					det.setOpenHours(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("마지막주문")) {
					det.setLastOrder(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("휴일")) {
					det.setHoliday(rowList.get(i + 1).text());
					
				} else {
					continue;
				}
			}
			
			// [detail]객체에 세팅한 맛집상세정보 세팅
			req.setAttribute("detail", det);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception: " + e );
		}
		
		
	}

	// 맛집 찜하기
	public void regiDibs(Restaurants r, HttpServletRequest req) {

		int maxNo = ss.getMapper(DetailMapper.class).getMaxNo(r) + 1;
		Restaurants restTmp = searchTemp(r.getR_restName());
		
		r.setR_level("1");
		r.setR_no(maxNo);
		r.setR_restName(restTmp.getR_restName());
		r.setR_addr(restTmp.getR_addr());
		r.setR_tel(restTmp.getR_tel());
		r.setR_category(restTmp.getR_category());
		r.setR_priceRange(restTmp.getR_priceRange());
		r.setR_parking(restTmp.getR_parking());
		r.setR_openHours(restTmp.getR_openHours());
		r.setR_lastOrder(restTmp.getR_lastOrder());
		r.setR_holiday(restTmp.getR_holiday());
		
		Restaurants regedRest = ss.getMapper(DetailMapper.class).getRest(r);
		
		if (regedRest == null) {

			if (ss.getMapper(DetailMapper.class).regDibs(r) == 1) {
				req.setAttribute("dodibs_res", "성공");
			} else {
				req.setAttribute("dodibs_res", "실패");
			}

		} else {
			req.setAttribute("dodibs_res", "중복");
		}
		
	}
	
	// 찜 대상객체 세팅
	public Restaurants searchTemp(String restName) {

		String encRestName = ""; // (인코딩)맛집이름
		String url = "";
		
		// 맛집 상호명을 URL용으로 인코딩
		try {
			// 해당 상호명으로 검색한 결과 url세팅
			encRestName = URLEncoder.encode(restName, "UTF-8");
			url = "https://www.mangoplate.com/search/" + encRestName;

			// 검색결과 페이지 가져오기
			Document doc = Jsoup.connect(url).get();
			Elements hrefEle = doc.select("a[class=\"only-desktop_not\"]");
			String restHref = hrefEle.attr("abs:href");
			
			// 첫번째 검색결과에서 가져온 href로 url 재설정
			url = restHref;
			doc = Jsoup.connect(url).get();
			
			// 가게 상세정보 가져오기
			Element restEle = doc.getElementsByClass("info").first();
			Elements rowList = restEle.getAllElements();
			Restaurants res = new Restaurants();
			
			res.setR_restName(restName); // 가게이름
			for(int i = 0; i < rowList.size(); i++) {
				
				if (rowList.get(i).text().equals("주소")) {
					res.setR_addr(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("전화번호")) {
					res.setR_tel(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("음식 종류")) {
					res.setR_category(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("가격대")) {
					res.setR_priceRange(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("주차")) {
					res.setR_parking((rowList.get(i + 1).text()));
					
				} else if (rowList.get(i).text().equals("영업시간")) {
					res.setR_openHours(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("마지막주문")) {
					res.setR_lastOrder(rowList.get(i + 1).text());
					
				} else if (rowList.get(i).text().equals("휴일")) {
					res.setR_holiday(rowList.get(i + 1).text());
					
				} else {
					continue;
				}
			}
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception: " + e);
		}
		return null;
		
	}
	
	
		
			
}
