<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
</head>
<body>
<table>
<form action="member.update" method="post" name="updateForm" onsubmit="return UpdateCheck()">
	<tr><th>정보조회</th></tr>
	<tr><td>ID<input name="m_id" value="${sessionScope.loginMember.m_id }" readonly="readonly"></td></tr>
	<tr><td>PW<input name="m_password" value="${sessionScope.loginMember.m_password }" 
		autofocus="autofocus" autocomplete="off" type="password"></td></tr>
	<tr><td>PW확인<input name="m_passwordChk" value="${sessionScope.loginMember.m_password }" 
		autocomplete="off" type="password"></td></tr>
	<tr><td>닉네임<input name="m_nickname" value="${sessionScope.loginMember.m_nickname }"></td></tr>
	<tr><td align="center" colspan="2">선호지역<select name="m_location">
				<option>서울특별시</option>
				<option>강원도</option>
				<option>경기도</option>
				<option>경상남도</option>
				<option>경상북도</option>
				<option>광주광역시</option>
				<option>대구광역시</option>
				<option>대전광역시</option>
				<option>부산광역시</option>
				<option>세종특별자치시</option>
				<option>울산광역시</option>
				<option>인천광역시</option>
				<option>전라남도</option>
				<option>전라북도</option>
				<option>제주특별자치도</option>
				<option>충청남도</option>
				<option>충청북도</option>
				</select></td></tr>
	<tr><td><button>정보수정</button>
	</form>
	<button onclick="withdraw()">탈퇴</button></td></tr>
</table>
</body>
</html>