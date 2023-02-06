<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문후기</title>
</head>
<body>
	<table id="review_Title">
		<tr><td><h1>방문후기</h1></td></tr>
	</table>
	<c:if test="${curPage != 1 }">
		<table id="L">
			<tr>
				<td align="center" onclick="reviewPage(${curPage - 1 });">&lt;</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${curPage != allPageCount }">
		<table id="R">
			<tr>
				<td align="center" onclick="reviewPage(${curPage + 1 });">&gt;</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${sessionScope.loginMember != null }">
		<table id="WriteArea">
			<tr>
				<td align="center">
					<form action="review.write" name="WriteForm"
						onsubmit="reviewWriteCheck();" method="post">
						<input name="token" value="${token }">
						<table id="WriteTable">
							<tr>
								<td id="swtTd1"><textarea name="rr_txt" placeholder="후기 작성"
										maxlength="250"></textarea></td>
								<td id="swtTd2"><input type="image"
									src="resources/img/write.png" style="width: 30px;"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="review.search" name="reviewSearchForm"
						onsubmit="reviewSearchCheck();" method="post">
						<table id="SearchTable">
							<tr>
								<td id="sstTd1"><input name="search" maxlength="10"
									autocomplete="off" placeholder="찾기"></td>
								<td id="sstTd2"><input type="image"
									src="resources/img/search.png" style="width: 30px;"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</c:if>
	<c:forEach var="rm" items="${msgs }">
		<table class="rm" style="box-shadow: 5px 5px 5px ${rm.rr_color};">
			<tr>
				<td class="rmOwner" style="color: ${rm.rr_color};">${rm.m_id }</td>
			</tr>
			<tr>
				<td class="rmDate" align="right"><fmt:formatDate
						value="${rm.rr_when }" type="both" dateStyle="long"
						timeStyle="short" /></td>
			</tr>
			<tr>
				<td class="rmTxt">${rm.rr_txt }</td>
			</tr>
			<tr>
				<td id="rmReplyArea"><c:forEach var="rr"
						items="${rm.rr_replys }">
						<c:choose>
							<c:when test="${rr.cr_owner == sessionScope.loginMember.m_id }">
								<span ondblclick="reviewReplyDelete('${rr.cr_no}');"
									class="rmReplyID" style="color:${rm.rr_color}; cursor:pointer;">${rr.cr_owner }</span>
							</c:when>
							<c:otherwise>
								<span class="rmReplyID" style="color:${rm.rr_color}">${rr.cr_owner }</span>
							</c:otherwise>
						</c:choose>
						${rr.cr_txt }(<fmt:formatDate value="${rr.cr_when }" type="both"
							dateStyle="short" timeStyle="short" />)<br>
					</c:forEach> <c:if test="${sessionScope.loginMember != null }">
						<hr color="${rm.rr_color }">
						<form action="review.reply.write" method="post"
							onsubmit="reviewReplyWriteCheck(this);">
							<input name="token" value="${token }"> <input
								name="cr_rr_no" value="${rm.rr_no }"> <span
								class="rmReplyID" style="color:${rm.rr_color}">${sessionScope.loginMember.m_id }</span>
							<input name="cr_txt"
								style="border-bottom:${rm.rr_color} solid 2px;" maxlength="100"
								placeholder="댓글" autocomplete="off">
							<button style="color: ${rm.rr_color}; font-weight:900;">쓰기</button>
						</form>
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><c:if
						test="${rm.m_id == sessionScope.loginMember.m_id }">
						<button onclick="reviewMsgUpdate(${rm.rr_no}, '${rm.rr_txt }');"
							style="color: ${rm.rr_color};">수정</button>
						<button onclick="reviewMsgDelete(${rm.rr_no});"
							style="color: ${rm.rr_color};">삭제</button>
					</c:if></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>