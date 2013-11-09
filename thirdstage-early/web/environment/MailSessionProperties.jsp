<%@ page language="java" import="java.util.*,javax.naming.*,javax.mail.*"%>
<%
response.setContentType("text/html");
String referenceName = request.getParameter("referenceName");
if(referenceName == null || referenceName.trim().equals("")) referenceName = "";
%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Mail Session Properties</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META name="Author" content="Sang-Moon Oh"> 

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
	
	document.forms['nameForm'].elements['referenceName'].focus()
}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, ±¼¸²; font-size:14pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H2 {font-family:Verdana, ±¼¸²; font-size:13pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H3 {font-family:Verdana, ±¼¸²; font-size:12pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
P {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
TD {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, ±¼¸²; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>

</head>
<body onLoad='JavaScript:initPage()'>
<div align='left'><a name='pageTop'></a>

<H1>Mail Session Properties</H1>
<BR>

<FORM name='nameForm' action='./MailSessionProperties.jsp' target='_self' 
           method='POST' onSubmit='JavaScript:return checkToSubmit()'>
<TABLE border='0' width='600' cellspacing='1' cellpadding='1'>
<TR>
	<TD valign='top' nowrap style='font-weight:bold'>Resource Reference Name<BR>for the Mail Session</TD>
	<TD valign='top'>:
		<INPUT name='referenceName' type='text' size='30' value='<%=referenceName%>'>
		<INPUT name='submit' type='submit' value='execute'>
	</TD>
</TR><TR>
	<TD>&nbsp;</TD>
	<TD><small>(the value defined as a 'res-ref-name' element in the web.xml or something, usually starting 'mail/')</small></TD>
</TR>
</TABLE>
</FORM>
<BR>


<%
if(!referenceName.equals("")){
	
	try{ 
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		javax.mail.Session mailSession = (javax.mail.Session)envCtx.lookup(referenceName);
		Properties prop = mailSession.getProperties();
		Enumeration names = prop.propertyNames();
		String name = null;
		

%>
		<h3>Properties :</h3>
		<table border='1' width='600' cellspacing='0' cellpadding='1'>
		<tr>
			<th width='30%'>Name</th>
			<th>Value</th>
		</tr>
		<%
		while(names.hasMoreElements()){
			name = (String)names.nextElement();
		%>
			<tr>
				<td valign='top' nowrap><%=name%></td>
				<td valign='top'><%=prop.getProperty(name)%></td>
			</tr>
		<%
		}
		%>
		</table>
		<br><br>
		<%
		Provider[] providers = mailSession.getProviders();

		%>
		<h3>Providers :</h3>
		<table border='0' width='100%' cellspacing='1' cellpadding='1'>
		<tr>
			<th width='50'></th>
			<th></th>
		</tr>	
		<%
		for(int i = 0, n = providers.length; i < n; i++){
		%>
			<tr>
				<th align='left' valign='top' nowrap><%=providers[i].getProtocol()%></th>
				<td valign='top'>
					<table border='0' width='460' cellspacing='1' cellpadding='1'>
					<tr>
						<th width='200'></th>
						<th></th>
					<tr>
						<th align='left' valign='top' nowrap>Type</th>
						<td valign='top'>
							<%=(providers[i].getType().equals(Provider.Type.STORE)) ? "Store" : "Transport"%>
						</td>
					</tr>
					<tr>
						<th align='left' valign='top' nowrap>Vendor</th>
						<td valign='top'><%=providers[i].getVendor()%></td>
					</tr>
					<tr>
						<th align='left' valign='top' nowrap>Class</th>
						<td valign='top'><%=providers[i].getClass()%></td>
					</tr>
					<tr>
						<th align='left' valign='top' nowrap>Version</th>
						<td valign='top'><%=providers[i].getVersion()%></td>
					</tr>
					<%
					if(providers[i].getType().equals(Provider.Type.STORE)){
						try{
							name = mailSession.getStore(providers[i]).getDefaultFolder().getFullName();
						}
						catch(Exception ex){ name = "N/A"; }
					%>
						<tr>
							<th align='left' valign='top' nowrap>Default Folder</th>
							<td valign='top'><%=name%></td>
						</tr>
					<%
					}
					else if(providers[i].getType().equals(Provider.Type.TRANSPORT)){
						try{
							name = mailSession.getTransport(providers[i]).getURLName().toString();
						}
						catch(Exception ex){ name = "N/A"; }
					%>
						<tr>
							<th align='left' valign='top' nowrap>URL</th>
							<td valign='top'><%=name%></td>
						</tr>
					<%
					}
					%>
					
					</table>
				</td>
			<tr>
			<tr>
				<td colspan='2'><hr width='460' align='left'></td>
			</tr>
		<%
		}
		%>
		</table>
		<br><br>
		<a href='#pageTop'>top</a>
<%
	}
	catch(NamingException ex){
%>
		<P>Can't get context for the given resource reference name, <B><%=referenceName%></B><BR>
		Check the web.xml file or JNDI settings of your application server.
		</P>
		<P><B>detail :</B><BR>
<%
		ex.printStackTrace(new java.io.PrintWriter(out));
	}
	catch(Exception ex){
%>
		<P>There's an error!</P>
		<P><B>detail :</B><BR>
<%
		ex.printStackTrace(new java.io.PrintWriter(out));
	}
	finally{
		
	}
}
%>

<br><br>
</div>
</body>
</html>