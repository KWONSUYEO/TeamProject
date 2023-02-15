package com.soldesk.jan05.detail;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk.jan05.member.MemberDAO;

@Service
public class DetailDAO {
	
	@Autowired
	private MemberDAO mDAO;
	
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
					// "도로명주소 [지번] 지번주소"로 되기에 [ 지번 ]으로 split
					String[] adr = rowList.get(i + 1).text().split(" 지번 ");
					
					String addr = "";
					if (adr.length > 1) { // 지번으로 split된 경우
						addr = adr[0] + "\n" + adr[1];
					} else { // 지번으로  split이 안된 경우
						addr = adr[0];
					}
					det.setAddr(addr);
					for (String string : adr) {
						System.out.println(string);
					}	
					
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

	
		
		
		
	
	
}
