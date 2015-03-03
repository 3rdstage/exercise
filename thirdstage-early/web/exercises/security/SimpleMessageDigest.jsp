<%@page language="java" session="true" autoFlush="true" isThreadSafe="true"%>
<%@page contentType="text/html;charset=euc-kr"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="java.security.*,org.apache.commons.codec.digest.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<html>
<head>
<title>Message Digest</title>
<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR"/>
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
P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
TABLE {background-color:#d6d6d6}
TABLE.search {background-color:#d6d6d6}
TABLE.list {background-color:#d6d6d6}
TABLE.detail {background-color:#d6d6d6}
TD {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; background-color:white}
TD.search {background-color:#f5f5f5} 
TD.item {background-color:#f5f5f5}
TH {font-family:Verdana, 돋움; font-size:9pt; font-weight:bold; color:black; background-color:#f5f5f5}
INPUT {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 돋움; font-size:8pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
<head>


<body onLoad="JavaScript:initPage()">
<div align='left'><a name='pageTop'/>

<table border='0' cellspacing='0' cellpadding='2'>
<tr>
    <td><H1>Simple Message Digest</H1></td>
    <td>&nbsp;&nbsp;&nbsp;</td>
    <td><h5>(Jakarta Commons Codec 1.3 or higher)</h5></td>
</tr>
</table>

<br/><br/>

<h3>Using Jakarta Commons</h3>
<table border='0' cellspacing='1' cellpadding='2'>
<tr>
	<th>String</th>
	<th>MD5 Message Digest</th>
	<th>SHA Message Digest</th>
</tr>
<tr>
	<td>3rdstage</td>
	<td><%=DigestUtils.md5Hex("3rdstage")%></td>
	<td><%=DigestUtils.shaHex("3rdstage")%></td>
</tr>
</table>

<br><br>

<h3>Equality Test</h3>
<p>
MD5 Message Digest for "3rdstage" is : <%=DigestUtils.md5Hex("3rdstage")%><br/>
"e4ca3a72def71401cd4e0f1c254ea04a".equals(DigestUtils.md5Hex("3rdstage")) is : <%="e4ca3a72def71401cd4e0f1c254ea04a".equals(DigestUtils.md5Hex("3rdstage"))%><br/>
</p>

<br><br>

<h3>Using only JDK</h3>
<%
MessageDigest md1 = MessageDigest.getInstance("MD5");
String str = "3rdstage";
String hash1 = new String(md1.digest(str.getBytes("UTF-8")), "UTF-8");
%>
<table border='0' cellspacing='1' cellpadding='2'>
<tr>
	<th>String</th>
	<th>MD5 Message Digest</th>
	<th>SHA Message Digest</th>
</tr>
<tr>
	<td><%=str%></td>
	<td><%=hash1%></td>
	<td>&nbsp;</td>
</tr>
</table>

		
<br/><br/>
<a href='#pageTop'>top</a>
<br/><br/>
</div>
</body>
</html>
