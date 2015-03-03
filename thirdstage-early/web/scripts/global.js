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
 * Ű������ F5 �ۼ谡 �������� ���� ���Ƽ� ���ΰ�ħ�� �� �� ������ �Ѵ�.
 * �Ϲ������� BODY tag�� onKeyDown event handler�� ������ ���� ����Ѵ�.
 *
 * 	...
 * 	<BODY onKeyDown='JavaScript:return preventF5Key(event)' ...>
 * 	...
 * 
 * @since 1.7
 */
function preventF5Key(ev){

	if(ev.keyCode == 116){
		alert("�� ������������ ���ΰ�ħ�� ����Ͻ� �� �����ϴ�.")
		ev.keyCode = 0
		return false
	}
	else return true
}


/**
 * ���������� ������ ���콺�� ���� context popup menu�� ���̴� ���� ���´�.
 * ���������� ������ ���콺�� ���� '���ΰ�ħ'�̳� '�ڷ�'�� ���� ������ ���� ���ؼ� ����Ѵ�.
 * 	...
 * 	<BODY onMouseDown='JavaScript:return preventMouseRightButton(event)' ...>
 * 	...
 *
 * @since 1.7
 */
function preventMouseRightButton(ev){

	if(ev.button == 2){
		alert("�� ������������ ���콺 ������ ���߸� ����Ͻ� �� �����ϴ�.")
		return false
	}
	else return true
}


/**
 * ������ INPUT field�� ������ ���̰� �Ǹ� ���� INPUT field�� focus�� 
 * ��������.
 * currentElement�� text �Ǵ� password type�� INPUT field�̾�� �Ѵ�.
 * currentElement�� �ش��ϴ� INPUT field�� onKeyUp event handler�� ������
 * ���� �������� ����ϵ��� �Ѵ�.
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
 * �־��� Event ��ü�� key�� ���ڸ� �����ϵ��� �ϴ� �ۼ����� Ȯ���Ѵ�.
 * 0 ~ 9 ������ ����, Backspace ���� Key�� ���� event�� �����Ǹ� true�� �����ش�.
 * INPUT element�� ���� ���ڸ��� �Է°����ϵ��� �Ϸ��� �� �� onKeyPress event handler
 * �� ������ ���� �����Ͽ� ����� �� �ִ�. INPUT element���� onKeyDown event handler��
 * ����ϸ� tab �ۼ�, �¿� ȭ��ǥ �ۼ踦 ����� �� ���� �ǹǷ� onKeyPress�� �����ϵ���
 * �Ѵ�.
 * Internet Explorer 4.0, Nescape Navigator 4.0 �̻󿡼� ���������� �۵��Ѵ�.
 *       
 *       ...
 *       <INPUT type='text' name='amount' onKeyPress='JavaScript:return isDigitKeepingKey(event)'>
 *       ...
 *
 * @since 1.6
*/
function isDigitKeepingKey(e) {
	
	var isIE = (document.all) ? true: false //Internet Exploerer�ΰ�?
	var isNN = (document.layers) ? true: false //Netscape�ΰ�?

	if(!isIE && !isNN) return false

	var keyValue;
	if(isIE)keyValue = e.keyCode
	else if(isNN) keyValue = e.which
	
	// 0 ~ 9������ ����, ȭ��ǥ �Ǵ� back space���� ����Ѵ�.
	// Decimal ASCII code�� 48 ~ 57(0 ~ 9) �Ǵ� 8(Backspace)
	if(((keyValue > 47) && (keyValue < 58)) || keyValue == 8) return true
	else return false
}



