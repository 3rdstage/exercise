<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Flights List</title>
</head>
<body>

<h1>Flights List</h1>

<p>
You searched for flights leaving ${searchCriteria.departFrom} on or about
${searchCriteria.departOn}, heading to ${searchCriteria.arriveAt}, returning on
or about ${searchCriteria.returnOn}
</p>

<table>
<thead>
<tr>
	<th>Number of Legs</th>
	<th>Total Travle Time</th>
	<th>Total Cost</th>
</tr>
</thead>
<tbody>
	<c:forEach items="${flights}" var="flight">
	<tr>
		<td>${flight.numberOfLegs}</td>
		<td>${flight.totalTravelTime}</td>
		<td>${flight.totalCost}</td>
	</tr>
	</c:forEach>
</tbody>
</table>


</body>
</html>