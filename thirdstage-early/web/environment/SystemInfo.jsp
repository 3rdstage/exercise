<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, javax.management.remote.*" %>
<%!
	private static final String JMX_CONTROL_ACTION_START = new String("start");
	private static final String JMX_CONTROL_ACTION_STOP = new String("stop");
	private static final int RMI_PORT_DEFAULT = 9999;
	
	private boolean jmxConnectorServerStarted = false;
	private JMXConnectorServer jmxConnectorServer = null;
	private java.rmi.registry.Registry rmiRegistry = null;


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Information on System</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
<META http-equiv="Pragma" content="No-cache"/>
<META http-equiv="Cache-Control" content="no-cache"/>
<META http-equiv="Cache-Control" content="no-store"/>
<META name="Author" content="Sangmoon Oh"/>
<META name="Version" content="2.0, 2011-01-13, Add functionality of exporting PlatformMBeanServer"/>
<META name="Version" content="1.5, 2010-10-25, Consolidated"/>
</head>
<body><a name='top'></a>

<ul>
	<li><a href='#system-props'>System Properties</a>
	<li><a href='#env-var'>Environment Variables</a>
	<li><a href='#locale'>Available Locales and Currencys</a>
	<li><a href='#charset'>Available Charactersets</a>
	<li><a href='#timezone'>Available TimeZones</a>
</ul>

<%
boolean showsJmxControl = request.getParameter("showsJmxControl") != null && ("true".equals(request.getParameter("showsJmxControl").trim()));

if(showsJmxControl){ 
	String jmxControlAction = request.getParameter("jmxControlAction") != null ? request.getParameter("jmxControlAction").trim() : "none";
	int rmiPort = request.getParameter("rmiPort") != null ? Integer.valueOf(request.getParameter("rmiPort").trim()) : RMI_PORT_DEFAULT;
	String jmxServiceUrl = "service:jmx:rmi:///jndi/rmi://" 
			+ java.net.InetAddress.getLocalHost().getHostAddress() + ":" + rmiPort + "/server";

	if(!this.jmxConnectorServerStarted && JMX_CONTROL_ACTION_START.equals(jmxControlAction)){
		
		try{
			javax.management.MBeanServer mbs = java.lang.management.ManagementFactory.getPlatformMBeanServer();
			this.rmiRegistry = java.rmi.registry.LocateRegistry.createRegistry(rmiPort);
			this.jmxConnectorServer = JMXConnectorServerFactory.newJMXConnectorServer(new JMXServiceURL(jmxServiceUrl), null, mbs);
			this.jmxConnectorServer.start();
			
			this.jmxConnectorServerStarted = true;
		}
		catch(Exception ex){ %>
		
			<div style='margin-left:40px'>
			<table width='1000' border='0' cellpadding='2' cellspacing='0'>
			<tr>
				<td colspan='2' style='color:darkred'>Fail to start JMXConnectorServer</td>
			</tr>
			<tr>
				<td width='20'>&nbsp;</td>
				<td>
					<% 
					ex.printStackTrace(new java.io.PrintWriter(out)); %>
				</td>
			</tr>
			<tr>
				<td colspan='2'>&nbsp;</td>
			</tr>
			</table>
			</div>	
		<%
		}
	}
	else if(this.jmxConnectorServerStarted && JMX_CONTROL_ACTION_STOP.equals(jmxControlAction)){
		try{
			if(this.jmxConnectorServer != null && this.jmxConnectorServer.isActive()){
				this.jmxConnectorServer.stop();
			}
			
			if(this.rmiRegistry == null){
				rmiRegistry = java.rmi.registry.LocateRegistry.getRegistry(rmiPort);
			}

			java.rmi.server.UnicastRemoteObject.unexportObject(this.rmiRegistry, true);
			this.jmxConnectorServerStarted = false;
		}
		catch(Exception ex){ %>
		
			<div style='margin-left:40px'>
			<table width='1000' border='0' cellpadding='2' cellspacing='0'>
			<tr>
				<td colspan='2' style='color:darkred'>Fail to stop JMXConnectorServer</td>
			</tr>
				<td width='20'>&nbsp;</td>
				<td>
					<%
					ex.printStackTrace(new java.io.PrintWriter(out)); %>
				</td>
			</table>
			</div>	
		<%
		}
	}
	
%>
	<div id="platform-mbeanserver" style='margin-left:40px'>
	<form name='jmxControl'>
		<table border='0' cellpaddig='2' cellspacing='0'>
		<tr>
			<th colspan='3' style='font-size:larger' align='left'>Exporting Platform MBeanServer</th>
		</tr>
		<%
		if(jmxConnectorServerStarted){ %>
			<tr>
				<td width='20px'></td>
				<td style='white-space:nowrap'>JMXConnectorServer Status</td>
				<td>: <b>running</b></td>
			</tr>
			<tr>
				<td></td>
				<td>JMX Service URL</td>
				<td>: <%=jmxServiceUrl%></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="<%=JMX_CONTROL_ACTION_STOP%>"></input></td>
				<td>
					<input type="hidden" name="showsJmxControl" value="true"></input>
					<input type="hidden" name="jmxControlAction" value="<%=JMX_CONTROL_ACTION_STOP%>"></input>
					<input type='hidden' name='rmiPort' value='<%=rmiPort%>'></input>
				</td>
			</tr>
		<%
		} else { %>
			<tr>
				<td width='20px'></td>
				<td style='white-space:nowrap'>JMXConnectorServer Status</td>
				<td>: <b>not running</b></td>
			</tr>
			<tr>
				<td></td>
				<td>RMI Port</td>
				<td>: <input type='text' size='6' maxlength='6' value='9999'></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="<%=JMX_CONTROL_ACTION_START%>"></input></td>
				<td>
					<input type="hidden" name="showsJmxControl" value="true"></input>
					<input type="hidden" name="jmxControlAction" value="<%=JMX_CONTROL_ACTION_START%>"></input>
				</td>
			</tr>
		<%
		}	%>
		</table>
	</form>
	</div>
<%
} %>



