<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜목록</title>
</head>
<body>
	<table id="dibs_Title">
		<tr><td><h1>찜목록</h1></td></tr>
	</table>

	<!-- 아래 테이블을 회원이 가지고 있는 찜 갯수만큼 for로 반복 -->
	<C:forEach var="d" items="${dibs }">
		<table class="dibsList" border="1">
			<tr class="dibs_Title">
				<th>${d.r_restName }</th>
			</tr>
			<tr>
				<td class="dibs_Info">
					${d.r_addr }/${d.r_tel }/${d.r_category }/${d.r_priceRange }/${d.r_openHours }
				</td>
			</tr>
			<tr>
				<td class="dibs_Memo">
					찜한 가게에 대한 메모(코멘트)
				</td>
			</tr>
		</table>
	</C:forEach>
	
</body>
</html>