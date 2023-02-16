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
	<tr><th><h1>나의 정보</h1></th></tr>
	<tr><td>ID <input name="m_id" value="${sessionScope.loginMember.m_id }" readonly="readonly"></td></tr>
	<tr><td>PW <input name="m_password" value="${sessionScope.loginMember.m_password }" 
		autofocus="autofocus" autocomplete="off" type="password"></td></tr>
	<tr><td>PW확인 <input name="m_passwordChk" value="${sessionScope.loginMember.m_password }" 
		autocomplete="off" type="password"></td></tr>
	<tr><td>닉네임 <input name="m_nickname" value="${sessionScope.loginMember.m_nickname }"></td></tr>
	<tr><td align="center" colspan="2">선호지역 <select name="m_location">
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
	<table class="loc_cnt">
	<tr><th align="center"><h1>찜한 정보</h1></th></tr>
		<tr>
			<td><a id="loc_a" href="/dibs.go/서울특별시">서울특별시(${suCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/강원도">강원도(${gwCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/경기도">경기도(${ggCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="/dibs.go/경상남도">경상남도(${gsnCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/경상북도">경상북도(${gsbCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/광주광역시">광주광역시(${gjCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="/dibs.go/대구광역시">대구광역시(${dgCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/대전광역시">대전광역시(${djCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/부산광역시">부산광역시(${bsCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="/dibs.go/세종특별자치시">세종특별자치시(${sjCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/울산광역시">울산광역시(${usCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/인천광역시">인천광역시(${icCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="/dibs.go/전라남도">전라남도(${jlnCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/전라북도">전라북도(${jlbCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/제주특별자치도">제주특별자치도(${jjCnt })</a></td>
		</tr>
		<tr>
			<td><a id="loc_a" href="/dibs.go/충청남도">충청남도(${ccnCnt })</a></td>
			<td><a id="loc_a" href="/dibs.go/충청북도">충청북도(${ccbCnt })</a></td>
		</tr>
	</table>
</body>
</html>