<%@ page language="java" session="true" autoFlush="true" isThreadSafe="true" %>
<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.lang.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
  

<f:view>
	<f:loadBundle var='bundle' basename='thirdstage.accesscontrol.Resources' />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR"/>
		<meta http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
		<meta http-equiv="Pragma" content="No-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-store"/>
		<meta name="Author" content="Sang-Moon Oh"/> 
		<title>JSF 1.1 and JSTL 1.1 Page Template</title>
		
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

	
<body onLoad='JavaScript:initPage()'>
<div align='left'><a name='pageTop'/>
    
<table border='0' cellspacing='0' cellpadding='0'>
<tr>
	<td class='title'><h:outputText value='#{bundle["title.userSearch"]}' rendered='true' /></td>
</tr>
</table>
	
<br><br>

<h:dataTable id='userList' value='#{userSearchPageHelper.allUsers}' var='user'
             border='0' width='560' cellspacing='1' cellpadding='2'>
<h:column>
	<f:facet name='header'><h:outputText value='#{bundle["field.id"]}'/></f:facet>
	<h:outputText value='#{user.id}'/>
</h:column>
<h:column>
	<f:facet name='header'><h:outputText value='#{bundle["field.role"]}'/></f:facet>
	<h:outputText value='#{user.roleName}'/>
</h:column>
<h:column>
	<f:facet name='header'><h:outputText value='#{bundle["field.name"]}'/></f:facet>
	<h:outputText value='#{user.name}'/>
</h:column>
<h:column>
	<f:facet name='header'><h:outputText value='#{bundle["field.rrn"]}'/></f:facet>
	<h:outputText value='#{user.residentRegistrationNo}'/>
</h:column>
</h:dataTable>
		
<br/><br/>
<a href='#pageTop'>top</a>
<br/><br/>
</div>
</body>
</html>
</f:view>
