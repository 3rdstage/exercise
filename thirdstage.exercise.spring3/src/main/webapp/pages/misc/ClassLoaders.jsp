<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="org.springframework.util.*" %> 
<%@ page import="thirdstage.exercise.spring3.loading.FrontController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

<%!
public static List<ClassLoader> getAncestorClassLoaders(ClassLoader cl){
	
	if(cl == null) throw new IllegalArgumentException("");
	
	List<ClassLoader> ancestors = new ArrayList<ClassLoader>();
	ClassLoader current = cl;

	while(current != null){
		ancestors.add(current);
		System.out.println("ClassLoader Added : " + current.toString());
		current = current.getParent();
	}
	
	Collections.reverse(ancestors);
	return ancestors;
}

%>

<%
Map<String, ClassLoader> cls = new HashMap<String, ClassLoader>();
ClassLoader cl1 = ClassLoader.getSystemClassLoader();
cls.put("System class loader", cl1);
ClassLoader cl2 = FrontController.class.getClassLoader();
cls.put("Class loader for ForntController servlet class", cl2);
ClassLoader cl3 = this.getClass().getClassLoader();
cls.put("Class loader for this JSP page's class", cl3);
ClassLoader cl4 = Thread.currentThread().getContextClassLoader();
cls.put("Context class loader for current thread", cl4);
 
ClassLoader cl = null; 
List<ClassLoader> ancestors = null;
Set<String> keys = cls.keySet();
for(String key : keys){
	cl = cls.get(key);
	ancestors = getAncestorClassLoaders(cl); %>
	
	<h4><%= key %></h4>
	<ul>
	<%
	for(ClassLoader cll : ancestors){ %>
		<li><%= cll.toString() %></li>
	<%
	} %>
	
	</ul>
<%
} %>


</body>
</html>