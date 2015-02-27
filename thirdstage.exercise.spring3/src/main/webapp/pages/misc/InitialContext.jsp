<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, javax.naming.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Check Initial Context</title>
<style type="text/css">
body{
	counter-reset:step-for-h3;
}	
h3 {
	font-size:140%;
	counter-reset:step-for-h4;
}
h3:before {
	content:counter(step-for-h3) ". ";
	counter-increment:step-for-h3;
}
h4 {
	font-size:120%;
}
h4:before {
	content:counter(step-for-h3) "." counter(step-for-h4) ". ";
	counter-increment:step-for-h4;
}
</style>
</head>
<body>


<%!
public Map<String, NameClassPair> getNameClassPairsUnderContext(String name, Context cntx) throws Exception{
	
	Map<String, NameClassPair> result = new HashMap<String, NameClassPair>();  
	NamingEnumeration<NameClassPair> pairs = cntx.list("");
	NameClassPair pair = null;
	Object obj = null;
	String path = null;
	while(pairs.hasMore()){
		pair = pairs.next();
		obj = cntx.lookup(pair.getName());
		path = ("".equals(name) ? "" : name + "/") + pair.getName();
		
		if(obj instanceof javax.naming.Context){
			result.put(path, pair);
			result.putAll(getNameClassPairsUnderContext(path, (Context)obj));
		}
		else{
			result.put(path, pair);
		}
	}
	
	return result;
}

%>

<%
Context cntx = new InitialContext();
Map<String, NameClassPair> pairs = this.getNameClassPairsUnderContext(cntx.getNameInNamespace(), cntx);

Hashtable<?, ?> env = cntx.getEnvironment();
%>

<h3>Jetty</h3>
<h4>Environment</h4>
<table border="1" cellpadding="1" cellspacing="0">
<tr>
	<th>Key</th>
	<th>Value</th>
</tr>
<%
Set<?> envKeys = env.keySet();
for(Object key : envKeys){ %>
	<tr>
		<td><%= key.toString() %></td>
		<td><%= env.get(key) %></td>
	</tr>
<%
} %>
</table>

<h4>JNDI Entries</h4>
<p>Number of entries : <%=pairs.size()%></p>
<table border="1" cellpadding="1" cellspacing="0">
<tr>
	<th>Name Path</th>
	<th>Full Name</th>
	<th>Name</th>
	<th>Class</th>
</tr>
<%
Set<String> keys = new TreeSet<String>(pairs.keySet());
NameClassPair pair = null;
String name = null;
for(String key : keys){
	pair = pairs.get(key);
	try{
		name = pair.getNameInNamespace();
	}catch(Exception ex){ //full name can be unsupported
		name = "N/A";
	}
%>
	<tr>
		<td><%= key %></td>
		<td><%= name %></td>
		<td><%= pair.getName() %></td>
		<td><%= pair.getClassName() %></td>
	</tr>
<%
} %>
</table>

<br/>
<hr width="800" align="left"/>
<br/>

<%
Properties props2 = new Properties();
props2.setProperty("java.naming.factory.initial", "org.apache.openejb.client.LocalInitialContextFactory");
Context cntx2 = new InitialContext(props2);
Map<String, NameClassPair> pairs2 = this.getNameClassPairsUnderContext(cntx2.getNameInNamespace(), cntx2);

Context cntx3 = (Context)cntx2.lookup("openejb:");
Map<String, NameClassPair> pairs3 = this.getNameClassPairsUnderContext(cntx3.getNameInNamespace(), cntx3);

env = cntx2.getEnvironment();
%>

<h3>OpenEJB</h3>
<h4>Environment</h4>
<table border="1" cellpadding="1" cellspacing="0">
<tr>
	<th>Key</th>
	<th>Value</th>
</tr>
<%
envKeys = env.keySet();
for(Object key : envKeys){ %>
	<tr>
		<td><%= key.toString() %></td>
		<td><%= env.get(key) %></td>
	</tr>
<%
} %>
</table>


<h4>JNDI Entries under ""</h4>
<p>Number of entries : <%=pairs2.size()%></p>
<table border="1" cellpadding="1" cellspacing="0">
<tr>
	<th>Name Path</th>
	<th>Full Name</th>
	<th>Name</th>
	<th>Class</th>
</tr>
<%
keys = new TreeSet(pairs2.keySet());
for(String key : keys){
	pair = pairs2.get(key);
	try{
		name = pair.getNameInNamespace();
	}catch(Exception ex){ //full name can be unsupported
		name = "N/A";
	}
%>
	<tr>
		<td><%= key %></td>
		<td><%= name %></td>
		<td><%= pair.getName() %></td>
		<td><%= pair.getClassName() %></td>
	</tr>
<%
} %>
</table>

<br/>

<%
%>

<h4>JNDI Entries under "openejb:"</h4>
<p>Number of entries : <%=pairs3.size()%></p>
<table border="1" cellpadding="1" cellspacing="0">
<tr>
	<th>Name Path</th>
	<th>Full Name</th>
	<th>Name</th>
	<th>Class</th>
</tr>
<%
keys = new TreeSet(pairs3.keySet());
for(String key : keys){
	pair = pairs3.get(key);
	try{
		name = pair.getNameInNamespace();
	}catch(Exception ex){ //full name can be unsupported
		name = "N/A";
	}
%>
	<tr>
		<td><%= key %></td>
		<td><%= name %></td>
		<td><%= pair.getName() %></td>
		<td><%= pair.getClassName() %></td>
	</tr>
<%
} %>
</table>

<br/><br/><br/>

</body>
</html>