/**
 * �־��� ���ڿ��� ���Ե� ��� ���ϵ���ǥ�� ������ ���ڿ��� �����ش�.
 *
 * @since 1.6
*/
function removeSingleQuotationMarks(str){
	
	if(str == null) return str
	else if(str.length == 0) return str
	else return str.replace(/\'/g,"")
}


/**
 * �־��� ���ڿ��� ���Ե� ��� comma (,)�� ������ ���ڿ��� �����ش�.
 *
 * @since 1.6
*/
function removeCommas(str){
	if(str == null) return str
	else if(str.length == 0) return str
	else return str.replace(/\,/g, "")
}


/*
 �־��� �׸� ���ϵ��� �޸𸮿� load�Ѵ�.
 MouseOver event�� �׸������� �ٲٴ� ���� �۾��� �� �� �ٲ� �׸��� �̸� �������� ���� 
 �۾��� ���ؼ� ����Ѵ�.
 Parameter���� load�� �׸����ϵ��� url���� list�ϸ� �ȴ�.
 ������ ���� ������� ����Ѵ�.
 
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
 ������ <IMG> tag�� source�� ������ ���Ϸ� �ٲ۴�.
 ������ ���� ����Ѵ�.
 
	...
	imgSwap(document.all("menuImg1"), "../menu1-off")
	...
*/ 
function imgSwap(targetImg, imgSrc){
	targetImg.src = imgSrc
}



/*
 �־��� ���ڿ� �յ��� ���鹮��(space, tab, form feed, line feed ����)���� ������ ���ڿ��� �����´�.
 ���ڿ� �߰��� ���鹮�ڵ��� ������ ������, �յ��� ���鹮�ڵ���
 ������ ������� ��� �����Ѵ�.
 �־��� ���ڿ��� �ѱ��� ���ԵǾ �������� �����Ѵ�.
 
 @since 1.5
*/
function trimString(str){
	return str.replace(/^\s+|\s+$/g, "")
}



/*
 �־��� ���ڿ��� ���� ���������� �����Ѵ�.
 ���ڿ� �� ���� - ��ȣ, �Ǵ� 0�ƴ� ���� ���� 0���� ������ ���� �ʴ´�.
 ���ڿ� �� ���� '-' �̿ܿ� ���ڰ� �ƴ� ���ڰ� ���Ե� ��� false�� �����ش�.
 ���ڿ��̳� ���鹮�ڸ� ������ ���ڿ��� ��쿡�� false�� �����ش�.
 Java�� Integer.parseInt�� ȣȯ���� ������.
 JavaScript�� parseInt�� Java�� Integer.parseInt�� ȣȯ���� ����.
 
 @since 1.5
*/
function isInt(str){
	if(str.length == 0 || str == "") return false
	
	if(str.search(/[^0-9]/g) != -1){
		if(str.charAt(0) == "-"){
			if(str.length == 1) return false //�־��� ���ڿ��� "-"�� ���
			else if(str.substring(1, str.length).search(/[^0-9]/g) != -1) return false
			else return true
		}
		else return false
	}	
	else return true
}



/* 
 �־��� ���ڿ��� ���� ���� �������� �����Ѵ�.
 ���ڿ� �� �κ��� 0���� ������ ���� �ʴ´�.
 ���ڰ� �ƴ� ���ڰ� ���Ե� ��� false�� �����ش�.
 ���ڿ��̳� ���鹮�ڸ� ������ ���ڿ��� ��쿡�� false�� �����ش�.
 Java�� Integer.parseInt�� ȣȯ���� ������.
 JavaScript�� parseInt�� Java�� Integer.parseInt�� ȣȯ���� ����.
 
 @since 1.5
*/
function isPositiveInt(str){
	if(str.length == 0 || str == "") return false //�� ���ڿ��� ���,
	else if(str.search(/[^0-9]/g) != -1) return false
	else if(str.search(/[^0]/g) == -1) return false //0���θ� �̷���� ���,
	else return true
}	


/*
 �־��� ���ڿ��� 0 �Ǵ� ���� ���� �������� �����Ѵ�.
 ���ڿ� �� �κ��� 0���� ������ ���� �ʴ´�. ���� ��� '0000', '0123' ���� 
 true ���� ������.
 ���ڿ��̳� ���鹮�ڸ� ������ ���ڿ��� ��쿡�� false�� �����ش�.
 
 @since 1.5.1
*/
function isNonnegativeInt(str){
	if(str.length == 0 || str == "") return false //�� ���ڿ��� ���,
	else if(isPositiveInt(str)) return true
	else if(str.search(/[^0]/g) == -1) return true //0���θ� �̷���� ���
	else return false
}

/* 
 �־��� ���ڿ��� �ùٸ� ����� ID �������� �����Ѵ�.
 ����� ID�� ���̴� 4 ~ 7�� ���̿��� �ϸ�, ���ĺ� �Ǵ� ���ڵ�θ� �����Ǿ�� �Ѵ�.
 ���ڿ� �յ��� ������� �����ϰ� �����Ѵ�.
 �ùٸ� ����� ������ ��� true��, �׷��� ���� ��� false�� �����ش�.
*/
function isVaildUserId(idStr){
	if(idStr == null) return false

	var re = /^\s+|\s+$/g //�Է°��� �յ� ���鹮�ڵ��� �����ϱ� ���� regular expression
	var id = idStr.replace(re, "") //�Է°��� �յ� ���鹮�� ���� 

	if((id.length < 4) || (id.length > 7)) return false
	
	re = /[^A-Za-z0-9]/g //���ĺ�, �Ǵ� ���ڰ� �ƴ� ���ڸ� ���� regular experssion
	if(id.search(re) != -1) return false
	
	return true
}



/*
 �־��� ���ڿ��� �ùٸ� ��й�ȣ �������� �����Ѵ�.
 ��й�ȣ�� ���̴� 4 ~ 12�� ���̿��� �ϸ�, ���ĺ� �Ǵ� ���ڵ�θ� �����Ǿ�� �Ѵ�.
 ���ڿ� ��, �� �Ǵ� �߰��� ����鵵 ���� �����Ѵ�.
 �ùٸ� ��й�ȣ ������ ��� true��, �׷��� ���� ��� false�� �����ش�.
*/
function isValidPassword(passwdStr){
	var re = /[^A-Za-z0-9]/g //���ĺ�, �Ǵ� ���ڰ� �ƴ� ���ڸ� ���� regular experssion
	
	if(passwdStr == null) return false
	else if(passwdStr.search(re) != -1) return false
	else if((passwdStr.length < 4) || (passwdStr.length > 12)) return false
	else return true
}

	
	
/*
 �־��� ���ڿ��� �ùٸ� email �ּ� �������� �����Ѵ�.
 �ùٸ� email �ּ� ������ ��� true��, �׷��� ���� ��� false�� �����ش�.
*/
function isValidEmail(emailStr){
	if(emailStr == null) return false
	else if(emailStr.length < 3) return false
	else if(emailStr.indexOf("@") < 1) return false
	else if(emailStr.indexOf("@") > (emailStr.length - 2)) return false
	else return true
}



/* 
 �ֹε�Ϲ�ȣ ����
 �־��� ���ڿ��� �ùٸ� �ֹε�Ϲ�ȣ �������� �����Ѵ�.
 �ùٸ� �ֹε�Ϲ�ȣ ������ ��� true��, �׷��� ���� ��� false�� �����ش�.
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
  ���� ���� : ���� ������ ���� <optiom> tag �κ��� dynamic�ϰ� ����
  �⺻ ���ð��� �����Ͽ� �ָ� �� ��,�ڷ� 3���� offset�� �ΰ� <select>�ȿ� �� <option> �κ��� �����Ѵ�.
  ������ ���� ������� ����Ѵ�.
  
  		...
  		<SELECT name='fromYear'>
  			<SCRIPT language='JavaScript'>generateYear("2001")</SCRIPT>
  		</SELECT>
  		...
  
 @param choosedYear �⺻������ ���õ� ���� ���ڿ�. 
                    ���ڿ�("")�� �ָ� ���� ������ ���õȴ�.
                    "-1"�� �ָ� ���� option�� ����ְ� �⺻������ �� �� option�� ���õ� ���°� �ȴ�. 
                    �� option�� value �Ӽ����� -1�̴�.
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
  ���� ���� : ���� ������ ���� <option> tag �κ��� dynamic�ϰ� ����
  ���� ����, �� ����, ���� ������ �����Ͽ� �ָ� ���⿡ �´� <select>�ȿ� �� <option> �κ��� �����Ѵ�.
  ������ ���� ������� ����Ѵ�.
  
  		...
  		<SELECT name='fromYear'>
  			<SCRIPT language='JavaScript'>generateYear2("1995", "2002", "2001")</SCRIPT>
  		</SELECT>
  		...

 @param startYear ���� ���� ���ڿ�
 @param endYear �� ���� ���ڿ�
 @param choosedYear �⺻������ ���õ� ���� ���ڿ�.
                    "-1"�� �ָ� ���� option�� ����ְ� �⺻������ �� �� option�� ���õ� ���°� �ȴ�. 
                    �� option�� value �Ӽ����� -1�̴�.
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
  �� ���� : �� ������ ���� <option> tag �κ��� dynamic�ϰ� ����
  �⺻ ���ð��� �ָ� �� ���� ������, 1������ 12�������� <option> tag���� �ڵ����� �����Ѵ�.
  �� option�� ȭ�鿡 ���̴� text�� 1, 2, 3, ..., 11, 12 ������ value �Ӽ����� 01, 02, ..., 11, 12 ���� ������. 
  
  		...
  		<SELECT name='fromMonth'>
  			<SCRIPT language='JavaScript'>generateMonth("3")</SCRIPT>
  		</SELECT>
  		...

 @param choosedMonth �⺻������ ���õ� �� ���ڿ�
                     ���ڿ�("")�� �ָ� ���� ���� ���õȴ�.
                     "-1"�� �ָ� ���� option�� ����ְ� �⺻������ �� �� option�� ���õ� ���°� �ȴ�. 
                     �� option�� value �Ӽ����� -1�̴�.	
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
  �� ���� : �� ������ ���� <option> tag �κ��� dynamic�ϰ� ����
  �⺻ ���ð��� �ָ� �� ���� ������, 1�Ϻ��� 31�ϱ����� <option> tag���� �ڵ����� �����Ѵ�.
  �� option�� ȭ�鿡 ���̴� text�� 1, 2, 3, ..., 30, 31 ������ value �Ӽ����� 01, 02, ..., 30, 31 ���� ������. 
  
  		...
  		<SELECT name='fromDay'>
  			<SCRIPT language='JavaScript'>generateDay("3")</SCRIPT>
  		</SELECT>
  		...

 @param choosedMonth �⺻������ ���õ� �� ���ڿ�
                     ���ڿ�("")�� �ָ� ���� ���� ���õȴ�.
                     "-1"�� �ָ� ���� option�� ����ְ� �⺻������ �� �� option�� ���õ� ���°� �ȴ�. 
                     �� option�� value �Ӽ����� -1�̴�.	
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
  ��(hour) ���� : ��(hour) ������ ���� <option> tag �κ��� dynamic�ϰ� ����
  �⺻ ���ð��� �ָ� �� ���� ������, 0�ú��� 23�ñ����� <option> tag���� �ڵ����� �����Ѵ�.
  �� option�� ȭ�鿡 ���̴� text�� 0, 1, 2, ..., 23, 24 ������ value �Ӽ����� 00, 01, 02, ..., 23, 24 ���� ������. 
  
  		...
  		<SELECT name='fromHour'>
  			<SCRIPT language='JavaScript'>generateHour("17")</SCRIPT>
  		</SELECT>
  		...

 @param choosedHour �⺻������ ���õ� �� ���ڿ�
                    ���ڿ�("")�� �ָ� ���� �ð� ���õȴ�.
                    "-1"�� �ָ� ���� option�� ����ְ� �⺻������ �� �� option�� ���õ� ���°� �ȴ�. 
                    �� option�� value �Ӽ����� -1�̴�.	
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
  �� ���� : �� ������ ���� <option> tag �κ��� dynamic�ϰ� ����
  �⺻ ���ð��� �ָ� �� ���� ������, 0�к��� 59�б����� <option> tag���� �ڵ����� �����Ѵ�.
  �� option�� ȭ�鿡 ���̴� text�� 0, 1, 2, ..., 58, 59 ������ value �Ӽ����� 00, 01, 02, ..., 58, 59 ���� ������. 
  
  		...
  		<SELECT name='fromMinute'>
  			<SCRIPT language='JavaScript'>generateMinute("23")</SCRIPT>
  		</SELECT>
  		...

 @param choosedMinute �⺻������ ���õ� �� ���ڿ�
                      ���ڿ�("")�� �ָ� ���� ���� ���õȴ�.
                      "-1"�� �ָ� ���� option�� ����ְ� �⺻������ �� �� option�� ���õ� ���°� �ȴ�. 
                      �� option�� value �Ӽ����� -1�̴�.	
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
 �־��� ���ڿ��� �����ڰ� �� ��¥/�ð� ������ ���ڿ��� ��ȯ�Ѵ�.
 ��¥�κп��� �����ڷ� '/'�� ���� �ð��κп��� �����ڷ� ':'�� ����, ��¥�κа�
 �ð��κ� ���̿��� ' '�� ����.
 
 �־��� ���ڿ��� �������� ���� ���, �־��� ���ڿ��� �״�� �����ش�.
 �־��� ���ڿ��� ���̿� ���� ������ ���� ��ȯ�ȴ�
 
 	����             ���� ����          ��ȯ���� ����
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
 �־��� �� ���ڿ��� �����ڰ� �� ��¥/�ð��� �Ⱓ ���� ���ڿ��� ��ȯ�Ѵ�.
 ��¥�κп��� �����ڷ� '/'�� ����, �ð� �κп��� �����ڷ� ':'�� ����, ��¥�κа�
 �ð��κ� ���̿��� ' '�� ����. �� ��¥/�ð� ������ �Ⱓ �����ڷδ� ' ~ '�� ����.

 @see formatDate(dateStr)
*/
function formatPeriod(dateStr1, dateStr2){
	return formatDate(dateStr1) + " ~ " + formatDate(dateStr2)
}



/*
 �־��� ���ڿ��� ���ؼ� ������ ���� ������ �κ��� "..."�� ġȯ�� ���ڿ��� �����ش�.
*/ 
function formatTitle(titleStr, len){
	var result = "", maxLen = len

	if(titleStr.length <= maxLen) result = titleStr
	else result = titleStr.substring(0, maxLen) + "..."
		
	return result
}

	

/*
  ���ڸ� ��ȭ�������� �����Ѵ�. 
  �Է°��� ��ȣ�� �ִ� �Ǵ� ��ȣ(+|-)�� �ִ� ���� �Ǵ� �Ǽ� ������ ���ڿ��̾�� �Ѵ�.
  +,- �̿��� ���ڰ� �տ� �ٰų�, ���ڰ� �ƴ� ���� �Ǵ� white space ���ڰ� ���Ե� ��쿡�� �̻��� ����� ���� ���̴�.
  �պκ��� 0���� �����ϴ� (���� ��� "0012", "012.3" ��� ����) ���ڿ��� ��쿡�� �̻��� ����� ���� ���̴�.
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

	if(signChar != "+") return (signChar + intPart + fractionPart) // �Ǿ��� + ��ȣ�� ����
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
 ������ �ּ��ڸ����� ���� ���� ���Ѵ�.
*/
function dropLastDigit(number){
	if(number == 0) return number
	else return (10*Math.floor(number/10.0))
}



/*
 ������ �ּ��ڸ����� ���Ѵ�.
*/
function getLastDigit(number){
	return (number - dropLastDigit(number));
}	
