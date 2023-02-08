<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/review.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/KwonValidChecker.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>

</head>
<body>
	<table class="menuTitle">
		<tr>
			<td><a href="go">HOME</a></td>
			<td><a href="info.go">회원정보</a></td>
			<td><a href="dibs.go">찜목록</a></td>
			<td><a href="review.go">방문후기</a></td>
		</tr>
	</table>

	<table class="LoginArea">
		<tr>
			<td><jsp:include page="${loginPage }" /></td>
			<td><div id="r">
					<h1>${r }</h1>
				</div></td>
			<td><div id="dr">
					<h5>${dr }</h5>
				</div></td>
		</tr>
	</table>

	<table>
		<tr>
			<td class="mainPage" align="center"><jsp:include page="${main }" />
			</td>
		</tr>
	</table>
	
</body>
</html>