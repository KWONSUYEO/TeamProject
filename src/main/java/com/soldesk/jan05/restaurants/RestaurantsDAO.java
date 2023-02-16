package com.soldesk.jan05.restaurants;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk.jan05.detail.DetailDAO;
import com.soldesk.jan05.member.Member;

@Service
public class RestaurantsDAO {
	
	@Autowired
	private SqlSession ss;
	
	private String[] addrFirst = {"서울특별시", "강원도", "경기도", "경상남도", "경상북도", 
								  "광주광역시", "대구광역시", "대전광역시", "부산광역시", "세종특별자치시", 
								  "울산광역시", "인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도"};

	// [찜목록]화면 정보세팅
	public void getAllDibs(Member m, HttpServletRequest req) {
		try {
			// [dibs]객체에 찜한 맛집정보 세팅
			List<Restaurants> dibs = ss.getMapper(RestaurantsMapper.class).getAllDibs(m);
			req.setAttribute("dibs", dibs);
			this.setLocCnt(dibs, req);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// [찜목록]화면 지역별로 찜한 맛집정보세팅
	public void getLocDibs(Restaurants r, HttpServletRequest req) {
		try {
			// [dibs]객체에 지역별로 찜한 맛집정보 세팅
			List<Restaurants> dibs = ss.getMapper(RestaurantsMapper.class).getLocDibs(r);
			req.setAttribute("dibs", dibs);
			this.setLocCnt(dibs, req);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 지역별 맛집갯수 세팅
	private void setLocCnt(List<Restaurants> rs, HttpServletRequest req) {

		int suCnt = 0; // 서울특별시
		int gwCnt = 0; // 강원도
		int ggCnt = 0; // 경기도
		int gsnCnt = 0; // 경상남도
		int gsbCnt = 0; // 경상북도
		int gjCnt = 0; // 광주광역시
		int dgCnt = 0; // 대구광역시
		int djCnt = 0; // 대전광역시
		int bsCnt = 0; // 부산광역시
		int sjCnt = 0; // 세종특별자치시
		int usCnt = 0; // 울산광역시
		int icCnt = 0; // 인천광역시
		int jlnCnt = 0; // 전라남도
		int jlbCnt = 0; // 전라북도
		int jjCnt = 0; // 제주특별자치도
		int ccnCnt = 0; // 충청남도
		int ccbCnt = 0; // 충청북도
		
		// 맛집의 지역을 확인해 각 지역별로 카운팅
		for (Restaurants d : rs) {
			String[] addr = d.getR_addr().split(" ");
			for (int i = 0; i < addrFirst.length; i++) {
				if (addrFirst[i].equals(addr[0])) {
					if (i == 0) { // 서울특별시
						suCnt++;
					} else if (i == 1) { // 강원도
						gwCnt++;
					} else if (i == 2) { // 경기도
						ggCnt++;
					} else if (i == 3) { // 경상남도
						gsnCnt++;
					} else if (i == 4) { // 경상북도
						gsbCnt++;
					} else if (i == 5) { // 광주광역시
						gjCnt++;
					} else if (i == 6) { // 대구광역시
						dgCnt++;
					} else if (i == 7) { // 대전광역시
						djCnt++;
					} else if (i == 8) { // 부산광역시
						bsCnt++;
					} else if (i == 9) { // 세종특별자치시
						sjCnt++;
					} else if (i == 10) { // 울산광역시
						usCnt++;
					} else if (i == 11) { // 인천광역시
						icCnt++;
					} else if (i == 12) { // 전라남도
						jlnCnt++;
					} else if (i == 13) { // 전라북도
						jlbCnt++;
					} else if (i == 14) { // 제주특별자치도
						jjCnt++;
					} else if (i == 15) { // 충청남도
						ccnCnt++;
					} else if (i == 16) { // 충청북도
						ccbCnt++;
					} else {
						// Do Nothing
					}
				}
			}
		}
		
		// 카운팅한 값 세팅
		req.setAttribute("suCnt", suCnt); req.setAttribute("gwCnt", gwCnt); req.setAttribute("ggCnt", ggCnt);
		req.setAttribute("gsnCnt", gsnCnt); req.setAttribute("gsbCnt", gsbCnt); req.setAttribute("gjCnt", gjCnt);
		req.setAttribute("dgCnt", dgCnt); req.setAttribute("djCnt", djCnt); req.setAttribute("bsCnt", bsCnt);
		req.setAttribute("sjCnt", sjCnt); req.setAttribute("usCnt", usCnt); req.setAttribute("icCnt", icCnt);
		req.setAttribute("jlnCnt", jlnCnt); req.setAttribute("jlbCnt", jlbCnt); req.setAttribute("jjCnt", jjCnt);
		req.setAttribute("ccnCnt", ccnCnt); req.setAttribute("ccbCnt", ccbCnt); 
		
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
	
}
