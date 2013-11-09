<%@page contentType="text/xml"%>
<%@page pageEncoding="UTF-8"%>

<%!
private java.util.Map users = new java.util.HashMap();

public void jspInit(){
	users.put("greg", "account data");
	users.put("duke", "account date");
}
%>

<%
response.setHeader("Cache-Control", "no-cache");
String targetId = request.getParameter("id");
%>
<message>
<%
if(targetId != null && users.containsKey(targetId.trim())){
	response.getWriter().write("valid");
}
else{
	response.getWriter().write("invalid");
}
%>
</message>

%>