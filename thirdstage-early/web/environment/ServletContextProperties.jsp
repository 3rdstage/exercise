<%@ page language="java" import='java.util.*' %>

<%
response.setContentType("text/html");
%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Servlet Container Properties</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META name="Author" content="Sang-Moon Oh">

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, ±¼¸²; font-size:14pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H2 {font-family:Verdana, ±¼¸²; font-size:13pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H3 {font-family:Verdana, ±¼¸²; font-size:12pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
P {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
TD {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Tahoma, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, ±¼¸²; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>

</head>

<body>
<div align='left'><a name='pageTop'></a>

<h1>Servlet Context Properties</h1>
<br><br>
<%
ServletContext ctx = config.getServletContext();
%>
<h3>1. Servlet Container</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th>Property</th>
	<th>Method</th>
	<th>Value</th>
</tr>
<tr>
	<td valign='top' nowrap>Server Container Info</td>
	<td valign='top'>ServletContext.getServerInfo()</td>
	<td valign='top'><%=ctx.getServerInfo()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Servlet API Major Ver.</td>
<td valign='top'>ServletContext.getMajorVersion()</td>
	<td valign='top'><%=ctx.getMajorVersion()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Servlet API Minor Ver.</td>
	<td valign='top'>ServletContext.getMinorVersion()</td>
	<td valign='top'><%=ctx.getMinorVersion()%></td>
</tr>
</table>

<br><br><br><br>

<h3>2. Servlet Context</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th>Property</th>
	<th>Method</th>
	<th>Value</th>
</tr>
<tr>
	<td valign='top' nowrap>Servlet Context Name</td>
	<td valign='top'>ServletContext.getServletContextName()</td>
	<td valign='top'><%=ctx.getServletContextName()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Resource Path for Context Root</td>
	<td valign='top'>ServletContext.getResource()</td>
	<td valign='top'><%=ctx.getResource("/")%></td>
</tr>
<tr>
	<td valign='top' nowrap>Physical Path for Context Root</td>
	<td valign='top'>ServletContext.getRealPath()</td>
	<td valign='top'><%=ctx.getRealPath("/")%></td>
</tr>
</table>

<br><br>

<h3>2.1. Initial Parameters (ServeltContext.getInitParameter())</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th width='50%'>Name</th>
	<th>Value</th>
</tr>
<%
Enumeration names = ctx.getInitParameterNames();
String name = null;
while(names.hasMoreElements()){
	name = (String)names.nextElement();
%>
	<tr>
		<td valign='top' nowrap><%=name%></td>
		<td valign='top'><%=ctx.getInitParameter(name)%></td>
	</tr>
<%
}
%>
</table>

<br><br>

<h3>2.2. Context Resources (ServletContext.getResourcePaths())</h3>
<table border='0' width='600' cellspacing='1' cellpadding='1'>
<tr>
	<th width='10%'></th>
	<th></th>
</tr>
<%
Iterator resources = ctx.getResourcePaths("/").iterator();
String res = null;
while(resources.hasNext()){
	res = (String)resources.next();
%>
	<tr>
		<td>&nbsp;</td>
		<td nowrap><%=res%></td>
	</tr>
<%
}
%>
</table>

<br><br>

<h3>2.3. Context Attributes (ServletContext.getAttribute())</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th width='50%'>Name</th>
	<th>Value</th>
</tr>
<%
names = ctx.getAttributeNames();
name = null;
while(names.hasMoreElements()){
	name = (String)names.nextElement();
%>
	<tr>
		<td valign='top' nowrap><%=name%></td>
		<td valign='top'><%=ctx.getAttribute(name).toString()%></td>
	</tr>
<%
}
%>
</table>

<br><br>

<a href='#pageTop'>top</a>
<br><br>

</div>
</body>
</html>