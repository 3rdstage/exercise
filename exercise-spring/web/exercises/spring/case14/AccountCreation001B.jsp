<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Create an Account</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
<meta http-equiv="Pragma" content="No-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta name="Author" content="Sang-Moon Oh"/>
<meta name="Version" content="1.0, yyyy-MM-dd"/>
<meta name="Since" content="yyyy-MM-dd"/>
<meta name="Keywords" content=""/>
<meta name="Description" content=""/>

<script type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
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
</head>


<body onload='JavaScript:initPage()'>
    
<table border='0' cellspacing='0' cellpadding='1'>
<tr>
    <td><h1><script language="JavaScript">document.write(this.document.title)</script></h1></td>
    <td>&nbsp;&nbsp;&nbsp;</td>
    <td><h5>(remarks)</h5></td>
</tr>
</table>

<br/><br/>

<tag:errors name="createAccount"/>

 
<spring:nestedPath path="createAccount">

<form action="" method="post">
<div>
<input type="hidden" name="_page0" value="true"/>
<input type="hidden" name="_target1" value="true"/>
</div>

<table>

<spring:nestedPath path="account">
	<tag:formField name="Username" path="username"/>
	<tag:formField name="Password" path="password" type="password"/>
</spring:nestedPath>

<tag:formField name="Confirm Password" path="confirmPassword" type="password"></tag:formField>


<spring:nestedPath path="account">
	<tag:formField name="Email" path="email"/>
</spring:nestedPath>

<tr>
	<td/>
	<td><input type="submit" value="Go to Step 2"/></td>
</tr>

</table>
</form>
</spring:nestedPath>


</body>
</html>
