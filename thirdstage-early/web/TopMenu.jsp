<%@page language="java" session="true" autoFlush="true" isThreadSafe="true"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<html>
<head>
<title>Guess What?</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META name="Author" content="Sang-Moon Oh"> 

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy}
H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy}
P {font-family:Verdana, 굴림; font-size:10pt; font-weight:normal; color:black}
TD {font-family:Verdana, 굴림; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Verdana, 굴림; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 굴림; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
<head>


<body onLoad="initPage()">

<div>

<table border='0' width='800' cellspacing='1' cellpadding='1' valign="bottom">
<tr>
	<td colspan='4'><h1>3rdstage</h1></td>
</tr>
<tr>
	<td width="150"><a href="./environment/index.jsp" target="bodyFrm">Environment</a></td>
	<td width="150"><a href="./tests/index.html" target="bodyFrm">Tests</a></td>
	<td width="150"><a href="./accesscontrol/index.jsp" target="bodyFrm">Access Control</a></td>
	<td width="150"><a href="./project/index.jsp" target="bodyFrm">Project Center</a></td>
	<td width="150"><a href="./exercises/index.html" target="bodyFrm">Exercises</a></td>
	<td>&nbsp;</td>
</tr>
</table>

</div>


</body>
</html>
