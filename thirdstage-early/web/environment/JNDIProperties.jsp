<%@ page language="java" import="java.util.*,javax.naming.*" %>

<%
response.setContentType("text/html");
String name = request.getParameter("name"); %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Initial Context Properties</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
<META http-equiv="Pragma" content="No-cache"/>
<META http-equiv="Cache-Control" content="no-cache"/>
<META http-equiv="Cache-Control" content="no-store"/>
<META name="Author" content="Sang-Moon Oh"/>


<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
	this.document.forms['contextForm'].elements['name'].focus()
	<%
	if(name != null && name.trim().length() != 0){ %>
		this.document.forms['contextForm'].elements['name'].value = '<%=name.trim()%>'
	<%
	} %>

}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, ±¼¸²; font-size:14pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H2 {font-family:Verdana, ±¼¸²; font-size:13pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H3 {font-family:Verdana, ±¼¸²; font-size:12pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H4 {font-family:Verdana, ±¼¸²; font-size:11pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H5 {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
P {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black; margin-top:3pt; margin-bottom:3pt; border:none}
TD {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Tahoma, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, ±¼¸²; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>

</head>

<body onLoad='JavaScript:initPage()'>
<div align='left'><a name='pageTop'></a>

			<table border='0' cellspacing='1' cellpadding='1'>
				<tr>
					<td><H1>JNDI Properties</H1></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><h5>(for JSP 2.0 or Higher)</h5></td>
				</tr>
			</table>

			<BR>

			<FORM name='contextForm' action='./JNDIProperties.jsp' target='_self' 
				method='POST' onSubmit='JavaScript:return checkToSubmit()'>
				<TABLE border='0' width='600' cellspacing='1' cellpadding='1'>
					<TR>
						<TD align='left' valign='top' nowrap style='font-weight:bold' width='20%'>Name</TD>
						<TD align='left' valign='top'>:
						<input name='name' type='text' size='30' value='java:'>
						&nbsp;&nbsp;&nbsp;
						<INPUT name='submit' type='submit' value='execute'>
					</TR>
				</TABLE>
			</FORM>
			
<br><br><br>
			
<%
javax.naming.Context cntx = new InitialContext();
Object obj = null;

if(name != null && name.trim().length() != 0){
	name = name.trim();
	try{
		obj = cntx.lookup(name);

		if(obj instanceof javax.naming.Context){
			cntx = (javax.naming.Context)cntx;
		}
		else{ %>
			<P>The object bound to '<%=name%>' is not instance of context</P>
			<br><br>
		<%
		}
	}
	catch(NamingException ex){ %>
			<P>There's no object bound to '<%=name%></P>
			<br><br>
	<%	
	}
}
else name = cntx.getNameInNamespace();
%>
<P>Context Name - <SPAN style='font-weight:bold'><%=name%> </SPAN></P>

<br>

<H3>Environment: </H3>
<TABLE border='1' width='600' cellspacing='0' cellpadding='1'>
<TR>
	<TH width='50%'>Property</TH>
	<TH>Value</TH>
</TR>
<%
Map env = cntx.getEnvironment();
Iterator keys = env.keySet().iterator();
Object key = null;
while(keys.hasNext()){
	key = keys.next();
%>
	<TR>
		<TD valign='top' nowrap><%=key.toString()%></TD>
		<TD valign='top'><%=env.get(key).toString()%></TD>
	</TR>
<%
}
%>
</TABLE>

<BR><BR>

<H3>Included Names : </H3>
<TABLE border='1' width='600' cellspacing='0' cellpadding='1'>
<TR>
	<TH width='50%'>Name</TH>
	<TH>Class</TH>
	<TH>Object</TH>
</TR>
<%
NamingEnumeration enums = cntx.listBindings(name);
NameClassPair pair = null;
Binding binding = null;
String name2 = null;

while(enums.hasMore()){
	/*
	pair = (NameClassPair)(enums.next());
	pair.setRelative(false);
	name2 = (new CompositeName(name)).add(pair.getName()).toString();
	*/
	
	binding = (Binding)(enums.next());
	binding.setRelative(false);
	name2 = (new CompositeName(name)).add(binding.getName()).toString();
	obj = binding.getObject();
%>
	<TR>
		<TD valign='top' nowrap>
		<%
		if(obj instanceof javax.naming.Context){ %>
			<a href='./JNDIProperties.jsp?name=<%=name2%>' target='_self'><%=name2%></a>
		<%
		}
		else{ %>
			<%=name2%>
		<%
		} %>
		</TD>
		<TD valign='top'><%=binding.getClassName()%></TD>
		<TD><%=obj.toString()%></TD>
	</TR>
<%
}
%>
</TABLE>
<BR><BR>



<A href='#pageTop'>top</A>
<br><br>

</div>
</body>
</html>