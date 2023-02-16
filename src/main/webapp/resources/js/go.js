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
	location.href = "search." + restName;
}

//function dodibs(detail) {
//	let f = document.createElement('form');
//	
//	let obj;
//	obj = document.createElement('input');
//	obj.setAttribute(detail);
//	
//	f.appendChild(obj);
//	f.setAttribute('method', 'post');
//	f.setAttribute('action', 'do.dibs');
//	document.body.appendChild(f);
//	f.submit();
//}
function dodibs(detail) {

	$.ajax({
		type :"post",
		url :"/do.dibs",
		data : {
			level : "1",
			name : detail.restName,
			addr : detail.addr,
			tel : detail.tel,
			category : detail.category,
			priceRange : detail.priceRange,
			parking : detail.parking,
			openHours : detail.openHours,
			holiday : detail.holiday
		},
		success : function(data) {
			alert("???");
		},
		error : function() {
			alert("error");
		}
	});
	
}
//$(document).ready(function() {
//	  // "찜하기" 버튼 클릭 시
//	  $('#doDibs').click(function(e) {
//	    e.preventDefault(); // 기본 동작 중단
//	    
//	    // 데이터 전송
//	    $.ajax({
//	      type: 'POST',
//	      url: 'dibsList.jsp',
//	      data: { 유저명 : '상품명' },
//	      success: function() {
//	        alert('찜 목록에 추가되었습니다!');
//	      },
//	      error: function() {
//	        alert('찜하기 실패!');
//	      }
//	    });
//	  });
//	});