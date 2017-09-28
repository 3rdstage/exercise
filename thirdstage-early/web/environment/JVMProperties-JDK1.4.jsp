<%@ page language="java" session="true" autoFlush="true" isThreadSafe="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.*,java.text.*,java.net.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Java VM Properties (JVM 1.4)</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
<META http-equiv="Pragma" content="No-cache"/>
<META http-equiv="Cache-Control" content="no-cache"/>
<META http-equiv="Cache-Control" content="no-store"/>
<META name="Author" content="Sang-Moon Oh"/>
<meta name="Version" content="1.6, 2005-03-27"/><!-- available character-sets -->
<meta name="Version" content="1.7, 2005-03-28"/><!-- add defualt locale/timezone/charset -->
<meta name="Version" content="1.8, 2005-03-29"/><!-- sort Enumerations using Collections.list() and Collections.sort() methods !! -->

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {font-family:Verdana, 돋움; font-size:9pt; background:#ffffff}
H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy; margin-top:4pt; margin-bottom:4pt; border:none}
H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy; margin-top:3pt; margin-bottom:3pt; border:none}
P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; margin-top:3pt; margin-bottom:3pt; border:none}
TABLE {background-color:#d6d6d6}
TABLE.search {background-color:#d6d6d6}
TABLE.list {background-color:#d6d6d6}
TABLE.detail {background-color:#d6d6d6}
TD {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black; background-color:white}
TD.title {font-size:12pt; font-weight:bold; color:navy}
TD.search {background-color:#f5f5f5} 
TD.item {background-color:#f5f5f5}
TH {font-family:Verdana, 돋움; font-size:9pt; font-weight:bold; color:black; background-color:#f5f5f5; text-align:center}
TH.blank {margin:0pt; padding:0pt; border:0pt; height:0pt}
INPUT {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
SMALL {font-family:Arial, 돋움; font-size:8pt; font-weight:normal; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>

</head>


<body>
<div align='left'><a name='pageTop'></a>
<%
Runtime rt = Runtime.getRuntime();
Properties prop = System.getProperties();
List names = Collections.list(prop.propertyNames());
String name = null;

DateFormat df = DateFormat.getDateTimeInstance();
if(df instanceof SimpleDateFormat){
	((SimpleDateFormat)df).applyPattern("yyyy-MM-dd HH:mm:ss z");
}
NumberFormat nf = NumberFormat.getIntegerInstance();
if(nf instanceof DecimalFormat){
	((DecimalFormat)nf).setDecimalSeparatorAlwaysShown(true);
}

InetAddress localhost = null;
try{
	localhost = InetAddress.getLocalHost();
}
catch(java.net.UnknownHostException ex){
	try{
		byte[] addr = {127, 0, 0, 1};
		localhost = InetAddress.getByAddress(addr);
	}
	catch(java.net.UnknownHostException ex2){
		
	}
}
%>

<table border='0' cellspacing='1' cellpadding='2'>
<tr>
    <td><h1>Java VM Properties</h1></td>
    <td>&nbsp;&nbsp;&nbsp;</td>
    <td><h5>(for JVM 1.4 or Higher)</h5></td>
</tr>
</table>

<br><br>

<table border='0' width='600' cellspacing='1' cellpadding='2'>
<tr>
	<th width='30%' class='blank'></th>
	<th class='blank'></th>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Number of Available Processors</td>
	<td valign='top'><%=rt.availableProcessors()%></td>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Max Memory</td>
	<td valign='top'><%=nf.format(rt.maxMemory())%> Byte</td>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Total Memory</td>
	<td valign='top'><%=nf.format(rt.totalMemory())%> Byte</td>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Free Memory</td>
	<td valign='top'><%=nf.format(rt.freeMemory())%> Byte</td>
</tr>

<tr><td colspan='2'>&nbsp;</td></tr>

<tr>
	<td class='item' valign='top' nowrap>IP Address</td>
	<td valign='top'><%=(localhost != null) ? localhost.getHostAddress() : "unknown"%></td>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Hostname</td>
	<td valign='top'><%=(localhost != null) ? localhost.getHostName() : "unknown"%></td>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Full Qualified Domain Name</td>
	<td valign='top'><%=(localhost != null) ? localhost.getCanonicalHostName() : "unknown"%></td>
</tr>

<tr><td colspan='2'>&nbsp;</td></tr>

<tr>
	<td class='item' valign='top' nowrap>System Time</td>
	<td valign='top'><%=df.format(new java.util.Date())%></td>
</tr>
<tr>
	<%
	java.util.Locale locale = java.util.Locale.getDefault(); 
	String localeCode = locale.getLanguage();
	localeCode += ((locale.getCountry().trim().length() != 0) ?  "_" + locale.getCountry() : "");
	localeCode += ((locale.getVariant().trim().length() != 0) ? "_" + locale.getVariant() : ""); 
	java.util.Currency currency = java.util.Currency.getInstance(locale);	
	String currencyCode = currency.getCurrencyCode();
	String currencySymbol = currency.getSymbol(); %>
	<td class='item' valign='top' nowrap>Default Locale and Currency</td>
	<td valign='top'>
		<%=localeCode + " - " + locale.getDisplayName() + (currencyCode.equals("") ? "" : ", " + currencyCode) + (currencySymbol.equals("") ? "" : " - " + currencySymbol) %>		
	</td>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Default TimeZone</td>
	<td valign='top'>
		<%=java.util.TimeZone.getDefault().getID() + " - " + java.util.TimeZone.getDefault().getDisplayName() %>		
	</td>
</tr>
<tr>
	<td class='item' valign='top' nowrap>Default Charset</td>
	<td valign='top'>
		<%=java.nio.charset.Charset.defaultCharset().displayName() %>		
	</td>
</tr>

<tr>
	<td class='item' valign="top" nowrap>Available Locales and Currencys</td>
	<td valign="top">
	(<i>Locale Code</i> - <i>Locale Name</i>, <i>Currency Code</i> - <i>Currency Symbol</i>)<br/><br/>
	<form name="form1" onSubmit="JavaScript:return false">
		<select name="locales" size="10">
		<%
		java.util.Locale [] locales = java.util.Locale.getAvailableLocales();
		locale = null;
		localeCode = null;
		currency = null;
		currencyCode = null;
		currencySymbol = null;
		
		for(int i = 0, n = locales.length; i < n; i++){ 
			locale = locales[i];
			localeCode = locale.getLanguage();
			localeCode += ((locale.getCountry().trim().length() != 0) ?  "_" + locale.getCountry() : "");
			localeCode += ((locale.getVariant().trim().length() != 0) ? "_" + locale.getVariant() : "");
			try{ 
				currency = java.util.Currency.getInstance(locales[i]);	
				currencyCode = currency.getCurrencyCode();
				currencySymbol = currency.getSymbol();
			}
			catch(IllegalArgumentException ex){ 
				currencyCode = ""; 
				currencySymbol = ""; 
			}
		%>
			<%="<option>" + localeCode + " - " + locale.getDisplayName() + (currencyCode.equals("") ? "" : ", " + currencyCode) + (currencySymbol.equals("") ? "" : " - " + currencySymbol) + "</option>"%>
		<% 
		} %>
			</select>
	</form>
	</td>
</tr>
<tr>
	<td class='item' valign="top" nowrap>Available TimeZones</td>
	<td valign="top">(<i>ID</i> - <i>Name</i>)<br/><br/>
	<form name="form2" onSubmit="JavaScript:return false">
		<select name="timezones" size="10" readonly>
		<%
		String[] ids = java.util.TimeZone.getAvailableIDs();
		java.util.Arrays.sort(ids);
		
		for(int i = 0, n = ids.length; i < n; i++){ %>
			<%="<option>" + ids[i] + " - " + java.util.TimeZone.getTimeZone(ids[i]).getDisplayName() +  "</option>"%>
		<% 
		} %>
			</select>
	</form>
	</td>
</tr>
<tr>
	<td class='item' valign="top" nowrap>Available Characterset</td>
	<td valign="top">(<i>Display Name</i> - <i>Canonical Name</i>)<br><br>
	<form name="form3" onSubmit="JavaScript:return false">
		<select name="charset" size="10" readonly>
		<%
		java.util.Map charsets = java.nio.charset.Charset.availableCharsets();
		java.nio.charset.Charset charset = null;
		for(Iterator keys = charsets.keySet().iterator(); keys.hasNext(); ){
			charset = (java.nio.charset.Charset)(charsets.get(keys.next())); %>
			<%="<option>" + charset.displayName() + " - " + charset.name() + "</option>"%>
		<% 
		} %>
			</select>
	</form>
	</td>
</tr>

</table>
<br>
<br>

<table border='0' width='100%' cellspacing='1' cellpadding='2'>
<tr>
	<th>Name</th>
	<th>Value</th>
</tr>
<%
	Collections.sort(names);
	for(int i = 0, n = names.size(); i < n; i++){
	
		name = (String)(names.get(i));
%>
		<tr>
			<td class='item' valign='top'><%=name%></td>
			<td valign='top'><%=prop.getProperty(name)%></td>
		</tr>
<%
	}
%>

</table>
<br>
<a href='#pageTop'>top</a>
<br><br>

</div>
</body>
</html>