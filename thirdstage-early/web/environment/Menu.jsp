<%@page language="java" import="java.net.*"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- to prevent caching 
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
-->
<META name="Author" content="Sang-Moon Oh">
<META name="Keywords" content="">
<META name="Description" content="">

<TITLE>Menu</TITLE>

<!-- to add external java script file
<SCRIPT type="text/javascript" language="JavaScript" src=""></SCRIPT>
-->
<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){}

function checkToSubmit(){}
</SCRIPT>

<!-- to add external style sheet file 
<LINK rel=StyleSheet href="" type="text/css">
-->
<STYLE type="text/css">
BODY {background:#FFFFFF}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
P {font-family:Tahoma, 굴림; font-size:9pt; font-weight:normal; color:black}
TD {font-family:Tahoma, 굴림; font-size:9pt; font-weight:normal; color:black}
TH {font-family:Tahoma, 굴림; font-size:9pt; font-weight:bold; color:black}
INPUT {font-family:Tahoma, 굴림; font-size:9pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 굴림; font-size:8pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
</HEAD>


<BODY onLoad='JavaScript:initPage()'>

<A name='pageTop'></A>

<H2>Menu</H2>

<TABLE border='0' width='180' cellspacing='1' cellpadding='1'>
<TR>
	<TD width='5'></TD>
	<TD></TD>
</TR>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./JVMProperties-JDK1.4.jsp' target='contentsFrm'>Java VM Properties</A></TD>
</TR>
<%
try{
	String sslPort = config.getServletContext().getInitParameter("sslPort");
	String url = "https://" + InetAddress.getLocalHost().getHostAddress()
	           + ":" + sslPort + request.getContextPath() 
	           + "/environment/JVMProperties-JDK1.4.jsp";

%>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='<%=url%>' target='contentsFrm'>Java VM Properties with SSL</A></TD>
</TR>
<%
}
catch(java.net.UnknownHostException ex){
	
}%>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./JNDIProperties.jsp' target='contentsFrm'>JNDI Properties</A></TD>
</TR>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./JNDIProperties-J2SE1.4.jsp' target='contentsFrm'>JNDI Properties 2</A></TD>
</TR>

<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./CommonResourceBundle-JSTL1.1.jsp' target='contentsFrm'>Common ResourceBundle</A></TD>
</TR>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./ServletContextProperties.jsp' target='contentsFrm'>ServletContext Properties</A></TD>
</TR>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./HttpServletRequestProperties.jsp?param=test' target='contentsFrm'>HttpServletRequest Properties</A></TD>
</TR>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./ScopedVariables-JSP2.0.jsp' target='contentsFrm'>Scoped Variables</A></TD>
</TR>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./DatabaseProperties.jsp' target='contentsFrm'>Database Properties</A></TD>
</TR>
<TR>
	<TD>&nbsp;</TD>
	<TD><A href='./MailSessionProperties.jsp' target='contentsFrm'>Mail Session Properties</A></TD>
</TR>

<TR>
	<TD>&nbsp;</TD>
	<TD>&nbsp;</TD>
</TR>

<TR>
	<TD>&nbsp;</TD>
	<TD><A href='../servlet/AxisServlet' target='contentsFrm'>Axis Admin</A></TD>
</TR>
</TABLE>

</BODY>
</HTML>
