<%@page language="java" session="true" autoFlush="true" isThreadSafe="true"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
  

<f:view>
	<f:loadBundle var='bundle' basename='thirdstage.accesscontrol.Resources' />
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
			<meta http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
			<meta http-equiv="Pragma" content="No-cache"/>
			<meta http-equiv="Cache-Control" content="no-cache"/>
			<meta http-equiv="Cache-Control" content="no-store"/>
			<meta name="Author" content="Sang-Moon Oh"/> 
			<title>User Registration</title>
		
			<script type="text/javascript" language="JavaScript">
				// page scope script
				function initPage(){
				this.document.forms['registrationForm'].elements['registrationForm:name'].focus()
				}

				function checkToSubmit(){
				return true
				}
			</script>

			<style type="text/css">
				/* page scope style */
				BODY {background:#FFFFFF; font-family:Verdana, 돋움; font-size:9pt}
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
				TH {font-family:Verdana, 돋움; font-size:9pt; font-weight:bold; color:black; background-color:#f5f5f5}
				TH.blank {margin:0pt; padding:0pt; border:0pt; height:0pt}
				INPUT {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
				SMALL {font-family:Arial, 돋움; font-size:8pt; font-weight:normal; color:black}
				HR.normal {text-align:left; width:600px}
			</style>
		</head>
	
		<body onLoad='JavaScript:initPage()'>
			<div align='left'><a name='pageTop'/></a>
				<table border='0' cellspacing='0' cellpadding='0'>
					<tr>
						<td class='title'><h:outputText value='#{bundle["title.userRegistration"]}' rendered='true' /></td>
					</tr>
				</table>
		
				<br><br>

				<h:form id="registrationForm">
					<table class='detail' width='600' border='0' cellspacing='1' cellpadding='2'>
						<tr>
							<th class='blank' width='30%'/>
							<th class='blank' width='70%'/>
						</tr>
						<tr>
							<td class='item'>이름</td>
							<td><h:inputText id='name' value='#{userBean.name}' size='20'/></td>
						</tr>
						<tr>
							<td class='item'>주민등록번호</td>
							<td><h:inputText id='rrn' value='#{userBean.residentRegistrationNo}' size='13' maxlength='13'/> (- 없이)</td>
						</tr>
						<tr>
							<td class='item'>사용자 ID</td>
							<td><h:inputText id='id' value='#{userBean.id}' size='20' maxlength='12'/></td>
						</tr>
						<tr>
							<td class='item'>비밀번호</td>
							<td><h:inputSecret id='passwd' value='#{userBean.password}' size='20' maxlength='8'/></td>
						</tr>
						<tr>
						<td class='item'>역할</td>
						<td>
							<h:selectOneMenu id='role' value='#{userBean.roleId}'>
								<f:selectItems id='roles' value='#{userRegistrationPageHelper.allRoles}'/>
							</h:selectOneMenu>
						</td>
					</table>
					<br>
					<table width='600' border='0' cellspacing='0' cellpadding='2'>
						<tr>
							<td align='right'><h:commandButton id='button' action='#{userBean.register}' value='register'/></td>
						</tr>
					</table>
				</h:form>
		
			
				<c:if test='${(initParam["verboseOn"] == "true") && (param["registrationForm:register"] != null)}'>
					<c:out value='<br><br><h5>Verbose Message</h5>' escapeXml="false"/><br/>
					<c:out value='Name : ${requestScope.userBean.name}'/><br/>
					<c:out value='Resident Registration No. : ${requestScope.userBean.residentRegistrationNo}'/><br/>
					<c:out value='ID : ${requestScope.userBean.id}'/><br/>
					<c:out value='Password : ${requestScope.userBean.password}'/><br/>
		
					<c:out value='${request.requestURL}'/>
					<c:out value='${param["case"]}'/>
				</c:if>


				<%
				thirdstage.platform.web.DebugUtil debugUtil = new thirdstage.platform.web.DebugUtil(true);
				debugUtil.verboseRequestInfoOnPage(request, out); %>

				<br/><br/>
				<a href='#pageTop'>top</a>
				<br/><br/>
			</div>
		</body>
	</html>
</f:view>
