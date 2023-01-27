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
								<input type="text" name="r_memo" value="${d.r_memo }"><button id="btnDibs${d.r_no }">등록</button>
							</C:when>
							<C:otherwise>
								<input type="text" name="r_memo" placeholder="메모를 입력하세요"><button id="btnDibs${d.r_no }">등록</button>
							</C:otherwise>
						</C:choose>
					</td>
				</tr>
			</table>
		</form>
	</C:forEach>
	
</body>
</html>