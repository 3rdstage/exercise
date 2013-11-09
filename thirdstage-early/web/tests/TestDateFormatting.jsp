<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<f:view>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
		<meta http-equiv="Pragma" content="No-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-store"/>
		<meta name="Author" content="Sang-Moon Oh"/> 
		<title>Date Formatting Test</title>
		
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
			BODY {background:#FFFFFF}
			H1 {font-family:Verdana, ±¼¸²; font-size:14pt; font-weight:bold; color:navy}
			H2 {font-family:Verdana, ±¼¸²; font-size:13pt; font-weight:bold; color:navy}
			H3 {font-family:Verdana, ±¼¸²; font-size:12pt; font-weight:bold; color:navy}
			H4 {font-family:Verdana, ±¼¸²; font-size:11pt; font-weight:bold; color:navy}
			H5 {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:navy}
			P {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
			TD {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
			TH {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:black}
			INPUT {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
			SMALL {font-family:Arial, ±¼¸²; font-size:9pt; font-weight:normal; color:black}
			HR.normal {text-align:left; width:600px}
		</style>
	</head>

	
	<body onLoad='JavaScript:initPage()'>
		<div align='left'><a name='pageTop'/>

			<table border='0' cellspacing='0' cellpadding='2'>
				<tr>
					<td><H1>Date Formatting Test</H1></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><h5>(JSF 1.1)</h5></td>
				</tr>
			</table>

			<br>
		
		
		<%
		java.util.Date currentDate = new java.util.Date();
		pageContext.setAttribute("currentDate", currentDate, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
		%>
		

 
			<table border="1" width="600">
				<tr>
					<th>Locale</th>
					<th>TimeZone</th>
					<th>DateStyle</th>
					<th>TimeStyle</th>
					<th>Output</th>
				</tr>
				<tr>
					<td>Korea</td>
					<td>Asia/Seoul</td>
					<td>full</td>
					<td>full</td>
					<td>
						<h:outputText value="#{requestScope.currentDate}">
						<f:convertDateTime locale="ko" timeZone="Asia/Seoul" dateStyle="full" timeStyle="full" type="both"/>
						</h:outputText>
					</td>
				</tr>
				<tr>
					<td>Korea</td>
					<td>GMT</td>
					<td>full</td>
					<td>full</td>
					<td>
						<h:outputText value="#{requestScope.currentDate}">
						<f:convertDateTime locale="ko" timeZone="GMT" dateStyle="full" timeStyle="full" type="both"/>
						</h:outputText>
					</td>
				</tr>
				<tr>
					<td>US</td>
					<td>America/Los_Angeles</td>
					<td>full</td>
					<td>full</td>
					<td>
						<h:outputText value="#{requestScope.currentDate}">
						<f:convertDateTime locale="en" timeZone="America/Los_Angeles" dateStyle="full" timeStyle="full" type="both"/>
						</h:outputText>
					</td>
				</tr>
				<tr>
					<td>US</td>
					<td>America/New_York</td>
					<td>full</td>
					<td>full</td>
					<td>
						<h:outputText value="#{requestScope.currentDate}">
						<f:convertDateTime locale="en" timeZone="America/New_York" dateStyle="full" timeStyle="full" type="both"/>
						</h:outputText>
					</td>
				</tr>
				<tr>
					<td>US</td>
					<td>GMT</td>
					<td>full</td>
					<td>full</td>
					<td>
						<h:outputText value="#{requestScope.currentDate}">
						<f:convertDateTime locale="en" timeZone="GMT" dateStyle="full" timeStyle="full" type="both"/>
						</h:outputText>
					</td>
				</tr>
			</table>
		
			<br/><br/>
			<a href='#pageTop'>top</a>
			<br/><br/>
		</div>
	</body>
</html>
</f:view>
