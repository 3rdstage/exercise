<%@page language="java" session="true" autoFlush="true" isThreadSafe="true"%>
<%@page contentType="text/html;charset=euc-kr"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<%
response.setContentType("text/html;charset=EUC-KR");
%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Greetings Input</title>

<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
P {font-family:Verdana, 굴림; font-size:10pt; font-weight:normal; color:black}
TD {font-family:Verdana, 굴림; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Tahoma, 굴림; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 굴림; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>

<script type='text/javascript' language='JavaScript'>
function initPage(){
	
	document.forms['welcomeForm'].elements['name'].focus()
}
</script>
</head>
<body bgcolor="#FFFFFF" onLoad='JavaScript:initPage()'>
<div align='left'>

<h1>Simple Page in JSP</h1>
<br>

<form name='welcomeForm' method='POST' target='_self' action='./SimpleForm.jsp'>
<table border='0' cellspacing='1' cellpadding='1' width='400'>
	<tr>
		<td>
			Welcome! &nbsp;&nbsp;Enter your name.<br>
			Especially this is for korean test in form<br><br>
		</td>
	</tr>
	<tr>
		<td>
			<input name='name' type='text' size='20'>
			<input name='submit' type='submit' value='enter'>	
		</td>
	</tr>
</table>
</form>

</div>
</body>
</html>