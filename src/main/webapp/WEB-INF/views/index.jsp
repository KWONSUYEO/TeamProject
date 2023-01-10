<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="resources/css/index.css">
</head>
<body>

	<table class="menuTitle">
		<tr>
			<td><a href="go">HOME</a></td>
			<td><a href="info.go">회원정보</a></td>
			<td><a href="#">찜목록</a></td>
			<td><a href="#">방문기록</a></td>
		</tr>
	</table>

	<table>
		<tr><td class="mainPage" align="center">
		<jsp:include page="${main }"/></td></tr>
	</table>






</body>
</html>