<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.springframework.web.bind.*" %>
<%@ page import="thirdstage.exercise.spring3.catalog.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create Item Action</title>
</head>
<body>

<%

Item item = new Item();
ServletRequestDataBinder binder = new ServletRequestDataBinder(item);
binder.bind(request);
%>

<p>
Item created.
</p>
<ul>
	<li>ID : <%=item.getId() %></li>
	<li>Name : <%=item.getName() %></li>
	<li>Price : <%=item.getPrice() %></li>
	<li>Number in Stock : <%=item.getStocks() %></li>
</ul>





</body>
</html>