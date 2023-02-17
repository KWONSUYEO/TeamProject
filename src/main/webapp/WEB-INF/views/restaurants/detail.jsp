<%@page import="com.soldesk.jan05.restaurants.Restaurants"%>
<%@page import="com.soldesk.jan05.detail.Detail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 상세정보</title>
<link rel="stylesheet" href="/jan05/resources/css/index.css">
<link rel="stylesheet" href="/jan05/resources/css/review.css">
<script type="text/javascript" src="/jan05/resources/js/jQuery.js"></script>
<script type="text/javascript" src="/jan05/resources/js/KwonValidChecker.js"></script>
<script type="text/javascript" src="/jan05/resources/js/go.js"></script>
<script type="text/javascript" src="/jan05/resources/js/check.js"></script>

</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		Detail d = (Detail) request.getAttribute("detail");
		Restaurants r = new Restaurants();
		// 상세정보 페이지에 있는 내용을 찜등록용 클래스에 저장
		//System.out.println(d.getRestName());
		//System.out.println(d.getAddr());
		//System.out.println(d.getTel());
		//System.out.println(d.getCategory());
		//System.out.println(d.getPriceRange());
		//System.out.println(d.getParking());
		//System.out.println(d.getOpenHours());
		//System.out.println(d.getHoliday());
		//r.setR_level("1"); r.setR_restName(d.getRestName()); r.setR_addr(d.getAddr());
		//r.setR_tel(d.getTel()); r.setR_category(d.getCategory()); r.setR_priceRange(d.getPriceRange());
		//if(d.getParking() != null) {
//			r.setR_parking(d.getParking());
		//}
		//if(d.getOpenHours() != null) {
			//r.setR_openHours(d.getOpenHours());
		//}
		//if(d.getHoliday() != null) {
			//r.setR_holiday(d.getHoliday());
		//}
		
		session.setAttribute("detail_rest", r);
		
	%>
	<script type="text/javascript">
		
	</script>
				<form action="do.dibs">
	<table id="detail_Title" border="1">
		<tr><td><input name="rn" value="${detail.restName }"></input></td>
			<td>
					<button>등록</button>
				</form>
			</td>
		</tr>

		<C:choose>
			<C:when test="${not empty detail.addr }">
				<tr><td>주소</td>
					<td>${detail.addr }</td>
				</tr>
			</C:when>
		</C:choose>
		<C:choose>
			<C:when test="${not empty detail.tel }">
				<tr><td>전화번호</td><td>${detail.tel }</td></tr>
			</C:when>
		</C:choose>
		<C:choose>
			<C:when test="${not empty detail.category }">
				<tr><td>음식 종류</td><td>${detail.category }</td></tr>
			</C:when>
		</C:choose>
		<C:choose>
			<C:when test="${not empty detail.priceRange }">
				<tr><td>가격대</td><td>${detail.priceRange }</td></tr>
			</C:when>
		</C:choose>
		<C:choose>
			<C:when test="${not empty detail.parking }">
				<tr><td>주차</td><td>${detail.parking }</td></tr>
			</C:when>
		</C:choose>
		<C:choose>
			<C:when test="${not empty detail.openHours }">
				<tr><td>영업시간</td><td>${detail.openHours }</td></tr>
			</C:when>
		</C:choose>
		<C:choose>
			<C:when test="${not empty detail.lastOrder }">
				<tr><td>마지막주문</td><td>${detail.lastOrder }</td></tr>
			</C:when>
		</C:choose>
		<C:choose>
			<C:when test="${not empty detail.holiday }">
				<tr><td>휴일</td><td>${detail.holiday }</td></tr>
			</C:when>
		</C:choose>
	</table>

</body>
</html>