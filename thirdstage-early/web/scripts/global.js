//@version 1.7, 2002/12/13
//@version 1.6, 2002/11/05
//@version 1.5.1, 2002/09/10
//@version 1.5, 2002/07/03
//@version 1.2, 2002/03/06
//@version 1.1, 2002/01/09
//@version 1.0, 2000/02/19
//@since 1999/09/15
//@Author Sang-Moon Oh


/**
 * 키보드의 F5 글쇠가 눌러지는 것을 막아서 새로고침을 할 수 없도록 한다.
 * 일반적으로 BODY tag의 onKeyDown event handler에 다음과 같이 사용한다.
 *
 * 	...
 * 	<BODY onKeyDown='JavaScript:return preventF5Key(event)' ...>
 * 	...
 * 
 * @since 1.7
 */
function preventF5Key(ev){

	if(ev.keyCode == 116){
		alert("이 페이지에서는 새로고침을 사용하실 수 없습니다.")
		ev.keyCode = 0
		return false
	}
	else return true
}


/**
 * 브라우저에서 오른쪽 마우스를 눌러 context popup menu가 보이는 것을 막는다.
 * 페이지에서 오른쪽 마우스를 눌러 '새로고침'이나 '뒤로'와 같은 동작을 막기 위해서 사용한다.
 * 	...
 * 	<BODY onMouseDown='JavaScript:return preventMouseRightButton(event)' ...>
 * 	...
 *
 * @since 1.7
 */
function preventMouseRightButton(ev){

	if(ev.button == 2){
		alert("이 페이지에서는 마우스 오른쪽 단추를 사용하실 수 없습니다.")
		return false
	}
	else return true
}


/**
 * 지정된 INPUT field가 지정된 길이가 되면 다음 INPUT field로 focus를 
 * 가져간다.
 * currentElement는 text 또는 password type의 INPUT field이어야 한다.
 * currentElement에 해당하는 INPUT field의 onKeyUp event handler에 다음과
 * 같은 형식으로 사용하도록 한다.
 *
 * 	...
 * 	<INPUT type='text' name='regNo1' size='6' maxlength='6'
 * 	       onKeyUp='JavaScript:moveFocusAtMaxLength(this, 6, document.forms['joinForm'].elements['regNo2'])'>
 * 	- 
 * 	<INPUT type='text' name='regNo2' size='7' maxlength='7'>
 * 	...
 *
 * @since 1.7
 */
function moveFocusAtMaxLength(currentElement, maxLen, nextElement){
	
	if(currentElement.value == null) return
	if(nextElement.value == null) return

	if(currentElement.value.length >= maxLen) nextElement.focus()
}


/**
 * 주어진 Event 객체의 key가 숫자를 유지하도록 하는 글쇠인지 확인한다.
 * 0 ~ 9 사이의 숫자, Backspace 등의 Key로 인한 event가 지정되면 true를 돌려준다.
 * INPUT element에 오직 숫자만이 입력가능하도록 하려로 할 때 onKeyPress event handler
 * 에 다음과 같이 지정하여 사용할 수 있다. INPUT element에서 onKeyDown event handler에
 * 사용하면 tab 글쇠, 좌우 화살표 글쇠를 사용할 수 없게 되므로 onKeyPress에 적용하도록
 * 한다.
 * Internet Explorer 4.0, Nescape Navigator 4.0 이상에서 정상적으로 작동한다.
 *       
 *       ...
 *       <INPUT type='text' name='amount' onKeyPress='JavaScript:return isDigitKeepingKey(event)'>
 *       ...
 *
 * @since 1.6
*/
function isDigitKeepingKey(e) {
	
	var isIE = (document.all) ? true: false //Internet Exploerer인가?
	var isNN = (document.layers) ? true: false //Netscape인가?

	if(!isIE && !isNN) return false

	var keyValue;
	if(isIE)keyValue = e.keyCode
	else if(isNN) keyValue = e.which
	
	// 0 ~ 9까지의 숫자, 화살표 또는 back space만을 허용한다.
	// Decimal ASCII code로 48 ~ 57(0 ~ 9) 또는 8(Backspace)
	if(((keyValue > 47) && (keyValue < 58)) || keyValue == 8) return true
	else return false
}



