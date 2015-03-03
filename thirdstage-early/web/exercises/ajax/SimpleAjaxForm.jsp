<%@ page language="java" session="true" autoFlush="true" isThreadSafe="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.lang.*" %>
<% request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">	
<html>
<head>
<title>Simple AJAX Form</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
<meta http-equiv="Pragma" content="No-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta name="Author" content="Sang-Moon Oh"/>
<meta name="Version" content="1.0, 2006-07-20"/>
<meta name="Since" content="2006-07-20"/>
<meta name="Keywords" content="AJAX"/>
<meta name="Description" content=""/>

<script type="text/javascript" language="JavaScript">
// page scope script
var req;

function validate(){
	var idField = document.getElementById("userid");
	var url = "./SimpleAjaxFormValidate.jsp?id=" + escape(idField.value);
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	req.open("GET", url, true);
	req.onreadystatechange = callback;
	req.send(null);
}

function callback(){
	if(req.readyState == 4){
		if(req.status == 200){
			setMessage(parseMessage());
		}
	}
}

function parseMessage(){
	var message = req.responseXML.getElementsByTagName("message")[0];
	return message.childNodes[0].nodeValue;
}

function setMessage(message){
	//alert(message);
	
	mdiv = document.getElementById("userIdMessage");
	if(message == "invalid"){
		mdiv.innerHTML = "<div style='color:red'>Invalid User ID</div>";
	}
	else{
		mdiv.innerHTML = "<div style='color:green'>Valid User ID</div>";
	}
	
}


function initPage(){
	document.forms["aForm"].elements["userid"].focus();
}

function checkToSubmit(){
	return true
}
</script>

<style type="text/css">
/* page scope style */
BODY {font-family:Verdana, 돋움; font-size:9pt; background:#ffffff}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy; margin-top:3pt; margin-bottom:3pt; border:none}
P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; margin-top:3pt; margin-bottom:3pt; border:none}
TABLE {background-color:#d6d6d6}
TABLE.search {background-color:#d6d6d6}
TABLE.list {background-color:#d6d6d6}
TABLE.detail {background-color:#d6d6d6}
TD {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; background-color:white}
TD.title {font-size:12pt; font-weight:bold; color:navy}
TD.search {background-color:#f5f5f5} 
TD.item {background-color:#f5f5f5}
TH {font-family:Verdana, 돋움; font-size:9pt; font-weight:bold; color:black; background-color:#f5f5f5; text-align:center}
TH.blank {margin:0pt; padding:0pt; border:0pt; height:0pt}
INPUT {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 돋움; font-size:8pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</style>
<head>


<body onload='JavaScript:initPage()'>
<div align='left'><a name='pageTop'/>
    
<table border='0' cellspacing='0' cellpadding='1'>
<tr>
    <td><h1>Simple AJAX Form</h1></td>
    <td>&nbsp;&nbsp;&nbsp;</td>
    <td><h5>()</h5></td>
</tr>
</table>

<br/><br/>
 
<form name='aForm' action='' target='_self' method='post'
      accept-charset='UTF-8' onsubmit='JavaScript:return checkToSubmit()'>
<table width='600' border='0' cellspacing='1' cellpadding='2'>
<tr>
	<th class='blank' width="20%"></th>
	<th class='blank' width="40%"></th>
	<th class='blank' width="40%"></th>
</tr>
<tr>
	<td>User ID :</td>
	<td><input type="text" size="20" id="userid" name="id" onkeyup="validate()"/></td>
	<td><div id="userIdMessage"/></td>
</tr>
</table>
</form>
    
		
<br/><br/>
<a href='#pageTop'>top</a>
<br/><br/>
</div>
</body>
</html>
