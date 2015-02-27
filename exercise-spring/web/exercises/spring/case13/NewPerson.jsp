<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Person Form</title>
</head>
<body>

<form method="post" action="">
<table>
<tr>
	<td>First Name :</td>
	<td><input type="text" name="name.first"/></td>
</tr>
<tr>
	<td>Last Name :</td>
	<td><input type="text" name="name.last"/></td>
</tr>
<tr>
	<td>Born On :</td>
	<td><input type="text" name="bornOn"/></td>
</tr>
<tr>
	<td>Favorite Programming Language</td>
	<td>
		<select name="favoriteProgrammingLanguage">
			<c:forEach items="${languages}" var="language">
				<option>${language}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<td />
	<td><input type="submit"/></td>
</tr>
</table>
</form>

</body>
</html>