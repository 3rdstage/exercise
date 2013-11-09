<%@ page language="java" session="true" autoFlush="true" isThreadSafe="true" %>
<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.lang.*" %>
<%@ page import="thirdstage.platform.web.*" %>
<%@ page import="org.apache.log4j.PropertyConfigurator" %>



<%!
private org.apache.log4j.Logger logger = null;


public void jspInit(){
	//needless or error to call super's jspInit, 2008-02-18, 3rdstage
	//super.jspInit();

	//set default locale
	String localeCode = this.getServletConfig().getInitParameter("defaultLocale");
	String lang = null;
	String country = null;
	java.util.Locale locale = java.util.Locale.getDefault(); //default locale of this JVM according to system config or startup option
	if(localeCode != null){
		try{
			lang = localeCode.substring(0, 2);
			country = localeCode.substring(3, 5);
			java.util.Locale.setDefault(new java.util.Locale(lang, country));
		}
		catch(Exception ex){
			java.util.Locale.setDefault(locale);
			this.getServletConfig().getServletContext().log("[Error] The locale specified in web.xml can't be set. Locale from system conifg or startup option continue to be applied");
			System.out.println("[Error] The locale specified in web.xml can't be set. Locale from system conifg or startup option continue to be applied");
		}
	}
	else{
		this.getServletConfig().getServletContext().log("[Warn] The default locale for this JVM is not specified in web.xml. Locale from system conifg or startup option continue to be applied");
		System.out.println("Warn] The default locale for this JVM is not specified in web.xml. Locale from system conifg or startup option continue to be applied");
	}
	
	//set default timezone
	String timeZoneId = this.getServletConfig().getInitParameter("defaultTimeZone");
	java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
	if(localeCode != null){
		try{
			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone(timeZoneId));
		}
		catch(Exception ex){
			java.util.TimeZone.setDefault(timeZone);
			this.getServletConfig().getServletContext().log("[Error] The timezone specified in web.xml can't be set. Timezone from system conifg or startup option continue to be applied");
			System.out.println("[Error] The timezone specified in web.xml can't be set. Timezone from system conifg or startup option continue to be applied");
		}
	}
	else{
		this.getServletConfig().getServletContext().log("[Warn] The default timezone for this JVM is not specified in web.xml. Timezone from system conifg or startup option continue to be applied");
		System.out.println("Warn] The default timezone for this JVM is not specified in web.xml. Timezone from system conifg or startup option continue to be applied");
	}
	
	//TODO change the default characterset of the current JVM
	
	//Initialize Log4j
	String path = null;
	String relativePath = this.getServletConfig().getInitParameter("log4jConfigProps");
	java.io.File configFile = null;
	if(relativePath != null) path = this.getServletConfig().getServletContext().getRealPath(relativePath);
	else{
		this.getServletConfig().getServletContext().log("[Warn] Configuration for log4j is not specified in web.xml.");
		System.out.println("[Warn] Configuration for log4j is not specified in web.xml.");
	}
	if(path != null){
		PropertyConfigurator.configure(path);
		this.getServletConfig().getServletContext().log("[Info] Log4j type logger is initialized properly.");
		System.out.println("[Info] Log4j type logger is initialized properly.");
	} else{
		this.getServletConfig().getServletContext().log("[Warn] Can't find property file to initialize Log4j");
		System.err.println("[Warn] Can't find property file to initialize Log4j");
	}
	
	logger = org.apache.log4j.Logger.getLogger(this.getServletConfig().getServletContext().getServletContextName());
	
	//Initialize Hibernate SessionFactorys according to web.xml
	/*
	 * 3rdstage, 20006-08-08, Hiberate SessionFactory can be bound to JNDI 
	 * in read-only mode for Tomcat 5.5.x (!), so custom code below is not necessary
	path = null;
	relativePath = this.getServletConfig().getInitParameter("hibernateConfig");
	configFile = null;
	if(relativePath != null){
		path = this.getServletConfig().getServletContext().getRealPath(relativePath);
		if(path != null) configFile = new java.io.File(path);
		if(configFile != null && configFile.exists()){
			try{
				(new org.hibernate.cfg.Configuration()).configure(configFile).buildSessionFactory();
				logger.info("Hibernate SesssionFactory for " + relativePath + " is initialized properly.");
			}
			catch(org.hibernate.HibernateException ex){
				logger.error("Hibernate SesssionFactory for " + relativePath + " can't be initialized properly.", ex);
			}
		}
		else{
			logger.error("Hibernate SesssionFactory for " + relativePath + " can't be initialized properly.");
		}
	}
	else{
		logger.warn("Configuration for Hiberante is not specified in web.xml properly or configruation is not setup as specified.");
	}
	*/

	
	//Initialize ServiceLocatorFactory
	try{
		ServiceLocatorFactory.getInstance().putServiceLocator("AccessControl", null);
		logger.info("ServiceLocatorFactory is initialized properly.");
	}
	catch(Exception ex){
		logger.error("ServiceLocatorFactory is not initialized properly.", ex);
	}
}
	
public void jspDestroy(){

	//needless or error to call super's jspDestroy, 2008-02-18, 3rdstage
	//super.jspDestroy();
}

%>
<html>


<head>
<title>Guess What?</title>
<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR"/>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT">
<META http-equiv="Pragma" content="No-cache">
<META http-equiv="Cache-Control" content="no-cache">
<META http-equiv="Cache-Control" content="no-store">
<META name="Author" content="Sang-Moon Oh"> 

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {font-family:Verdana, 돋움; font-size:9pt; background:#ffffff}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy}
H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy}
P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
TABLE {background-color:#d6d6d6}
TABLE.search {background-color:#d6d6d6}
TABLE.list {background-color:#d6d6d6}
TABLE.detail {background-color:#d6d6d6}
TD {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; background-color:white}
TD.title {font-size:12pt; font-weight:bold; color:navy}
TD.search {background-color:#f5f5f5} 
TD.item {background-color:#f5f5f5}
TH {font-family:Verdana, 돋움; font-size:9pt; font-weight:bold; color:black; background-color:#f5f5f5}
TH.blank {margin:0pt; padding:0pt; border:0pt; height:0pt}
INPUT {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 돋움; font-size:8pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>
<head>


<body onLoad='JavaScript:initPage()'>
<div align='left'><a name='pageTop'/>
    
<h3>This page is not for user interface</h3>   

		
<br/><br/>
<a href='#pageTop'>top</a>
<br/><br/>
</div>
</body>
</html>
