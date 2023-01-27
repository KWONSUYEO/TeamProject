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

function dibsMemo(){
//	var restName = document.getElementById("r_restName").innerText;
	
//	sessionStorage.setItem("r_restName", restName);
//	element.setAttribute( "r_restName", restName );
//	var real = confirm(restName);
	location.href = "dibs.memo";
//	return true;
	
}