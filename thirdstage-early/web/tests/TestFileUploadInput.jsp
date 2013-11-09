<%@page language="java" session="true" autoFlush="true" isThreadSafe="true"%>
<%@page contentType="text/html;charset=euc-kr"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR"/>
		<meta http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
		<meta http-equiv="Pragma" content="No-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-store"/>
		<meta name="Author" content="Sang-Moon Oh"/> 
		<title>File Upload</title>
		
		<script type="text/javascript" language="JavaScript">
			// page scope script
			function initPage(){
			var theForm = document.forms['uploadForm']
	
			theForm.elements['name'].focus()
			}

			function checkToSubmit(){
	
			if(!confirm('Do you really want to upload?')){
			return false
			document.forms['uploadForm'].elements['name'].focus()
			}
			else return true
			}
		</script>

		<style type="text/css">
			/* page scope style */
			BODY {background:#FFFFFF}
			H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
			H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
			H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
			H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy}
			H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy}
			P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
			TABLE {background-color:white}
			TABLE.search {background-color:#d6d6d6}
			TABLE.list {background-color:#d6d6d6}
			TABLE.detail {background-color:#d6d6d6}
			TD {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; background-color:white}
			TD.search {background-color:#f5f5f5} 
			TD.item {background-color:#f5f5f5}
			TH {font-family:Verdana, 돋움; font-size:9pt; font-weight:bold; color:black; background-color:#f5f5f5}
			INPUT {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
			SMALL {font-family:Arial, 돋움; font-size:8pt; font-weight:normal; color:black}
			HR.normal {text-align:left; width:600px}
		</style>
	</head>

	
	<body onLoad='JavaScript:initPage()'>
		<div align='left'><a name='pageTop'/></a>
 
			<H1>About You (FileUpload Test)</H1>

			<BR>

			<FORM name='uploadForm' action='<%=request.getContextPath()%>/TestFileUploadServlet' 
				enctype='multipart/form-data'
				method='post' target='_self' onSubmit='JavaScript:return checkToSubmit()'>
				<TABLE border='0' width='600' cellspacing='1' cellpadding='2'>
					<TR>
						<TD width='80'>&nbsp;</TD>
						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD style='font-weight:bold'>Name</TD>
						<TD><INPUT name='name' type='text' size='20' maxlength='12'></TD>
					</TR>
					<TR>
						<TD style='font-weight:bold'>Country</TD>
						<TD>
							<SELECT name='country'>
								<OPTION value='KR'>Korea, Republic of</OPTION>
								<OPTION value='US'>U.S.A</OPTION>
								<OPTION value='JP'>Japan</OPTION>
								<OPTION value='FR'>France</OPTION>
								<OPTION value='CN'>Chaina</OPTION>
							</SELECT>
						</TD>
					</TR>
					<TR>
						<TD style='font-weight:bold'>Photo</TD>
						<TD><INPUT name='photo' type='file' size='50'></TD>
					</TR>
					<TR>
						<TD style='font-weight:bold'>Resume</TD>
						<TD><INPUT name='resume' type='file' size='50'></TD>
					</TR>
					<TR>
						<TD>&nbsp;</TD>
						<TD>
							<SMALL style='font-weight:bold'>
								(check the files of which name include korean character)
							</SMALL>
							<BR><BR>
						</TD>
					</TR>
					<TR>
						<TD>&nbsp;</TD>
						<TD><INPUT name='submit' type='submit' value='Upload'></TD>
					</TR>
				</TABLE>
			</FORM>
   
    
    
		
			<br/><br/>
			<a href='#pageTop'>top</a>
			<br/><br/>
		</div>
	</body>
</html>

