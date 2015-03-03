<%@ page language="java" session="true" autoFlush="true" isThreadSafe="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.lang.*" %>
<%@ page import="thirdstage.platform.web.*,thirdstage.accesscontrol.dao.*,thirdstage.accesscontrol.vo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:requestEncoding value="UTF-8"/>


<html>
<head>
<title>Role</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
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
BODY {font-family:Verdana, 돋움; font-size:9pt; background:#ffffff}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy}
H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy}
P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
TABLE {background-color:white}
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


<body onLoad='JavaScript:initPage()'>
<div align='left'><a name='pageTop'/>

<h1>Add Role (ServiceLocator Test)</h1>
<br>
<form name='addForm' method='POST' target='_self' action='./AddRole.jsp' accept-charset='UTF-8'>
<table border='0' cellspacing='1' cellpadding='2' width='400'>
	<tr>
		<th></th>
		<th></th>
	<tr>
		<td>Name : </td>
		<td><input name='name' type='text' size='30' maxlength='30' value='<%=request.getParameter("name") != null ? request.getParameter("name").trim() : ""%>'></td>
	</tr>
	<tr>
		<td>Description : </td>
		<td><input name='description' type='text' size='30' value='<%=request.getParameter("description") != null ? request.getParameter("description").trim() : ""%>'></td>
	</tr>
	<tr>
		<td colspan='2' align='right'><input name='submit' type='submit' value='enter'></td>
	</tr>
</table>
</form>

<br><br>

<%
if(request.getParameter("name") != null && request.getParameter("name").trim() != ""){
	
	try{
		ServiceLocatorFactory slFactory = ServiceLocatorFactory.getInstance();
		try{
			slFactory.putServiceLocator("accessControl", null);
		}
		catch(IllegalStateException ex){}

		RoleNormalValue role = new RoleNormalValue("", request.getParameter("name").trim(), request.getParameter("description"));
	
		RoleDAO dao = new RoleDAO();
		dao.createRole(role);
	
		out.println("Add Role Successfully");
	}
	catch(Exception ex){
		out.println(ex.toString());
	}
}
%>    
		
<br/><br/>
<a href='#pageTop'>top</a>
<br/><br/>
</div>
</body>
</html>