<br/><br/>	

<%
Runtime rt = Runtime.getRuntime();
java.text.DateFormat df = java.text.DateFormat.getDateTimeInstance();
if(df instanceof java.text.SimpleDateFormat){ ((java.text.SimpleDateFormat)df).applyPattern("yyyy-MM-dd HH:mm:ss z"); }
java.text.NumberFormat nf = java.text.NumberFormat.getIntegerInstance();
if(nf instanceof java.text.DecimalFormat){ ((java.text.DecimalFormat)nf).setDecimalSeparatorAlwaysShown(true); }

java.net.InetAddress localhost = null;
try{
	localhost = java.net.InetAddress.getLocalHost();
}
catch(java.net.UnknownHostException ex){
	try{
		byte[] addr = {127, 0, 0, 1};
		localhost = java.net.InetAddress.getByAddress(addr);
	}
	catch(java.net.UnknownHostException ex2){ }
} %>

<table width='1000' border='1' cellpadding='1' cellspacing='0'>
<tr>
	<th>Property</th>
	<th>Value</th>
</tr>
<tr>
	<td>Number of Available Processors</td>
	<td valign='top'><%=rt.availableProcessors()%></td>
</tr>
<tr>
	<td>Max Memory</td>
	<td valign='top'><%=nf.format(rt.maxMemory())%> Byte</td>
</tr>
<tr>
	<td>Total Memory</td>
	<td valign='top'><%=nf.format(rt.totalMemory())%> Byte</td>
</tr>
<tr>
	<td>Free Memory</td>
	<td valign='top'><%=nf.format(rt.freeMemory())%> Byte</td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td>IP Address</td>
	<td valign='top'><%=(localhost != null) ? localhost.getHostAddress() : "unknown"%></td>
</tr>
<tr>
	<td>Hostname</td>
	<td valign='top'><%=(localhost != null) ? localhost.getHostName() : "unknown"%></td>
</tr>
<tr>
	<td>Full Qualified Domain Name</td>
	<td valign='top'><%=(localhost != null) ? localhost.getCanonicalHostName() : "unknown"%></td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
	<td>Default Locale</td>
	<td valign='top'><%= java.util.Locale.getDefault().toString() %></td>
</tr>
<tr>
	<td>Default Currency</td>
	<td valign='top'><%= java.util.Currency.getInstance(java.util.Locale.getDefault()).getCurrencyCode() %></td>
</tr>
<tr>
	<td>Default Characterset</td>
	<td valign='top'><%= java.nio.charset.Charset.defaultCharset().displayName() %></td>
