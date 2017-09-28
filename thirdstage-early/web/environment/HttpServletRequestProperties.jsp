	<%@ page language="java" import="java.util.*"%>

<%
response.setContentType("text/html"); %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Typical HttpServletRequest Properties</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META name="author" content="Sang-Moon Oh">
<META name="version" content="1.5">
<META name="date" content="2005-02-14">
<META name="since" content="">

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
H1 {font-family:Verdana, ±¼¸²; font-size:14pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H2 {font-family:Verdana, ±¼¸²; font-size:13pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H3 {font-family:Verdana, ±¼¸²; font-size:12pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H4 {font-family:Verdana, ??; font-size:11pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H5 {font-family:Verdana, ??; font-size:10pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
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

<h1>HttpServletRequest Properties</h1>
<P>(properties from current request)</P>
<br>


<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th>Property</th>
	<th>Method</th>
	<th>Value</th>
</tr>
<tr>
	<td valign='top' nowrap>Protocol</td>
	<td valign='top' nowrap>HttpServletRequest.getProtocol()</td>
	<td valign='top'><%=request.getProtocol()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Secure Request</td>
	<td valign='top' nowrap>HttpServletRequest.isSecure()</td>
	<td valign='top'><%=request.isSecure()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Character Encoding</td>
	<td valign='top' nowrap>HttpServletRequest.getCharacterEncoding()</td>
	<td valign='top'><%=request.getCharacterEncoding()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Content Type</td>
	<td valign='top' nowrap>HttpServletRequest.getContentType()</td>
	<td valign='top'><%=request.getContentType()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Preferred Locale</td>
	<td valign='top' nowrap>HttpServletRequest.getLocale()</td>
	<td valign='top'><%=request.getLocale().getLanguage()%>_<%=request.getLocale().getCountry()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Acceptable Locales</td>
	<td valign='top' nowrap>HttpServletRequest.getLocales()</td>	
	<td valign='top'>
	<%
	Enumeration locales = request.getLocales();
	Locale locale = null;

	while(locales.hasMoreElements()){
		locale = (Locale)locales.nextElement(); %>
	<%=locale.getLanguage()%>_<%=locale.getCountry()%><br>
	<%
	} %>
	</td>
</tr>
<tr>
	<td valign='top' nowrap>Server Name</td>
		<td valign='top' nowrap>HttpServletRequest.getServerName()</td>
	<td valign='top'><%=request.getServerName()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Server Port</td>
		<td valign='top' nowrap>HttpServletRequest.getServerPort()</td>
	<td valign='top'><%=request.getServerPort()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Client Address</td>
		<td valign='top' nowrap>HttpServletRequest.getRemoteAddr()</td>
	<td valign='top'><%=request.getRemoteAddr()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Client Hostname</td>
		<td valign='top' nowrap>HttpServletRequest.getRemoteHost()</td>
	<td valign='top'><%=request.getRemoteHost()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Client User</td>
		<td valign='top' nowrap>HttpServletRequest.getRemoteUser()</td>
	<td valign='top'><%=request.getRemoteUser()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Authentication Type</td>
		<td valign='top' nowrap>HttpServletRequest.getAuthType()</td>
	<td valign='top'><%=request.getAuthType()%></td>
</tr>
<tr>
	<td valign='top' nowrap>User Principal</td>
		<td valign='top' nowrap>HttpServletRequest.getUserPrincipal()</td>
	<td valign='top'><%=(request.getUserPrincipal() == null) ? "null" : request.getUserPrincipal().getName()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Session ID</td>
		<td valign='top' nowrap>HttpServletRequest.getRequestSessionId()</td>
	<td valign='top'><%=request.getRequestedSessionId()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Session ID from Cookie</td>
		<td valign='top' nowrap>HttpServletRequest.isRequestedSessionIdFromCookie()</td>
	<td valign='top'><%=request.isRequestedSessionIdFromCookie()%></td>
</tr>
</table>
<br><br>

<h3>Paths</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th>Property</th>
	<th>Method</th>
	<th>Value</th>
</tr>
<tr>
	<td valign='top' nowrap>Reqeust URL</td>
	<td valign='top' nowrap>HttpServletRequest.getRequestURL()</td>
	<td valign='top'><%=request.getRequestURL()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Request URI</td>
	<td valign='top' nowrap>HttpServletRequest.getRequestURI()</td>
	<td valign='top'><%=request.getRequestURI()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Context Path</td>
	<td valign='top' nowrap>HttpServletRequest.getContextPath()</td>
	<td valign='top'><%=request.getContextPath()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Servlet Path</td>
	<td valign='top' nowrap>HttpServletRequest.getServletPath()</td>
	<td valign='top'><%=request.getServletPath()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Query String</td>
<td valign='top' nowrap>HttpServletRequest.getQueryString()</td>
	<td valign='top'><%=request.getQueryString()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Path Info</td>
	<td valign='top' nowrap>HttpServletRequest.getPathInfo()</td>
	<td valign='top'><%=request.getPathInfo()%></td>
</tr>
<tr>
	<td valign='top' nowrap>Path Translated</td>
	<td valign='top' nowrap>HttpServletRequest.getPathTranslated()</td>
	<td valign='top'><%=request.getPathTranslated()%></td>
</tr>
</table>
<h5>( * Request URI = Context Path + Servlet Path + Path Info )</h5>

<br><br>
<h3>Request Headers (HttpServletReqeust.getHeaders())</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th width='30%'>Name</th>
	<th>Value</th>
</tr>
<%
Enumeration names = request.getHeaderNames();
String name = null;
Enumeration values = null;

while(names.hasMoreElements()){
	name = (String)names.nextElement(); %>
	<tr>
		<td valign='top' nowrap><%=name%></td>
		<td valign='top'>
		<%
		values = request.getHeaders(name);
		
		while(values.hasMoreElements()){ %>
		<%=(String)values.nextElement()%><br>
		<%
		} %>
		</td>
	</tr>
<%
} %>
</table>


<br><br>

<h3>Request Parameters (HttpServletRequest.getParameter())</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th width='30%'>Name</th>
	<th>Value</th>
</tr>
<%
Enumeration paramNames = request.getParameterNames();
String paramName = null;
String[] paramValues = null;

while(paramNames.hasMoreElements()){
	paramName = (String)paramNames.nextElement(); %>
	<tr>
		<td valign='top' nowrap><%=paramName%></td>
		<td valign='top'>
		<%
		paramValues = request.getParameterValues(paramName);
		
		for(int i = 0, n = paramValues.length; i < n; i++){ %>
		<%=(String)paramValues[i]%><br>
		<%
		} %>
		</td>
	</tr>
<%
} %>
</table>

<br><br>

<h3>Request Attributes (HttpServletRequest.getAttribute())</h3>
<table border='1' width='600' cellspacing='0' cellpadding='1'>
<tr>
	<th width='30%'>Name</th>
	<th>Value</th>
</tr>
<%
Enumeration attrNames = request.getAttributeNames();
String attrName = null;

while(attrNames.hasMoreElements()){
	attrName = (String)attrNames.nextElement(); %>
	<tr>
		<td valign='top' nowrap><%=attrName%></td>
		<td valign='top'><%=request.getAttribute(attrName).toString()%></td>
	</tr>
<%
} %>
</table>

<br><br>
<a href='#pageTop'>top</a>
<br><br>

</div>
</body>
</html>