<%@ page language="java" import="java.util.*,javax.naming.*" %>

<%
response.setContentType("text/html");
%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Initial Context Properties</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
<META http-equiv="Pragma" content="No-cache"/>
<META http-equiv="Cache-Control" content="no-cache"/>
<META http-equiv="Cache-Control" content="no-store"/>
<META name="Author" content="Sang-Moon Oh"/>


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
H4 {font-family:Verdana, ±¼¸²; font-size:11pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H5 {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
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

<h1>Initial Context Properties</h1>

<br><br><br>

<%
Context initCtx = new InitialContext();
String name = initCtx.getNameInNamespace();
%>
<P>Context Name - <SPAN style='font-weight:bold'><%=name%> </SPAN></P>
<BR>


<H3>Environment Properties : </H3>
<TABLE border='1' width='600' cellspacing='0' cellpadding='1'>
<TR>
	<TH width='50%'>Property</TH>
	<TH>Value</TH>
</TR>
<%
Map env = initCtx.getEnvironment();
Iterator keys = env.keySet().iterator();
Object key = null;
while(keys.hasNext()){
	key = keys.next();
%>
	<TR>
		<TD valign='top' nowrap><%=key.toString()%></TD>
		<TD valign='top'><%=env.get(key).toString()%></TD>
	</TR>
<%
}
%>
</TABLE>
<BR><BR>

<H3>Included Names : </H3>
<TABLE border='1' width='600' cellspacing='0' cellpadding='1'>
<TR>
	<TH width='50%'>Name</TH>
	<TH>Class</TH>
</TR>
<%
NamingEnumeration enums = initCtx.list(name);
NameClassPair pair = null;
while(enums.hasMore()){
	pair = (NameClassPair)(enums.next());
%>
	<TR>
		<TD valign='top' nowrap><%=pair.getName()%></TD>
		<TD valign='top'><%=pair.getClassName()%></TD>
	</TR>
<%
}
%>
</TABLE>
<BR><BR>



<A href='#pageTop'>top</A>
<br><br>

</div>
</body>
</html>