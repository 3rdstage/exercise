<%@page language="java"%>
<%@page contentType="text/html;charset=euc-kr"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="true"%>
<%@page import="java.util.*, java.io.*,javax.naming.*, 
                com.oreilly.servlet.MultipartRequest,
                com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>

                
<!--
The servlet description mapped to url pattern for this page should contain init-parameter
to arrange directory where uploaded file would be stored in the name of 'uploadDir'
-->
<%!
private String uploadDir = null;
private int maxPostSize = -1;

public void jspInit(){

	this.uploadDir = this.getServletConfig().getInitParameter("uploadDir");
	this.getServletConfig().getServletContext().log("[Info] upload directory : " + this.uploadDir);
	if(this.uploadDir != null) this.uploadDir = this.getServletConfig().getServletContext().getRealPath(this.uploadDir);
	if(this.uploadDir == null){
		this.getServletConfig().getServletContext().log("[Error] initialization parameter for upload directory is not defined in web.xml");
	}
	else{
		this.getServletConfig().getServletContext().log("[Info] upload directory : " + this.uploadDir);
	}

	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		this.maxPostSize = ((Integer)(envCtx.lookup("param/MaxPostSize"))).intValue();

		this.getServletConfig().getServletContext().log("[Info] max size of POST contents (byte) : " + maxPostSize);		
	}
	catch(Exception ex){
		this.getServletConfig().getServletContext().log("[Error] ", ex);
	}	
}

%>

<%
response.setContentType("text/html");
//response.setHeader("Expires", "Thu, 10 Nov 1999 24:00:00 GMT");
//response.setHeader("Pragma", "No-cache");
//response.setHeader("Cache-Control", "no-cache");
//response.setHeader("Cache-Control", "no-store");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>

<HEAD>
<META name="Author" content="Sang-Moon Oh">
<META name="Keywords" content="">
<META name="Description" content="">

<TITLE>File Upload</TITLE>

<!-- to add external java script file
<SCRIPT type="text/javascript" language="JavaScript" src=""></SCRIPT>
-->
<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
}

function checkToSubmit(){
	return true
}
</SCRIPT>

<!-- to add external style sheet file 
<LINK rel=StyleSheet href="" type="text/css">
-->
<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
P {font-family:Tahoma, 굴림; font-size:10pt; font-weight:normal; color:black}
TD {font-family:Tahoma, 굴림; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Tahoma, 굴림; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Tahoma, 굴림; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 굴림; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
</HEAD>


<BODY onLoad='JavaScript:initPage()'>
<DIV align='left'><A name='pageTop'></A>

<%
if(uploadDir == null || maxPostSize == -1){ %>
	<P>
	Can't handle the request<BR>
	The enviroment for this page is not properly settled
	</P>
<%
}
else{
%>

<P><SPAN style="font-weight:bold">Upload Directory : </SPAN><%=uploadDir%></P>
<P><SPAN style="font-weight:bold">Max Size of Contents : </SPAN><%=maxPostSize%> Byte</P>
<BR>
	<%

	try{
		MultipartRequest multi = new MultipartRequest(request, uploadDir, maxPostSize, new DefaultFileRenamePolicy());
		String name = multi.getParameter("name");
		String country = multi.getParameter("country");  
		
		File photoFile = multi.getFile("photo");
		File resumeFile = multi.getFile("resume");
		
	%>
	
	<P>Your upload file request is executed successfully as follows.</P>
	<TABLE border='0' width='200' cellspacing='1' cellpadding='1'>
	<TR>
		<TH align='left'>Name</TH>
		<TD> : <%=name%></TD>
	</TR>
	<TR>
		<TH align='left'>Country</TH>
		<TD> : <%=country%></TD>
	</TR>
	</TABLE>
	
	<TABLE border='1' width='600' cellspacing='1' cellpadding='1'>
	<TR>
		<TH>&nbsp;</TH>
		<TH>Photo File</TH>
		<TH>Resume File</TH>
	</TR>
	<TR>
		<TH align='left' valign='top'>Content Type</TH>
		<TD valign='top'><%=multi.getContentType("photo")%></TD>
		<TD valign='top'><%=multi.getContentType("resume")%></TD>
	</TR>
	<TR>
		<TH align='left' valign='top'>Original File Name</TH>
		<TD valign='top'><%=multi.getOriginalFileName("photo")%></TD>
		<TD valign='top'><%=multi.getOriginalFileName("resume")%></TD>
	</TR>
	<TR>
		<TH align='left' valign='top'>Saved File Name</TH>
		<TD valign='top'><%=multi.getFilesystemName("photo")%></TD>
		<TD valign='top'><%=multi.getFilesystemName("resume")%></TD>
	</TR>
	<TR>
		<TH align='left' valign='top'>Saved File's Canonical Path</TH>
		<TD valign='top'><%=photoFile.getCanonicalPath()%></TD>
		<TD valign='top'><%=resumeFile.getCanonicalPath()%></TD>
	</TR>
	</TABLE>
	
	
	
<%
	}
	catch(Exception ex){
		this.getServletConfig().getServletContext().log("[Error] ", ex);
%>
	<P>Can't handle the request. the detail is : <BR></P>
	<P>
		<%
		ex.printStackTrace(new java.io.PrintWriter(out));
		%>
	</P>
<%
	}
}
%>


</DIV>
</BODY>
</HTML>
