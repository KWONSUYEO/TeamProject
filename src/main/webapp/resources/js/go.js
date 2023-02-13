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
	location.href = "dibs.memo";
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

function restSearch(restName){
	location.href = "search/" + restName;
}