/**
 * 주어진 문자열에 포함된 모든 단일따옴표를 제거한 문자열을 돌려준다.
 *
 * @since 1.6
*/
function removeSingleQuotationMarks(str){
	
	if(str == null) return str
	else if(str.length == 0) return str
	else return str.replace(/\'/g,"")
}


/**
 * 주어진 문자열에 포함된 모든 comma (,)를 제거한 문자열을 돌려준다.
 *
 * @since 1.6
*/
function removeCommas(str){
	if(str == null) return str
	else if(str.length == 0) return str
	else return str.replace(/\,/g, "")
}


/*
 주어진 그림 파일들을 메모리에 load한다.
 MouseOver event로 그림파일을 바꾸는 등의 작업을 할 때 바뀔 그림을 미리 가져오는 등의 
 작업을 위해서 사용한다.
 Parameter에는 load할 그림파일들의 url들을 list하면 된다.
 다음과 같은 방식으로 사용한다.
 
	... 
	imgPreload("../images/menu1-on.gif", "../images/menu2-on.gif", "../images/menu3-on.gif")
	...
*/
function imgPreload(){
	var imgFiles = imgPreload.arguments
	var imgNum = imgFiles.length
	var imgs = new Array()

	for(var i = 0; i < imgNum; i++){
		imgs[i] = new Image()
		imgs[i].src = imgFiles[i]
	}
}



/*
 지정한 <IMG> tag의 source를 지정한 파일로 바꾼다.
 다음과 같이 사용한다.
 
	...
	imgSwap(document.all("menuImg1"), "../menu1-off")
	...
*/ 
function imgSwap(targetImg, imgSrc){
	targetImg.src = imgSrc
}



/*
 주어진 문자열 앞뒤의 공백문자(space, tab, form feed, line feed 문자)들을 제거한 문자열을 가져온다.
 문자열 중간의 공백문자들은 변함이 없으며, 앞뒤의 공백문자들은
 갯수에 상관없이 모두 제거한다.
 주어진 문자열에 한글이 포함되어도 문제없이 동작한다.
 
 @since 1.5
*/
function trimString(str){
	return str.replace(/^\s+|\s+$/g, "")
}



/*
 주어진 문자열이 정수 형식인지를 점검한다.
 문자열 맨 앞의 - 부호, 또는 0아닌 숫자 앞의 0들은 문제가 되지 않는다.
 문자열 맨 앞의 '-' 이외에 숫자가 아닌 문자가 포함될 경우 false를 돌려준다.
 빈문자열이나 공백문자를 포함한 문자열의 경우에도 false를 돌려준다.
 Java의 Integer.parseInt와 호환성을 가진다.
 JavaScript의 parseInt는 Java의 Integer.parseInt와 호환성이 없다.
 
 @since 1.5
*/
function isInt(str){
	if(str.length == 0 || str == "") return false
	
	if(str.search(/[^0-9]/g) != -1){
		if(str.charAt(0) == "-"){
			if(str.length == 1) return false //주어진 문자열이 "-"인 경우
			else if(str.substring(1, str.length).search(/[^0-9]/g) != -1) return false
			else return true
		}
		else return false
	}	
	else return true
}



/* 
 주어진 문자열이 양의 정수 형식인지 점검한다.
 문자열 앞 부분의 0들은 문제가 되지 않는다.
 숫자가 아닌 문자가 포함될 경우 false를 돌려준다.
 빈문자열이나 공백문자를 포함한 문자열의 경우에도 false를 돌려준다.
 Java의 Integer.parseInt와 호환성을 가진다.
 JavaScript의 parseInt는 Java의 Integer.parseInt와 호환성이 없다.
 
 @since 1.5
*/
function isPositiveInt(str){
	if(str.length == 0 || str == "") return false //빈 문자열의 경우,
	else if(str.search(/[^0-9]/g) != -1) return false
	else if(str.search(/[^0]/g) == -1) return false //0으로만 이루어진 경우,
	else return true
}	


/*
 주어진 문자열이 0 또는 양의 정수 형식인지 점검한다.
 문자열 앞 부분의 0들은 문제가 되지 않는다. 예를 들어 '0000', '0123' 등은 
 true 값을 가진다.
 빈문자열이나 공백문자를 포함한 문자열의 경우에도 false를 돌려준다.
 
 @since 1.5.1
*/
function isNonnegativeInt(str){
	if(str.length == 0 || str == "") return false //빈 문자열의 경우,
	else if(isPositiveInt(str)) return true
	else if(str.search(/[^0]/g) == -1) return true //0으로만 이루어진 경우
	else return false
}

/* 
 주어진 문자열이 올바른 사용자 ID 형식인지 점검한다.
 사용자 ID의 길이는 4 ~ 7자 사이여야 하며, 알파벳 또는 숫자들로만 구성되어야 한다.
 문자열 앞뒤의 공백들은 무시하고 점검한다.
 올바른 사용자 형식일 경우 true를, 그렇지 않을 경우 false를 돌려준다.
*/
function isVaildUserId(idStr){
	if(idStr == null) return false

	var re = /^\s+|\s+$/g //입력값의 앞뒤 공백문자들을 제거하기 위한 regular expression
	var id = idStr.replace(re, "") //입력값의 앞뒤 공백문자 제거 

	if((id.length < 4) || (id.length > 7)) return false
	
	re = /[^A-Za-z0-9]/g //알파벳, 또는 숫자가 아닌 문자를 위한 regular experssion
	if(id.search(re) != -1) return false
	
	return true
}



/*
 주어진 문자열이 올바른 비밀번호 형식인지 점검한다.
 비밀번호의 길이는 4 ~ 12자 사이여야 하며, 알파벳 또는 숫자들로만 구성되어야 한다.
 문자열 앞, 뒤 또는 중간의 공백들도 같이 점검한다.
 올바른 비밀번호 형식일 경우 true를, 그렇지 않을 경우 false를 돌려준다.
*/
function isValidPassword(passwdStr){
	var re = /[^A-Za-z0-9]/g //알파벳, 또는 숫자가 아닌 문자를 위한 regular experssion
	
	if(passwdStr == null) return false
	else if(passwdStr.search(re) != -1) return false
	else if((passwdStr.length < 4) || (passwdStr.length > 12)) return false
	else return true
}

	
	
/*
 주어진 문자열이 올바른 email 주소 형식인지 점검한다.
 올바른 email 주소 형식일 경우 true를, 그렇지 않을 경우 false를 돌려준다.
*/
function isValidEmail(emailStr){
	if(emailStr == null) return false
	else if(emailStr.length < 3) return false
	else if(emailStr.indexOf("@") < 1) return false
	else if(emailStr.indexOf("@") > (emailStr.length - 2)) return false
	else return true
}



/* 
 주민등록번호 점검
 주어진 문자열이 올바른 주민등록번호 형식인지 점검한다.
 올바른 주민등록번호 형식일 경우 true를, 그렇지 않은 경우 false를 돌려준다.
*/
function isValidSSN(ssnStr){
	if(ssn.length != 13) return false

	var p = ssn.substring(6, 7)
	if(p < '0' || p > '2') return false
	
	var sum = 0, q = 0
	for(var i = 0; i < 12; i++){
		p = ssn.substring(i, i + 1)
		sum += q*(p - '0')
		if(++q == 10) q = 2
	}
	
	q = (11 - (sum % 11)) % 10
	p = ssn.substring(12, 13)
	
	if(q != p) return false
	else return true
}



/*
  연도 생성 : 연도 선택을 위한 <optiom> tag 부분을 dynamic하게 생성
  기본 선택값을 지정하여 주면 그 앞,뒤로 3년의 offset을 두고 <select>안에 들어갈 <option> 부분을 생성한다.
  다음과 같은 방식으로 사용한다.
  
  		...
  		<SELECT name='fromYear'>
  			<SCRIPT language='JavaScript'>generateYear("2001")</SCRIPT>
  		</SELECT>
  		...
  
 @param choosedYear 기본적으로 선택될 연도 문자열. 
                    빈문자열("")을 주면 현재 연도가 선택된다.
                    "-1"을 주면 맨위 option은 비어있고 기본적으로 이 빈 option이 선택된 상태가 된다. 
                    빈 option의 value 속성값은 -1이다.
*/
function generateYear(choosedYear){
	if(choosedYear != "" && (isNaN(choosedYear) || parseInt(choosedYear) < -1)) return false
	
	var YEAR_OFFSET = 3
	var thisYear = (new Date()).getYear()
	if(thisYear < 100)	thisYear += 1900

	if(choosedYear != "") selectedYear = choosedYear
	else selectedYear = thisYear

	if(choosedYear == "-1")	document.write("<OPTION selected value='-1'></OPTION>")
	
	for(var i = thisYear + YEAR_OFFSET; i >= thisYear - 5; i--){
		if(i != parseInt(selectedYear)) document.write("<OPTION value='" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='" + i + "'>" + i + "</OPTION>")
	}
}



/*
  연도 생성 : 연도 선택을 위한 <option> tag 부분을 dynamic하게 생성
  시작 연도, 끝 연도, 선택 연도를 지정하여 주면 여기에 맞는 <select>안에 들어갈 <option> 부분을 생성한다.
  다음과 같은 방식으로 사용한다.
  
  		...
  		<SELECT name='fromYear'>
  			<SCRIPT language='JavaScript'>generateYear2("1995", "2002", "2001")</SCRIPT>
  		</SELECT>
  		...

 @param startYear 시작 연도 문자열
 @param endYear 끝 연도 문자열
 @param choosedYear 기본적으로 선택될 연도 문자열.
                    "-1"을 주면 맨위 option은 비어있고 기본적으로 이 빈 option이 선택된 상태가 된다. 
                    빈 option의 value 속성값은 -1이다.
 @since 1.2
*/
function generateYear2(startYear, endYear, choosedYear){
	if(isNaN(startYear) || parseInt(startYear) < 0) return false
	if(isNaN(endYear) || parseInt(endYear) < 0) return false
	if(isNaN(choosedYear) || parseInt(choosedYear) < -1) return false
	
	if(choosedYear == "-1") document.write("<OPTION selected value='-1'></OPTION>")
	
	for(var i = endYear; i >= startYear; i--){
		if(i != parseInt(choosedYear)) document.write("<OPTION value='" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='" + i + "'>" + i + "</OPTION>")
	}
}



/*
  월 생성 : 월 선택을 위한 <option> tag 부분을 dynamic하게 생성
  기본 선택값을 주면 이 값을 선택한, 1월부터 12월까지의 <option> tag들을 자동으로 생성한다.
  각 option은 화면에 보이는 text는 1, 2, 3, ..., 11, 12 이지만 value 속성값은 01, 02, ..., 11, 12 등을 가진다. 
  
  		...
  		<SELECT name='fromMonth'>
  			<SCRIPT language='JavaScript'>generateMonth("3")</SCRIPT>
  		</SELECT>
  		...

 @param choosedMonth 기본적으로 선택될 월 문자열
                     빈문자열("")을 주면 현재 월이 선택된다.
                     "-1"을 주면 맨위 option은 비어있고 기본적으로 이 빈 option이 선택된 상태가 된다. 
                     빈 option의 value 속성값은 -1이다.	
*/
function generateMonth(choosedMonth){
	//validates input
	
	if(!isNaN(choosedMonth)){
		//var temp = parseInt(choosedMonth) //parseInt('08') returns 0 at IE 6.0, which seems to a bug !!
		//if(temp > 12 || temp == 0 || temp < -1) return false
	}
	else if(choosedMonth != "") return false
	
	//end of input validation
	
	var selectedMonth = choosedMonth
	if(selectedMonth.substring(0, 1) == "0") selectedMonth = selectedMonth.substring(1, 2)
	if(choosedMonth == "") selectedMonth = ((new Date()).getMonth() + 1).toString()

	if(choosedMonth == "-1") document.write("<OPTION selected value='-1'></OPTION>")

	for(var i = 1; i < 10; i++){
		if(i != parseInt(selectedMonth)) document.write("<OPTION value='0" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='0" + i + "'>" + i + "</OPTION>")
	}
	for(var i = 10; i < 13; i++){
		if(i != parseInt(selectedMonth)) document.write("<OPTION value='" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='" + i + "'>" + i + "</OPTION>")
	}
}



/*
  일 생성 : 일 선택을 위한 <option> tag 부분을 dynamic하게 생성
  기본 선택값을 주면 이 값을 선택한, 1일부터 31일까지의 <option> tag들을 자동으로 생성한다.
  각 option은 화면에 보이는 text는 1, 2, 3, ..., 30, 31 이지만 value 속성값은 01, 02, ..., 30, 31 등을 가진다. 
  
  		...
  		<SELECT name='fromDay'>
  			<SCRIPT language='JavaScript'>generateDay("3")</SCRIPT>
  		</SELECT>
  		...

 @param choosedMonth 기본적으로 선택될 일 문자열
                     빈문자열("")을 주면 현재 일이 선택된다.
                     "-1"을 주면 맨위 option은 비어있고 기본적으로 이 빈 option이 선택된 상태가 된다. 
                     빈 option의 value 속성값은 -1이다.	
*/
function generateDay(choosedDay){
	//validates input
	if(!isNaN(choosedDay)){
		var temp = parseInt(choosedDay)
		if(temp > 31 || temp == 0 || temp < -1) return false
	}
	else if(choosedDay != "") return false		
	//end of input validation
	
	var selectedDay = choosedDay
	if(selectedDay.substring(0, 1) == "0")	selectedDay = selectedDay.substring(1, 2)
	if(choosedDay == "") selectedDay = ((new Date()).getDate()).toString()

	if(choosedDay == "-1") document.write("<OPTION selected value='-1'></OPTION>")
	
	for(var i = 1; i < 10; i++){
		if(i != parseInt(selectedDay))	document.write("<OPTION value='0" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='0" + i + "'>" + i + "</OPTION>")
	}
	for(var i = 10; i < 32; i++){
		if(i != parseInt(selectedDay))	document.write("<OPTION value='" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='" + i + "'>" + i + "</OPTION>")
	}
}



/*
  시(hour) 생성 : 시(hour) 선택을 위한 <option> tag 부분을 dynamic하게 생성
  기본 선택값을 주면 이 값을 선택한, 0시부터 23시까지의 <option> tag들을 자동으로 생성한다.
  각 option은 화면에 보이는 text는 0, 1, 2, ..., 23, 24 이지만 value 속성값은 00, 01, 02, ..., 23, 24 등을 가진다. 
  
  		...
  		<SELECT name='fromHour'>
  			<SCRIPT language='JavaScript'>generateHour("17")</SCRIPT>
  		</SELECT>
  		...

 @param choosedHour 기본적으로 선택될 시 문자열
                    빈문자열("")을 주면 현재 시가 선택된다.
                    "-1"을 주면 맨위 option은 비어있고 기본적으로 이 빈 option이 선택된 상태가 된다. 
                    빈 option의 value 속성값은 -1이다.	
*/
function generateHour(choosedHour){
	//validates input
	if(!isNaN(choosedHour)){
		var temp = parseInt(choosedHour)
		if(temp > 24 || temp < -1) return false
	}
	else if(choosedHour != "") return false		
	//end of input validation

	var selectedHour = choosedHour
	if(choosedHour == "") selectedHour = ((new Date()).getHours()).toString()
	
	if(choosedHour == "-1") document.write("<OPTION selected value='-1'></OPTION>")

	for(var i = 0; i < 10; i++){
		if(i != parseInt(selectedHour))	document.write("<OPTION value='0" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='0" + i + "'>" + i + "</OPTION>")
	}
	for(var i = 10; i < 24; i++){
		if(i != parseInt(selectedHour))	document.write("<OPTION value='" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='" + i + "'>" + i + "</OPTION>")
	}
}



/*
  분 생성 : 분 선택을 위한 <option> tag 부분을 dynamic하게 생성
  기본 선택값을 주면 이 값을 선택한, 0분부터 59분까지의 <option> tag들을 자동으로 생성한다.
  각 option은 화면에 보이는 text는 0, 1, 2, ..., 58, 59 이지만 value 속성값은 00, 01, 02, ..., 58, 59 등을 가진다. 
  
  		...
  		<SELECT name='fromMinute'>
  			<SCRIPT language='JavaScript'>generateMinute("23")</SCRIPT>
  		</SELECT>
  		...

 @param choosedMinute 기본적으로 선택될 분 문자열
                      빈문자열("")을 주면 현재 분이 선택된다.
                      "-1"을 주면 맨위 option은 비어있고 기본적으로 이 빈 option이 선택된 상태가 된다. 
                      빈 option의 value 속성값은 -1이다.	
*/
function generateMinute(choosedMinute){
	//validates input
	if(!isNaN(choosedMinute)){
		var temp = parseInt(choosedMinute)
		if(temp > 60 || temp < -1) return false
	}
	else if(choosedMinute != "") return false		
	//end of input validation

	var selectedMinute = choosedMinute
	if(choosedMinute == "") selectedMinute = ((new Date()).getMinutes()).toString()
	
	if(choosedMinute == "-1") document.write("<OPTION selected value='-1'></OPTION>")

	for(var i = 0; i < 10; i++){
		if(i != parseInt(selectedMinute))	document.write("<OPTION value='0" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='0" + i + "'>" + i + "</OPTION>")
	}
	for(var i = 10; i < 60; i++){
		if(i != parseInt(selectedMinute))	document.write("<OPTION value='" + i + "'>" + i + "</OPTION>")
		else document.write("<OPTION selected value='" + i + "'>" + i + "</OPTION>")
	}
}



/*
 주어진 문자열을 구분자가 들어간 날짜/시간 형식의 문자열로 변환한다.
 날짜부분에는 구분자로 '/'가 들어가고 시간부분에는 구분자로 ':'가 들어가며, 날짜부분과
 시간부분 사이에는 ' '가 들어간다.
 
 주어진 문자열이 적절하지 않을 경우, 주어진 문자열을 그대로 돌려준다.
 주어진 문자열의 길이에 따라서 다음과 같이 변환된다
 
 	길이             예상 형식          반환값의 형식
	----------------------------------------------------------
	4               MMdd               MM/dd
	6               yyyyMM             yyyy/MM
	8               yyyyMMdd           yyyy/MM/dd
	12              yyyyMMddHHmm       yyyy/MM/dd HH:mm
	14              yyyyMMddHHmmss     yyyy/MM/dd HH:mm:ss
	----------------------------------------------------------
*/
function formatDate(dateStr){
	var result = ""

	if(dateStr.length == 4)	result = dateStr.substring(0, 2) + "/" + dateStr.substring(2, 4)
	else if(dateStr.length == 6) result = dateStr.substring(0, 4) + "/" + dateStr.substring(4, 6)
	else if(dateStr.length == 8) result = formatDate(dateStr.substring(0, 6)) + "/" + dateStr.substring(6, 8)
	else if(dateStr.length == 12) result = formatDate(dateStr.substring(0, 8)) + " " + dateStr.substring(8, 10) + ":" + dateStr.substring(10, 12)
	else if(dateStr.length == 14) result = formatDate(dateStr.substring(0, 12)) + ":" + dateStr.substring(12, 14)
	else result = dateStr

	return result
}



/*
 주어진 두 문자열을 구분자가 들어간 날짜/시간의 기간 형식 문자열로 변환한다.
 날짜부분에는 구분자로 '/'가 들어가고, 시간 부분에는 구분자로 ':'가 들어가며, 날짜부분과
 시간부분 사이에는 ' '가 들어간다. 두 날짜/시간 사이의 기간 구분자로는 ' ~ '가 들어간다.

 @see formatDate(dateStr)
*/
function formatPeriod(dateStr1, dateStr2){
	return formatDate(dateStr1) + " ~ " + formatDate(dateStr2)
}



/*
 주어진 문자열에 대해서 지정된 길이 이후의 부분은 "..."로 치환한 문자열을 돌려준다.
*/ 
function formatTitle(titleStr, len){
	var result = "", maxLen = len

	if(titleStr.length <= maxLen) result = titleStr
	else result = titleStr.substring(0, maxLen) + "..."
		
	return result
}

	

/*
  숫자를 통화형식으로 변형한다. 
  입력값은 부호가 있는 또는 부호(+|-)가 있는 정수 또는 실수 형식의 문자열이어야 한다.
  +,- 이외의 문자가 앞에 붙거나, 수자가 아닌 문자 또는 white space 문자가 포함된 경우에는 이상한 결과를 얻을 것이다.
  앞부분이 0으로 시작하는 (예를 들어 "0012", "012.3" 등과 같은) 문자열의 경우에는 이상한 결과를 얻을 것이다.
*/
function formatCurrency(numStr){
	var signChar = numStr.charAt(0)
	var intPart = ""
	var fractionPart = ""
	var commas = 0
	var offset = 0

	if(isNaN(parseInt(signChar))){
		if((signChar != "+")&&(signChar != "-")) return numStr
		else intPart = numStr.substring(1)
	}
	else{
		signChar = ""
		intPart = numStr
	}

	if(!isNaN(parseInt(intPart))&&(intPart.length == parseInt(intPart).toString().length)){}
	else if(!isNaN(parseFloat(intPart))){
		fractionPart = intPart.substring(intPart.indexOf("."))
		intPart = intPart.substring(0, intPart.indexOf("."))
		
		//alert("integer part = " + intPart + ", fraction part = " + fractionPart)
	}
	else return numStr

	commas = Math.floor(intPart.length/3)
	offset = (intPart.length)%3
	if(offset == 0){
		offset = 3
		commas--
	}

	for(var i = 0; i < commas; i++){
		intPart = intPart.substring(0, i*3 + offset + i) + "," + intPart.substring(i*3 + offset + i)
	}

	if(signChar != "+") return (signChar + intPart + fractionPart) // 맨앞의 + 부호는 생략
	else return (intPart + fractionPart)
}



function formatTelNo(telNoStr){
	var area =""
	var code = ""
	var leftover = telNoStr.substring(8)
	var tag = false

	for(var i =0; i < 4; i++) {
		for (; telNoStr.charAt(i) == "0"; i++) area = "0";
		tag = true
		area += telNoStr.charAt(i)
	}
	tag = false

	for(; i < 8; i++) {
		if(telNoStr.charAt(i) != "0") {
			tag = true
			code += telNoStr.charAt(i)
		}
		else if(tag) code += telNoStr.charAt(i)
	}

	return (area + "-" + code + "-" + leftover)
}



function divideTelNo(telNoStr, type){
	var changedtelNoStr = ""
	var tag = false

	if (type == 1) changedtelNoStr = "0"
	for(var i = 0; i < 4; i++) {
		if (telNoStr.charAt(i) != "0") {
			tag = true
			changedtelNoStr += telNoStr.charAt(i)
		}
		else if (tag) changedtelNoStr += telNoStr.charAt(i)
	}

	return changedtelNoStr
}



function setWhiteSpaces(count){
	var spaces = ""

	if(count < 1) return
	else{
		for(var i = 0; i < count; i++) spaces += "&nbsp;&nbsp;&nbsp;&nbsp;"
		window.document.write(spaces);
	}
}



/* 
 정수의 최소자릿수를 버린 값을 구한다.
*/
function dropLastDigit(number){
	if(number == 0) return number
	else return (10*Math.floor(number/10.0))
}



/*
 정수의 최소자릿수를 구한다.
*/
function getLastDigit(number){
	return (number - dropLastDigit(number));
}	
