<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create Multiple Items</title>
</head>
<body>

<h1>Create Multiple Items</h1>


<form action="<%=request.getContextPath()%>/pages/catalog/CreateItems.jsp" method="post"> 
<table border="1" width="600" cellspacing='0' cellpadding='1'>
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Price</th>
	<th>Stocks</th>
</tr>
<tr>
	<td><input name="id" type="text" value="ITM0010"></input></td>
	<td><input name="name" type="text" value="Vega Racer"></input></td>
	<td><input name="price" type="text" value="1000"></input></td>
	<td><input name="stocks" type="text" value="60"></input></td>
</tr>
<tr>
	<td><input name="id" type="text" value="ITM0011"></input></td>
	<td><input name="name" type="text" value="Optimus Black"></input></td>
	<td><input name="price" type="text" value="1100"></input></td>
	<td><input name="stocks" type="text" value="50"></input></td>
</tr>
<tr>
	<td><input name="id" type="text" value="ITM0010"></input></td>
	<td><input name="name" type="text" value="Galaxy S2"></input></td>
	<td><input name="price" type="text" value="1200"></input></td>
	<td><input name="stocks" type="text" value="40"></input></td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>
		<input name="_serviceId" type="hidden" value="ADD_ITEMS"/>
		<input name="_targetPage" type="hidden"	value=""/>
		<input name="submit" type="submit"/>
	</td>
</tr>



</table>
</form>

</body>
</html>