<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sample Page</title>
<style type="text/css">
/*<![CDATA[*/ /* page scope style */
body {
	font-family: Verdana, 돋움;
	font-size: 9pt;
	margin-left: 5pt;
	background: #ffffff
}

h1 {
	font-family: Verdana, 굴림;
	font-size: 14pt;
	font-weight: bold;
	color: navy;
	margin-top: 4pt;
	margin-bottom: 4pt;
	border: none
}

h2 {
	font-family: Verdana, 굴림;
	font-size: 13pt;
	font-weight: bold;
	color: navy;
	margin-top: 4pt;
	margin-bottom: 4pt;
	border: none
}

h3 {
	font-family: Verdana, 굴림;
	font-size: 12pt;
	font-weight: bold;
	color: navy;
	margin-top: 4pt;
	margin-bottom: 4pt;
	border: none
}

h4 {
	font-family: Verdana, 굴림;
	font-size: 11pt;
	font-weight: bold;
	color: navy;
	margin-top: 4pt;
	margin-bottom: 4pt;
	border: none
}

h5 {
	font-family: Verdana, 굴림;
	font-size: 10pt;
	font-weight: bold;
	color: navy;
	margin-top: 3pt;
	margin-bottom: 3pt;
	border: none
}

P {
	font-family: Verdana, 돋움;
	font-size: 9pt;
	font-weight: normal;
	color: black;
	margin-top: 3pt;
	margin-bottom: 3pt;
	border: none
}

table {
	background-color: #d6d6d6
}

table.search {
	background-color: #d6d6d6
}

table.list {
	background-color: #d6d6d6
}

table.detail {
	background-color: #d6d6d6
}

td {
	font-family: Verdana, 돋움;
	font-size: 9pt;
	font-weight: normal;
	color: black;
	background-color: white
}

td.title {
	font-size: 12pt;
	font-weight: bold;
	color: navy
}

td.search {
	background-color: #f5f5f5
}

td.item {
	background-color: #f5f5f5
}

th {
	font-family: Verdana, 돋움;
	font-size: 9pt;
	font-weight: bold;
	color: black;
	background-color: #f5f5f5;
	text-align: center
}

th.blank {
	margin: 0pt;
	padding: 0pt;
	border: 0pt;
	height: 0pt
}

input {
	font-family: Verdana, 돋움;
	font-size: 9pt;
	font-weight: normal;
	color: black
}

small {
	font-family: Arial, 돋움;
	font-size: 8pt;
	font-weight: normal;
	color: black
}

hr.normal {
	text-align: left;
	width: 600px
}
/*]]>*/
</style>

</head>
<body>

<h3>List of All Accouts</h3>
<br/>
<br/>
<table width="800" border="1" cellspacing="0" cellpadding="1">
<tr>
	<th>Username</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>e-Mail</th>
	<th>Phone Number</th>
</tr>
<c:forEach items="${accounts}" var="account">
	<tr>
		<td>${account.username}</td>
		<td>${account.firstName}</td>
		<td>${account.lastName}</td>
		<td>${account.email}</td>
		<td>${account.phone}</td>
	</tr>
</c:forEach>
</table>
<br/>
<br/>
<hr align="left" width="800"/>



</body>
</html>