<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	
	<!-- 도단위 맛집개수 표시 -->
	<table class="loc_cnt">
		<tr>
			<td><a class="loc_a" href="서울특별시">서울특별시(${suCnt })</a></td>
			<td><a id="loc_a" href="강원도">강원도(${gwCnt })</a></td>
			<td><a id="loc_a" href="경기도">경기도(${ggCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="경상남도">경상남도(${gsnCnt })</a></td>
			<td><a id="loc_a" href="경상북도">경상북도(${gsbCnt })</a></td>
			<td><a id="loc_a" href="광주광역시">광주광역시(${gjCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="대구광역시">대구광역시(${dgCnt })</a></td>
			<td><a id="loc_a" href="대전광역시">대전광역시(${djCnt })</a></td>
			<td><a id="loc_a" href="부산광역시">부산광역시(${bsCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="세종특별자치시">세종특별자치시(${sjCnt })</a></td>
			<td><a id="loc_a" href="울산광역시">울산광역시(${usCnt })</a></td>
			<td><a id="loc_a" href="인천광역시">인천광역시(${icCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="전라남도">전라남도(${jlnCnt })</a></td>
			<td><a id="loc_a" href="전라북도">전라북도(${jlbCnt })</a></td>
			<td><a id="loc_a" href="제주특별자치도">제주특별자치도(${jjCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="충청남도">충청남도(${ccnCnt })</a></td>
			<td><a id="loc_a" href="충청북도">충청북도(${ccbCnt })</a></td>
		</tr>
	</table>

	<C:forEach var="d" items="${dibs }">
		<form action="dibs.memo" method="post" name="memoForm${d.r_memo }" onsubmit="dibsMemo()">
			<table class="dibsList${d.r_no }" border="1">
				<tr class="dibs_Title">
					<td id="r_restName">${d.r_restName }</td>
					<td><input type="hidden" name="r_no" value="${d.r_no }"></td>
				</tr>
				<tr>
					<td class="dibs_Info">
						${d.r_addr }/${d.r_tel }/${d.r_category }/${d.r_priceRange }/${d.r_openHours }
					</td>
				</tr>
				<tr>
					<td class="dibs_Memo">
						<C:choose>
							<C:when test="${not empty d.r_memo }">
								<input type="text" name="r_memo" value="${d.r_memo }"><button id="btnDibs">등록</button>
							</C:when>
							<C:otherwise>
								<input type="text" name="r_memo" placeholder="메모를 입력하세요"><button id="btnDibs">등록</button>
							</C:otherwise>
						</C:choose>
					</td>
				</tr>
			</table>
		</form>
	</C:forEach>
	
</body>
</html>