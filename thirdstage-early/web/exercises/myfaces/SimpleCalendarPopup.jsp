<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Calendar Popup</title>
    </head>
    <body>

    <h1>Calendar Popup</h1>

    
    <h:form>
		 
		 Date : <t:inputDate value="#{DateBean.currentDate}" popupCalendar="true"/>
		 
		 
    </h:form>
    
    </body>
</html>

</f:view>
