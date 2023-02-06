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

function reviewMsgDelete(no) {
	if (confirm("삭제")) {
		location.href = "review.delete?rr_no=" + no;
	}
}

function reviewMsgUpdate(no, txt) {
	txt = prompt("할 말", txt);
	if (txt != null && txt.length > 0 && txt.length < 250) {
		location.href = "review.update?rr_no=" + no + "&rr_txt=" + txt;
	}
}
function reviewPage(page) {
	location.href = "review.page?p=" + page;
}
function reviewReplyDelete(no) {
	if (confirm("삭제?")) {
		location.href = "review.reply.delete?cr_no=" + no;
	}
}