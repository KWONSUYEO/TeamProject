function signupCheck(){
	let m_id = document.signup.m_id;
	let m_password = document.signup.m_password;
	let m_passwordCh = document.signup.m_passwordCh;
	let m_nickname = document.signup.m_nickname;
	let m_location = document.signup.m_location;
	
	if(isEmpty(m_id)||containsAnother(m_id)){
		alert("id를 다시 입력하세요")
		m_id.focus();
		m_id.value="";
		return false;
		
		}else if(isEmpty(m_password) || notEqualPw(m_password,m_passwordCh)){
		alert("pw를 다시 입력하세요");
		m_password.focus();
		m_password.value="";
		m_passwordCh.value="";
		return false;
		
		} else if(isEmpty(m_nickname)){
			alert("닉네임을 다시 입력하세요");
			m_nickname.focus();
			m_nickname.value="";
			return false;
		} else if(isEmpty(m_location)){
			alert("선호하는 지역을 선택하세요");
			m_location.focus();
			m_location.value="";
			return false;
		}
	return true;
}

function connectIdCheckEvent(){
	$("#join_m_id").keyup(function() {
		var m_id = $(this).val();
		$.getJSON("member.id.check?m_id="+m_id, function(memberJSON){
			if (memberJSON.member[0] == null) {
				$("#join_m_id").css("color", "black");
			} else {
				$("#join_m_id").css("color", "red");
			}
		});
	});
}

$(function() {
	connectIdCheckEvent();
});

function UpdateCheck(){
	let m_id = document.signup.m_id;
	let m_password = document.signup.m_password;
	let m_passwordCh = document.signup.m_passwordCh;
	let m_nickname = document.signup.m_nickname;
	let m_location = document.signup.m_location;
	
	if(isEmpty(m_id)||containsAnother(m_id)){
		alert("id를 다시 입력하세요")
		m_id.focus();
		m_id.value="";
		return false;
		
		} else if(isEmpty(m_password) || notEqualPw(m_password,m_passwordCh)){
		alert("pw를 다시 입력하세요");
		m_password.focus();
		m_password.value="";
		m_passwordCh.value="";
		return false;
		
		} else if(isEmpty(m_nickname)){
			alert("닉네임을 다시 입력하세요");
			m_nickname.focus();
			m_nickname.value="";
			return false;
		} else if(isEmpty(m_location)){
			alert("선호하는 지역을 선택하세요");
			m_location.focus();
			m_location.value="";
			return false;
		}
	return true;
}

