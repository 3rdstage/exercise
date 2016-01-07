<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create Single Item</title>
<script>

function onLoad(){
	
	document.forms['createItemForm'].elements['id'].focus();
}
</script>
</head>

<body onload="onLoad()">

<h1>Create Single Item</h1>


<form name='createItemForm' action="<%=request.getContextPath()%>/pages/catalog/CreateItem.jsp" method="post"> 
<table border="1" width="600" cellspacing='0' cellpadding='1'>
<tr>
	<td>ID</td>
	<td><input name="id" type="text" value='ITM0001'/></td>
</tr>
<tr>
	<td>Name</td>
	<td><input name="name" type="text" value='EOS 600D Body'/></td>
</tr>
<tr>
	<td>Price</td>
	<td><input name="price" type="text" value='1000'/></td>
</tr>
<tr>
	<td>Number in Stock</td>
	<td><input name="stocks" type="text" value='20'/></td>
</tr>


<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>
		<input name="_serviceId" type="hidden" value="ADD_ITEM"/>
		<input name="submit" type="submit"/>
	</td>
</tr>



</table>
</form>

</body>
</html>