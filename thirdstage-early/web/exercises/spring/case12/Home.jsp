<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Flight Booking Service</title>
</head>

<body>
<h1>Welcome to the Flight Booking Service</h1>
<p>We have the following specials now :</p>
<ul>
	<c:forEach items="${specials}" var="special">
	<li>${special.departForm.name} - ${special.arriveAt.name} from  $${special.cost}</li>
	</c:forEach>
</ul>

<p><a href="search">Search for a flight.</a></p>

</body>
</html>