</tr>
<tr>
	<td>Default TimeZone</td>
	<td valign='top'><%= java.util.TimeZone.getDefault().getID() + " - " + java.util.TimeZone.getDefault().getDisplayName() %></td>
</tr>
</table>
<hr/>
<a href='#top'>top</a>

<br/><br/>
<h3><a name='system-props'>System Properties</a></h3>
<table width='1000' border='1' cellpadding='1' cellspacing='0'>
<tr><th>Property</th><th>Value</th></tr>

<%
	Properties systemProps = System.getProperties();
	List systemKeys = new ArrayList(systemProps.keySet());
	Collections.sort(systemKeys);

	for(Object key : systemKeys){ %>
		<tr>
			<td><%=(String)key %></td>
			<td><%=systemProps.getProperty((String)key) %></td>
		</tr>
<%
	}%>

</table>
<hr/>
<a href='#top'>top</a>


<br/><br/>

<h3><a name='env-var'>Environment Variables</a></h3>
<table width='1000' border='1' cellpadding='1' cellspacing='0'>
<tr><th>Variable</th><th>Value</th></tr>

<%
	Map<String, String> env = System.getenv();
	List<String> envKeys = new ArrayList<String>(env.keySet());
	Collections.sort(envKeys);

	for(String key : envKeys){ %>
		<tr>
			<td><%= key %></td>
			<td><%= env.get(key) %></td>
		</tr>
<%
	}%>

</table>
<hr/>
<a href='#top'>top</a>


<br/><br/>
<h3><a name='locale'>Available Locales and Currencys</a></h3>
<table width='1000' border='1' cellpadding='1' cellspacing='0'>
<tr>
	<th>Locale Code</th>
	<th>Locale Display Name</th>
	<th>Currency Code</th>
	<th>Currency Symbol</th>
</tr>

<%
	java.util.Locale [] locales = java.util.Locale.getAvailableLocales();
	java.util.Locale locale = null;
	java.util.Currency currency = null;
	String currencyCode = null;
	String currencySymbol = null;
		
	for(int i = 0, n = locales.length; i < n; i++){ 
		locale = locales[i];
		try{ 
			currency = java.util.Currency.getInstance(locales[i]);	
			currencyCode = currency.getCurrencyCode();
			currencySymbol = currency.getSymbol();
		}
		catch(IllegalArgumentException ex){ 
			currencyCode = ""; 
			currencySymbol = ""; 
		} %>
		
		<tr>
			<td><%= locale.toString() %></td>
			<td><%= locale.getDisplayName() %></td>
			<td><%= "".equals(currencyCode) ? "&nbsp;" : currencyCode %></td>
			<td><%= "".equals(currencyCode) ? "&nbsp;" : currencyCode %></td>
		</tr>
	
	<%
	} %>

</table>
<hr/>
<a href='#top'>top</a>

<br/><br/>
<h3><a name='charset'>Available Charactersets</a></h3>
<table width='1000' border='1' cellpadding='1' cellspacing='0'>
<tr>
	<th>Display Name</th>
	<th>Canonical Name</th>
	<th>Aliases</th>
</tr>

<%
	java.util.Map charsets = java.nio.charset.Charset.availableCharsets();
	java.nio.charset.Charset charset = null;
	for(Iterator charsetKeys = charsets.keySet().iterator(); charsetKeys.hasNext(); ){ 
		charset = (java.nio.charset.Charset)(charsets.get(charsetKeys.next())); %>
	
	<tr>
		<td><%= charset.name() %></td>
		<td><%= charset.displayName() %></td>
		<td><%= charset.aliases() %></td>			
	</tr>

	<%
	} %>

</table>
<hr/>
<a href='#top'>top</a>
	
<br/><br/>
<h3><a name='timezone'>Available TimeZones</a></h3>
<table width='1000' border='1' cellpadding='1' cellspacing='0'>
<tr>
	<th>ID</th>
	<th>Name</th>
</tr>

<%
	String[] timeZoneIds = java.util.TimeZone.getAvailableIDs();
	java.util.Arrays.sort(timeZoneIds);

	for(int i = 0, n = timeZoneIds.length; i < n; i++){ %>
	
		<tr>
			<td><%= timeZoneIds[i] %></td>
			<td><%= java.util.TimeZone.getTimeZone(timeZoneIds[i]).getDisplayName() %></td>
		</tr>
	
	<%
	} %>
</table>
<hr/>
<a href='#top'>top</a>



</body>
</html>