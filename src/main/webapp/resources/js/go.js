function Signup(){
	location.href ="member.signup.go";
}

function Infogo(){
	location.href ="info.go";
}

function Logout(){
	var real = confirm("로그아웃 하시겠습니까?");
	if(real) {
		location.href = "member.logout";
	}
}

function withdraw(){
	var real = confirm("탈퇴를 진행하시겠습니까?");
	if(real){
		location.href = "member.withdraw";
	}
}