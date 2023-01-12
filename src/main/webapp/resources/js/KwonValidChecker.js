
function isEmpty(input){
	return (!input.value);
}


function containsAnother(input){
	let pass = "1234567890qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM@_.";
	let iv = input.value;
	for(let i = 0; i<iv.length;i++){
		if(pass.indexOf(iv[i])==-1){ 
			return true;
		}
	}
	return false;
}

function email(input){
	let e = "@"
	let iv = input.value;
	for(let i=0;i<iv.length;i++){
		if(pw.indexOf(iv[i])==-1){
			return true;
		}
	}
	return false;
		}


function atLeastLetter(input,len){
	return (input.value.length < len);
}


function notEqualPw(input1, input2){
	return (input1.value != input2.value);
}


function notContain(input,passSet){
	let iv = input.value;
	for(let i = 0; i < passSet.length; i++){
		if(iv.indexOf(passSet[i]) != -1);
		return false;
	}
	return true;
}


function isNotNumber(input){
	return isNaN(input.value);
}


function isNotType(input,type){
	// .jpg, .gif,...
	type = "." + type;
	return(input.value.indexOf(type)==-1);
}
