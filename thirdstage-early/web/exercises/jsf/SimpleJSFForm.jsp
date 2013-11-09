<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
<html>
    <head>
<title>JSP Page</title>
<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
P {font-family:Verdana, 굴림; font-size:10pt; font-weight:normal; color:black}
TD {font-family:Verdana, 굴림; font-size:10pt; font-weight:normal; color:black}
TH {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:black}
INPUT {font-family:Tahoma, 굴림; font-size:10pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 굴림; font-size:9pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
    
    
    </head>
    <body>

 
<h1>Simple Page in JSF 1.1</h1>
<br>

    
	<h:form id="helloForm">
	<p>Hi, My Name is Duke. I'm thinking of a number between 
	<h:outputText value="#{UserNumberBean.minimum}"/> to
	<h:outputText value="#{UserNumberBean.maximum}"/>.
	Can you guess it?</p>
	<h:inputText id="userNo" value="#{UserNumberBean.userNumber}">
	    <f:validateLongRange maximum="#{UserNumberBean.maximum}"  minimum="#{UserNumberBean.minimum}"/>
	</h:inputText>
	<h:commandButton id="submit" action="success" value="Submit"/>
	<p>
	<h:message id="errors1" for="userNo"
	  style="color:red;font-style:oblique;text-decoration:overline"/>
	
	</h:form>

    </body>
</html>
</f:view>