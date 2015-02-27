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
<title>Exercise Menu</title>
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
<div align='left'>
<h2>Exercise Menu</h2>

<table border='0' width='220' cellspacing='1' cellpadding='1'>
<tr>
	<td><a href="./iframe/RiskSearch.faces" target="contentsFrm">Risk Search</a> (Inline Frame)</td>
</tr>
<tr>
	<td><a href="./servicelocator/AddRole.jsp" target="contentsFrm">Add Role</a> (ServiceLocator)</td>
</tr>

<tr>
	<td><a href="./jsf/SimpleJSFForm.faces" target="contentsFrm">Simple JSF Page</a> (JSF)</td>
</tr>
<tr>
	<td><a href="./myfaces/SimpleHTMLEditor.faces" target="contentsFrm">Simple HTML Editor</a> (MyFaces)</td>
</tr>
<tr>
	<td><a href="./myfaces/SimpleCalendarPopup.faces" target="contentsFrm">Simple Calendar Popup</a> (MyFaces)</td>
</tr>

<tr>
	<td><a href="./jsf-spring/RequirementCreate.faces" target="contentsFrm">Requirement Creation</a> (JSF-Spring-Hibernate Integration)</td>
</tr>

<tr>
	<td><a href="./hibernate/SimpleHibernate.jsp" target="contentsFrm">Simple Hibernate</a> (Hibernate)</td>
</tr>
<tr>
	<td><a href="./hibernate/SimpleHibernateAnnotations.jsp" target="contentsFrm">Simple Hibernate Annotations</a> (Hibernate)</td>
</tr>

<tr>
	<td><a href="./ajax/SimpleAjaxForm.jsp" target="contentsFrm">Simple AJAX Form</a> (AJAX)</td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>

<tr>
	<td><a href="./security/SimpleMessageDigest.faces" target="contentsFrm">Message Digest Test</a></td>
</tr>

</table>

</div>

</body>
</html>
