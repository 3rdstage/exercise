<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="javax.naming.Context" %>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.rmi.PortableRemoteObject"%>
<%@page import="thirdstage.exercise.ejb2.case11.*"%>
<%@page import="thirdstage.exercise.ejb2.case11.order.*"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Order by Remote Service</title>
</head>
<body>

<%
Context jndiCtx = new InitialContext();

Object obj = jndiCtx.lookup("ejb/simple/remote/OrderService");
OrderRemoteServiceHome home = (OrderRemoteServiceHome)PortableRemoteObject.narrow(obj, OrderRemoteServiceHome.class);
			
OrderRemoteService orderService = home.create();
OrderValue order = new OrderValue();
order.setCustomerId("CST00031");
order.setProductId("PRD23074");
order.setQty(3);

order = orderService.makeOrder(order);%>

<p>The order is registered like followings.</p>
<pre>
<%= order.toString() %>
</pre>

</body>
</html>