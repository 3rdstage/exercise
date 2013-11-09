<%@page language="java" session="true" autoFlush="true" isThreadSafe="true"%>
<%@page contentType="text/html;charset=euc-kr"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%
response.setContentType("text/html;charset=EUC-KR");
request.setCharacterEncoding("EUC-KR");
%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Greetings</title>   
</head>

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

<body bgcolor="#FFFFFF">

<h1>Simple Page in JSP</h1>
<br>

  
<%
String name = request.getParameter("name");
%>

<H3 align='left'>
Hello!  <%=name%><BR>
Welcome to our site
</H3>

</body>
</html>