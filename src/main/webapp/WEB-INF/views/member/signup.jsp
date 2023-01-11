<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup.jsp</title>
</head>
<body>
<form action="member.join" method="post" name="signup" onsubmit="return signupCheck()">
<table id="joinTbl">
			<tr>
				<td align="center" colspan="2"><input id="join_m_id" name="m_id" placeholder="ID를 입력하세요" class="i1" autocomplete="off" autofocus="autofocus" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password" name="m_password" placeholder="비밀번호를 입력하세요" class="i1" autocomplete="off" maxlength="20"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="password" name="m_passwordCh" placeholder="비밀번호를 한번더 입력하세요" class="i1" autocomplete="off" maxlength="20"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="m_nickname" placeholder="닉네임을 입력하세요" class="i1" autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">선호지역<select name="m_location">
				<option>강원도</option>
				<option>경기도</option>
				<option>경상남도</option>
				<option>경상북도</option>
				<option>광주광역시</option>
				<option>대구광역시</option>
				<option>대전광역시</option>
				<option>부산광역시</option>
				<option>서울특별시</option>
				<option>세종특별자치시</option>
				<option>울산광역시</option>
				<option>인천광역시</option>
				<option>전라남도</option>
				<option>전라북도</option>
				<option>제주특별자치도</option>
				<option>충청남도</option>
				<option>충청북도</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>가입하기</button></td>
			</tr>
		</table>
</form>
</body>
</html>