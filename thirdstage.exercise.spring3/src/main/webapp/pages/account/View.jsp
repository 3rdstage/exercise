<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>View Account</h1>
<form:form modelAttribute="account" action="${account.id}" method="post">
	<fieldset>
		<legend>Account Fields</legend>	
		<p>
			<form:label for="name" path="name">Name</form:label><br/>
			<form:input path="name" readonly="true"/>
		</p>
		<p>
			<form:label for="balance" path="balance">Balance</form:label><br/>
			<form:input path="balance" readonly="true"/>
		</p>	
		<p>
			<form:label for="equityAllocation" path="equityAllocation">Equity Allocation</form:label><br/>
			<form:input path="equityAllocation" readonly="true"/>
		</p>
		<p>
			<form:label for="renewalDate" path="renewalDate">Renewal	Date</form:label><br/>
			<form:input path="renewalDate" readonly="true"/>
		</p>		
	</fieldset>
</form:form>


</body>
</html>