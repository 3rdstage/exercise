<%@ page language="java" session="true" autoFlush="true" isThreadSafe="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.lang.*" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="thirdstage.exercise.hibernate3.case1.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:requestEncoding value="UTF-8"/>

<html>
<head>
<title>Simple Hibernate Annotation Test</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META name="Author" content="Sang-Moon Oh">
<META name="Version" content="1.0, 2005-03-26">
<META name="Since" content="2005-03-26">

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
	this.document.forms['registerForm'].elements['id'].focus()
}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {font-family:Verdana, 돋움; font-size:9pt; background:#ffffff}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy}
H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy}
P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
TABLE {background-color:#d6d6d6}
TABLE.search {background-color:#d6d6d6}
TABLE.list {background-color:#d6d6d6}
TABLE.detail {background-color:#d6d6d6}
TD {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; background-color:white}
TD.title {font-size:12pt; font-weight:bold; color:navy}
TD.search {background-color:#f5f5f5} 
TD.item {background-color:#f5f5f5}
TH {font-family:Verdana, 돋움; font-size:9pt; font-weight:bold; color:black; background-color:#f5f5f5; text-align:center}
TH.blank {margin:0pt; padding:0pt; border:0pt; height:0pt}
INPUT {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 돋움; font-size:8pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
<head>


<body onLoad='JavaScript:initPage()'>
<div align='left'><a name='pageTop'/>
    
<h1>Simple Hibernate Annotation Test</h1>
<br>
<h3>New Cat</h3>
<form name='registerForm' action='./SimpleHibernateAnnotations.jsp' 
      accept-charset="UTF-8" onSubmit='JavaScript:return checkToSubmit()'>
<table width='400' border='0' cellspacing='1' cellpadding='2'>
<tr>
	<th class='blank'></th>
	<th class='blank'></th>
</tr>
<tr>
	<td class='item'>ID</td>
	<td><input type='text' name='id' size='20' maxlength='32'></td>
</tr>
<tr>
	<td class='item'>Name</td>
	<td><input type='text' name='name' size='20' maxlength='16'></td>
</tr>
<tr>
	<td class='item'>Sex</td>
	<td>
		<input type='radio' name='sex' value='M' checked> Male 
		<input type='radio' name='sex' value='F'> Female
	</td>
</tr>
<tr>
	<td class='item'>Weight</td>
	<td>
		<input type='text' name='weight' size='20' maxlength='10'>
		<input type='submit' name='register' value='register'>
	</td>
</tr>
</table>

<br><br>

<%
String id = request.getParameter("id");
String name = null;
String sex = null;

org.hibernate.Session sess = null;
org.hibernate.Transaction tx = null;
Cat2 cat = null;

if(id != null && id.length() > 0){
	name = request.getParameter("name");
	sex = request.getParameter("sex");
	
	try{
		sess = thirdstage.exercise.hibernate3.case1.HibernateUtil2.currentSession();
		tx = sess.beginTransaction();
		
		cat = new thirdstage.exercise.hibernate3.case1.Cat2();
		cat.setId(id.trim());
		cat.setName(name);
		if(sex.equals("M")) cat.setSex('M');
		else if(sex.equals("F")) cat.setSex('F');
		
		sess.save(cat);
		tx.commit(); %>
		<p>New cat is registered successfully</p>
		<%
	}
	catch(Throwable ex){
		out.println(ex.toString());
	}
	finally{
		if(sess != null){
			try{ thirdstage.exercise.hibernate3.case1.HibernateUtil2.closeSession(); }
			catch(Exception ex){}
		}
	}
				
}
%>

<br><br>

<h3>Cat List</h3>
<table width='560' border='0' cellspacing='1' cellpadding='2'>
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Sex</th>
	<th>Weight</th>
</tr>
	
<%
try{
	sess = thirdstage.exercise.hibernate3.case1.HibernateUtil2.currentSession();
	tx = sess.beginTransaction();
	
	org.hibernate.Query query = sess.createQuery("select c from Cat2 as c");
	for(java.util.Iterator it = query.iterate(); it.hasNext(); ){
		cat = (thirdstage.exercise.hibernate3.case1.Cat2)(it.next()); %>
	<tr>
		<td><%=cat.getId()%></td>
		<td><%=cat.getName()%></td>
		<td><%=cat.getSex()%></td>
		<td><%=cat.getWeight()%></td>
	</tr>
	<%
	}
	tx.commit();
}
catch(Exception ex){
	out.println(ex.toString());
}
finally{
	if(sess != null){
		try{ thirdstage.exercise.hibernate3.case1.HibernateUtil2.closeSession(); }
		catch(Exception ex){}
	}
} %>
</table>
		

<br/><br/>
<a href='#pageTop'>top</a>
<br/><br/>
</div>
</body>
</html>
