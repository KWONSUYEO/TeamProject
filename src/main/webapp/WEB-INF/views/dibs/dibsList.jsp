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
	<table id="dibs1" border="1"> <!-- id의 숫자는 찜 객체의 순서로 넘버링 -->
		<tr id="dibs1_Title">
			<td>찜목록</td>
		</tr>
		<tr>
			<td id="dibs1_Info">
				찜한 가게의 정보(맛집 테이블에서 가져오기)
			</td>
		</tr>
		<tr>
			<td id="dibs1_Memo">
				찜한 가게에 대한 메모(코멘트)
			</td>
		</tr>
	</table>
	
</body>
</html>