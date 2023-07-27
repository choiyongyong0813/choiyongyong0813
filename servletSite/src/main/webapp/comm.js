/**
 * 공통자바스크립트파일
 */
function loadingFocus(e) {
	e.focus();
}
function isNull(v1) {
	if (v1 == "") {
		return true;
	}
	return false;
}
function isSame(v1, v2) {
	if (v1 == v2) {
		return true;
	}
	return false;
}



//두개의 폼에 입력된 값이 같은지 비교(비밀번호, 비밀번호 확인)
/*
function isSame(obj1, obj2) {
	var str1 = obj1.value;
	var str2 = obj2.value;
	if(str1.length == 0 || str2.length == 0)
		return false;

	if(str1 == str2)
		return true;
	return false;
}
*/

//폼에 입력된 내용의 길이가 원하는 길이보다 짧은지의 여부 
function isShort(obj, len, msg) {
	var str = obj.value;
	if(str.length < len) {
		if(msg) {
			alert(msg);	
		}
		obj.focus();
		obj.select();
		return true;
	}
	return false;
}

//영문으로 입력되었는지의 여부
function isAlphabet(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	str = str.toUpperCase();
	for(var i=0; i < str.length; i++) {
		if(!('A' <= str.charAt(i) && str.charAt(i) <= 'Z'))
			return false;
	}
	return true;
}

//폼에 입력된 내용이 아이디로 적당한지의 여부..
function isID(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	str = str.toUpperCase();
	if(!('A' <= str.charAt(0) && str.charAt(0) <= 'Z'))
		return false;

	for(var i=1; i < str.length; i++) {
		if(!(('A' <= str.charAt(i) && str.charAt(i) <= 'Z') ||
			('0' <= str.charAt(i) && str.charAt(i) <= '9') ||
			(str.charAt(i) == '_')))
			return false;
	}
	return true;
}

//폼에 입력된 내용이 이메일로 적당한지의 여부..
function isEmail(obj) {
	var str = obj.value;
	if(str == "")
		return false;

	var i = str.indexOf("@");
	if(i < 0)
		return false;

	i = str.indexOf(".");
	if(i < 0)
		return false;
	
	return true;
}



function is_null( string )
{
 if( string == "" )
     return  true;
 return  false;
}


function is_space( string )
{
	for( var i = 0; i < string.length; i++ )
		if( string.charAt( i ) != ' ' )
	        	return  false;
 	return  true;
}

function is_numeric( string )
{
	if( is_null( string ) )
		return false;

	for( var i = 0; i < string.length; i++ ) {
		if( string.charAt( i ) >= '0' && string.charAt( i ) <= '9' )
			continue;
		else
			return	false;
	}
	return	true;
}









