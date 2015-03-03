<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="org.springframework.web.bind.*" %>
<%@ page import="org.springframework.beans.*" %>
<%@ page import="thirdstage.exercise.spring3.catalog.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create Item Action</title>
</head>

<%!
private <E> void bindList(List<E> values, Class<E> clazz, PropertyValues pvs) throws Exception{

	E obj = null;

	for(int i = 0; ; i++){
		obj = clazz.newInstance();
		
	}
	
	
	
	
	
	
}

%>

<body>

<%

MutablePropertyValues mpvs = new ServletRequestParameterPropertyValues(request);
PropertyValue[] pvs = mpvs.getPropertyValues();



List<Item> items = new ArrayList<Item>();
ServletRequestDataBinder binder = new ServletRequestDataBinder(items);
binder.bind(request);
request.setAttribute("items", items);
%>

<p>
<%=items.size() %> Items created.
</p>

<table border='1' cellspacing='0' cellpadding='1'>
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Price</th>
	<th>Stocks</th>
</tr>
<c:forEach items="items" var="item">


</c:forEach>
</table>







</body>
</html>