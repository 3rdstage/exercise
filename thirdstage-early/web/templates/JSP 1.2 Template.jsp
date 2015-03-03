<%@ page language="java" session="true" autoFlush="true" isThreadSafe="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.lang.*" %>
<% request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">	
<html>
<head>
<title>JSP 1.2 Page Template</title>
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
<div align='left'><a name='pageTop'/>
    
<table border='0' cellspacing='0' cellpadding='1'>
<tr>
    <td><h1><script language="JavaScript">document.write(this.document.title)</script></h1></td>
    <td>&nbsp;&nbsp;&nbsp;</td>
    <td><h5>(remarks)</h5></td>
</tr>
</table>

<br/><br/>
 
<form name='aForm' action='' target='_self' method='post'
      accept-charset='UTF-8' onsubmit='JavaScript:return checkToSubmit()'>
<table width='600' border='0' cellspacing='1' cellpadding='2'>
<tr>
	<th class='blank'></th>
	<th class='blank'></th>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
</table>
</form>
    
		
<br/><br/>
<a href='#pageTop'>top</a>
<br/><br/>
</div>
</body>
</html>
