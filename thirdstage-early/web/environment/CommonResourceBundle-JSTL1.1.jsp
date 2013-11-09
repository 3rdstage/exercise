<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Common Resource Bundle (JSTL 1.1)</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META name="Author" content="Sang-Moon Oh"> 

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){

	<c:if test='${! empty param.locale}'>
	var selectObj = document.forms['localeForm'].elements['locale']
	for(var i = 0, n = selectObj.length; i < n; i++){
	    if(selectObj.options[i].value == '${param.locale}'){
		selectObj.options[i].selected = true
		break
		}
	}
	</c:if>

}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, ±¼¸²; font-size:14pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H2 {font-family:Verdana, ±¼¸²; font-size:13pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H3 {font-family:Verdana, ±¼¸²; font-size:12pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H4 {font-family:Verdana, ±¼¸²; font-size:11pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H5 {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
P {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
TD {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, ±¼¸²; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
<head>


<body onLoad="initPage()">
<div align='left'><a name='pageTop'></a>

<table border='0' cellspacing='1' cellpadding='1'>
<tr>
    <td><H1>Common Resouce Bundle</H1></td>
    <td>&nbsp;&nbsp;&nbsp;</td>
    <td><h5>(for JSTL 1.1 or Higher)</h5></td>
</tr>
</table>

<br>

<form name='localeForm' action='./CommonResourceBundle-JSTL1.1.jsp' target='_self' 
           method='POST' onSubmit='JavaScript:return checkToSubmit()'>
<table border='0' width='600' cellspacing='1' cellpadding='1'>
<tr>
	<td align='left' valign='top' nowrap style='font-weight:bold' width='20%'>Locale</td>
	<td align='left' valign='top'>:
	    <select name='locale'>
		<option value='<%=java.util.Locale.KOREA.getLanguage()%>'><%=java.util.Locale.KOREA.getDisplayName()%></option>
		<option value='<%=java.util.Locale.US.getLanguage()%>'><%=java.util.Locale.US.getDisplayName()%></option>
	    </select>
	    &nbsp;&nbsp;&nbsp;
	<INPUT name='submit' type='submit' value='execute'>
</TR>
</TABLE>
</FORM>
<BR>

<fmt:setLocale value="${param.locale}"/>
<fmt:setBundle basename="thirdstage.platform.resource.CommonResources" var="commonBundle"/>
<table width="600" cellspacing='0' cellpadding='0' border='1'>
<tr>
    <th>Key</th>
    <th>Value</th>
 </tr>

<% //@todo JSTL Function to sort Collection and Enumeration objects %>
<c:forEach var="key" items="${pageScope.commonBundle.resourceBundle.keys}">
<tr>
    <td>${key}</td>
    <td><fmt:message key="${key}" bundle="${commonBundle}"/></td>
 </tr>
 </c:forEach>
</table>

<br><br>
<a href='#pageTop'>top</a>
<br><br>

</div>
</body>
</html>
