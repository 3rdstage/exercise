<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<title>JSP Scoped Variables (JSP 2.0)</title>
	<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
	<META http-equiv="Pragma" content="No-cache">
	<META http-equiv="Cache-Control" content="no-cache">
	<META http-equiv="Cache-Control" content="no-store">
	<META name="Author" content="Sang-Moon Oh"> 

	<SCRIPT type="text/javascript" language="JavaScript">
		// page scope script
		function initPage(){
	
		<c:if test='${! empty param.scope}'>
			var selectObj = document.forms['scopeForm'].elements['scope']
			for(var i = 0, n = selectObj.length; i < n; i++){
			if(selectObj.options[i].value == '${param.scope}'){
		selectObj.options[i].selected = true
		break
		}
		}
		</c:if>
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
		H4 {font-family:Verdana, ±¼¸²; font-size:11pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
		H5 {font-family:Verdana, ±¼¸²; font-size:10pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
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

			<table border='0' cellspacing='1' cellpadding='1'>
				<tr>
					<td><H1>Scoped Variables</H1></td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td><h5>(for JSP 2.0 or Higher)</h5></td>
				</tr>
			</table>

			<BR>

			<FORM name='scopeForm' action='./ScopedVariables-JSP2.0.jsp' target='_self' 
				method='POST' onSubmit='JavaScript:return checkToSubmit()'>
				<TABLE border='0' width='600' cellspacing='1' cellpadding='1'>
					<TR>
						<TD align='left' valign='top' nowrap style='font-weight:bold' width='20%'>Scope</TD>
						<TD align='left' valign='top'>:
						<select name='scope'>
							<option value='page'>page</option>
							<option value='request'>request</option>
							<option value='session'>session</option>
							<option value='application'>application</option>
						</select>
						&nbsp;&nbsp;&nbsp;
						<INPUT name='submit' type='submit' value='execute'>
					</TR>
				</TABLE>
			</FORM>
			<BR><br>

			<c:choose>
			<c:when test='${param.scope == "page"}'>
			<c:set var='scope' scope='page' value='${pageScope}'/>
			</c:when>
			<c:when test='${param.scope == "request"}'>
			<c:set var='scope' scope='page' value='${requestScope}'/>
			</c:when>
			<c:when test='${param.scope == "session"}'>
			<c:set var='scope' scope='page' value='${sessionScope}'/>
			</c:when>
			<c:when test='${param.scope == "application"}'>
			<c:set var='scope' scope='page' value='${applicationScope}'/>
			</c:when>
			<c:otherwise>
			<c:set var='scope' scope='page' value='${null}'/>
			</c:otherwise>
			</c:choose>

			<c:if test='${pageScope.scope != null}'>
			<h2><c:out value='${param.scope}'/> scope attributes</h2>
			<table border='1' width='600' cellspacing='0' cellpadding='1'>
				<tr>
					<th width='50%'>Key</th>
					<th>Value</th>
				</tr>
				<c:forEach items='${scope}' var='attr'>
				<tr>
					<td><c:out value='${attr.key}'/></td>
					<td style=''><c:out value='${attr.value}'/></td>
				</tr>
				</c:forEach>
			</table>
			</c:if>


	

			<br><br>
			<a href='#pageTop'>top</a>
			<br><br>
    

		</div>
	</body>
</html>
