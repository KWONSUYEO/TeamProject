<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 상세정보</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/review.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/KwonValidChecker.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>

</head>
<body>
	<table id="detail_Title" border="1">
		<tr><td><h1>${detail.restName }</h1></td><td><a id="doDibs" href="do.dibs">찜하기</a></td></tr>

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