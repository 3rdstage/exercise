<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create Account</title>
</head>
<body>

<h1>Create Account</h1>
<form:form modelAttribute="account" action="account" method="post">
	<fieldset>
		<legend>Account Fields</legend>	
		<p>
			<form:label for="name" path="name">Name</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<p>
			<form:label for="balance" path="balance" cssErrorClass="error">Balance</form:label>
			<form:input path="balance"/>
			<form:errors path="balance"/>
		</p>
		<p>
			<form:label for="equityAllocation" path="equityAllocation" cssErrorClass="error">Equity Allocation</form:label>
			<form:input path="equityAllocation"/>
			<form:errors path="equityAllocation"/>
		</p>	
		<p>
			<form:label for="renewalDate" path="renewalDate" cssErrorClass="error">Renewal Date</form:label>
			<form:input path="renewalDate"/>
			<form:errors path="renewalDate"/>
		</p>
		<p>
			<input type="submit" value="create"/>
		</p>	
	
	</fieldset>
</form:form>
	

</body>
</html>