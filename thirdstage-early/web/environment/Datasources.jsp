<%@ page language="java" import="java.sql.*,javax.sql.*,javax.naming.*"%>
<%@ page import="java.util.*" %>

<%-- This page needs JDK 1.6 or higher --%>
<%
response.setContentType("text/html");
String contextName = request.getParameter("contextName");
String name = request.getParameter("name");
boolean showsUrl = request.getParameter("showsUrl") != null && "true".equals(request.getParameter("showsUrl").trim());
if(contextName == null || "".equals(contextName.trim())) contextName = "jdbc";
if(name == null ||"".equals(name.trim())) name = ""; 
%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Datasources in JNDI Namespace</title>
<META http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
<META http-equiv="Pragma" content="No-cache"/>
<META http-equiv="Cache-Control" content="no-cache"/>
<META http-equiv="Cache-Control" content="no-store"/>
<META name="Author" content="Sangmoon Oh"/>
<META name="Version" content="1.4, 2010-10-25, Sort the queried data-sources."/>
<META name="Version" content="1.3, 2010-06-15, Make it enable to list names directly under the specified context."/>

<SCRIPT type="text/javascript" language="JavaScript">
// page scope script
function initPage(){
	
	document.forms['nameForm'].elements['contextName'].focus()
}

function checkToSubmit(){
	return true
}
</SCRIPT>

<STYLE type="text/css">
/* page scope style */
BODY {background:#FFFFFF; font-family:Verdana, ????; font-size:10pt; color:black}
H1 {font-size:14pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H2 {font-size:13pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H3 {font-size:12pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H4 {font-size:11pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
H5 {font-size:10pt; font-weight:bold; color:navy; margin-top:2pt; margin-bottom:2pt; border:none}
P {color:black}
TABLE {font-size:10pt; margin-left:5pt}
TD {color:black}
TH {font-weight:bold; color:black}
INPUT {color:black}
SMALL {font-size:9pt; color:black}
HR.normal {text-align:left; width:600px}
</STYLE>

</head>
<body onLoad='JavaScript:initPage()'>
<div align='left'><a name='pageTop'></a>

<H1>Datasources in JNDI Namespace</H1>
<BR>


<FORM name='nameForm' action='./Datasources.jsp' target='_self' 
           method='POST' onSubmit='JavaScript:return checkToSubmit()'>
<TABLE border='0' width='600' cellspacing='1' cellpadding='1'>
	<TD valign='top' nowrap style='font-weight:bold'>The Name of Context<br/> for JDBC Datasources</TD>
	<TD valign='top' nowrap> :
		<INPUT name='contextName' type='text' size='30' value='<%=contextName%>'>
		<INPUT name='submit' type='submit' value='execute'>
	</TD>
</TR><TR>
	<TD>&nbsp;</TD>
	<TD>
		 <small>(This name is usually 'java:comp/env/jdbc' or just 'jdbc'. The exact value depends on J2EE appl. server and it's config.)</small>
	</TD>
</TR>
</TABLE>
</FORM>

<ul>
<%
Context initCtx = null;
Context envCtx = null;

try{
	initCtx = new InitialContext();
	envCtx = (Context)initCtx.lookup(contextName);
	NamingEnumeration<NameClassPair> pairs = envCtx.list("");
	List<NameClassPair> pairList = new ArrayList<NameClassPair>();

	while(pairs.hasMore()) pairList.add(pairs.next());
	
	Collections.sort(pairList, 
		new Comparator<NameClassPair>(){
			public int compare(NameClassPair nc1, NameClassPair nc2){
				if(nc1 == null){
					if(nc2 == null) return 0;
					else return -1;
				}else if(nc2 == null){
					return 1;
				}else{ //when both are not null.
					String name1 = nc1.getName();
					String name2 = nc2.getName();
					
					if(name1 == null){
						if(name2 == null) return 0;
						else return -1;
					}else if(name2 == null){
						return 1;
					}else{
						return name1.compareTo(name2);
					}
				}
			}
		});
	
	String searchPart = "";
	for(NameClassPair pair : pairList){
		
		searchPart = "contextName=" + contextName + "&name=" + pair.getName();
		if(showsUrl) searchPart += "&showsUrl=true"; %>
		<li><%=pair.getClassName()%> : <a href='./Datasources.jsp?<%= searchPart %>'><%=(contextName + "/" + pair.getName())%></a></li>
	<%
	}
	
}catch(Exception ex){} %>
</ul>

<%
if(!"".equals(name)){
	Connection conn = null;
	String sql = null;
	Statement stmt = null;
	ResultSet rs = null;
	DatabaseMetaData md = null;
	String str = null;
	boolean flag = false;

	try{
		DataSource ds = (DataSource)envCtx.lookup(name);
		conn = ds.getConnection();
		md = conn.getMetaData();

%>
		<br/><br/>
		<h2>JNDI Name : <SPAN style='font-weight:bold'><%=(contextName + "/" + name)%></SPAN></h2>
		<%
		if(showsUrl){ %>
			<ul>
				<li>URL : <%= md.getURL() %></li> 
				<li>User Name : <%= md.getUserName() %></li>
			</ul>
		<%
		} %>
		 
		<br/>
		<h3>Database Properties</h3>
		<TABLE border='1' width='1000' cellspacing='0' cellpadding='1'>
		<TR>
			<TH>Property</TH>
			<TH>Method</TH>
			<TH>Value</TH>
		</TR>
		<TR>
			<TD valign='top' nowrap>Database Product Name</TD>
			<TD valign='top' nowrap>getDatabaseProductName()</TD>
			<TD valign='top'><%=md.getDatabaseProductName()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap'>Database Product Version</TD>
			<TD valign='top' nowrap>getDatabaseProductVersion()</TD>
			<TD valign='top'><%=md.getDatabaseProductVersion()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Database Connection URL</TD>
			<TD valign='top' nowrap>getURL()</TD>
			<TD valign='top'><%=md.getURL()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Database User</TD>
			<TD valign='top' nowrap>getUserName()</TD>
			<TD valign='top'><%=md.getUserName()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Connection Waring</TD>
			<TD valign='top' nowrap>Connection.getWarnings()</TD>
			<%
			java.sql.SQLWarning warning = conn.getWarnings();
			if(warning != null){
			%>
				<TD valign='top'>
				1. <%=warning.getMessage()%><BR>
				<%
				for(int i = 2; ; i++){
					warning = warning.getNextWarning();
					if(warning == null) break;
					else out.println("" + i + ". " + warning.getMessage() + "<BR>");
				}
				%>
				</TD>
			<%
			}
			else{
			%>
				<TD valign='top'>&nbsp;</TD>
			<%
			}
			%>
		</TR>
		<TR>
			<TD valign='top' nowrap>Driver Name</TD>
			<TD valign='top' nowrap>getDriverName()</TD>
			<TD valign='top'><%=md.getDriverName()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Driver Version</TD>
			<TD valign='top' nowrap>getDriverVersion()</TD>
			<TD valign='top'><%=md.getDriverVersion()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>ANSI92 Entry Level SQL Grammar Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsANSI92EntryLevelSQL()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>ANSI92 Intermediate SQL Grammar Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsANSI92IntermediateSQL()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>ANSI92 Full SQL Grammar Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsANSI92FullSQL()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Mixed Case Identifier Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsMixedCaseIdentifiers()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Mixed Case Quoted Identifier Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsMixedCaseQuotedIdentifiers()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Column Aliasing Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsColumnAliasing()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Non-nullable Column Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsNonNullableColumns()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top'>Catalog Name Support in Table Definition Statement</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsCatalogsInTableDefinitions()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top'>Catalog Name Support in Data Manipulation Statement</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsCatalogsInDataManipulation()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Unrelated ORDER BY Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsOrderByUnrelated()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Expression Support in ORDER BY</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsExpressionsInOrderBy()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>GROUP BY Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsGroupBy()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Unrelated GROUP BY Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsGroupByUnrelated()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top'>Subquery Support in Quantified Expression</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsSubqueriesInQuantifieds()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top'>Subquery Support in Comparison Expression</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsSubqueriesInComparisons()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top'>Subquery Support in IN Statement</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsSubqueriesInIns()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>SELECT FOR UPDATE Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsSelectForUpdate()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Outer Join Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsOuterJoins()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Limited Outer Join Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsLimitedOuterJoins()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>		
		<TR>
			<TD valign='top' nowrap>Full Nested Outer Join Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsFullOuterJoins()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top'>UNION Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsUnion()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top'>UNION ALL Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsUnionAll()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Transaction Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.supportsTransactions()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Multiple Transaction Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsMultipleTransactions()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		
		<TR>
			<TD valign='top' nowrap>Read Committed Transaction Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_READ_COMMITTED)); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Read Uncommitted Transaction Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_READ_UNCOMMITTED)); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Repeatable Read Transaction Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_REPEATABLE_READ)); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Serializable Transaction Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsTransactionIsolationLevel(java.sql.Connection.TRANSACTION_SERIALIZABLE)); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		
		<TR>
			<TD valign='top' nowrap>Savepoint Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsSavepoints()); }
			catch(Throwable ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Stored Procedure Call Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsStoredProcedures()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Batch Updates Support</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.supportsBatchUpdates()); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap><code>ResultSet.rowInserted</code> Support with Forward Only Cursor</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.insertsAreDetected(ResultSet.TYPE_FORWARD_ONLY)); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap><code>ResultSet.rowUpdated</code> Support with Forward Only Cursor</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.updatesAreDetected(ResultSet.TYPE_FORWARD_ONLY)); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap><code>ResultSet.rowDeleted</code> Support with Forward Only Cursor</TD>
			<td>&nbsp;</td>
			<TD valign='top'>
			<%
			try{ out.println(md.deletesAreDetected(ResultSet.TYPE_FORWARD_ONLY)); }
			catch(Exception ex){ out.println("N/A"); }
			%>
			</TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Separator btw. Catalog and Table</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getCatalogSeparator()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Vender Term for Procedure</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getProcedureTerm()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Default Transaction Isolation Level</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=conn.getTransactionIsolation()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Extra Name Characters</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getExtraNameCharacters()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Ecape for Wildcard</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getSearchStringEscape()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Identifier Quote String</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getIdentifierQuoteString()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>SQL Keywords (except SQL92 Keywords)</TD>
			<td>&nbsp;</td>
			<%
			try{
				str = md.getSQLKeywords().replace(',', ' ');
			%>
				<TD valign='top'><%=str%></TD>
			<%
			}
			catch(Exception ex){
			%>
				<TD valign='top'>N/A</TD>
			<%
			}
			%>
		</TR>
		<TR>
			<TD valign='top' nowrap>System Functions</TD>
			<td>&nbsp;</td>
			<%
			try{
				str = md.getSystemFunctions().replace(',', ' ');
			%>
				<TD valign='top'><%=str%></TD>
			<%
			}
			catch(Exception ex){
			%>
				<TD valign='top'>N/A</TD>
			<%
			}
			%>
		</TR>
		<TR>
			<TD valign='top' nowrap>Numeric Functions</TD>
			<td>&nbsp;</td>
			<%
			try{
				str = md.getNumericFunctions().replace(',', ' ');
			%>
				<TD valign='top'><%=str%></TD>
			<%
			}
			catch(Exception ex){
			%>
				<TD valign='top'>N/A</TD>
			<%
			}
			%>
		</TR>
		<TR>
			<TD valign='top' nowrap>String Functions</TD>
			<td>&nbsp;</td>
			<%
			try{
				str = md.getStringFunctions().replace(',', ' ');
			%>
				<TD valign='top'><%=str%></TD>
			<%
			}
			catch(Exception ex){
			%>
				<TD valign='top'>N/A</TD>
			<%
			}
			%>
		</TR>
		<TR>
			<TD valign='top' nowrap>Date/Time Functions</TD>
			<td>&nbsp;</td>
			<%
			try{
				str = md.getTimeDateFunctions().replace(',', ' ');
			%>
				<TD valign='top'><%=str%></TD>
			<%
			}
			catch(Exception ex){
			%>
				<TD valign='top'>N/A</TD>
			<%
			}
			%>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Connections</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=(md.getMaxConnections() == 0) ? "No Limit or Unknown" : "" + md.getMaxConnections()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Concurrent Active Statement</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=(md.getMaxStatements() == 0) ? "No Limit or Unknown" : "" + md.getMaxStatements()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Length of Catalog Name</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxCatalogNameLength()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Length of Table Name</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxTableNameLength()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Length of Column Name</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxColumnNameLength()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Length of User Name</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxUserNameLength()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Length of Character Literal</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxCharLiteralLength()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Length of an SQL Statement</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxStatementLength()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Columns in a Table</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxColumnsInTable()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Columns in an Index</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxColumnsInIndex()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Tables in a SELECT Statement</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxTablesInSelect()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Columns in a SELECT List</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxColumnsInSelect()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Columns in an ORDER BY Clause</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxColumnsInOrderBy()%></TD>
		</TR>
		<TR>
			<TD valign='top' nowrap>Max. Number of Columns in a GROUP BY Clause</TD>
			<td>&nbsp;</td>
			<TD valign='top'><%=md.getMaxColumnsInGroupBy()%></TD>
		</TR>
		</TABLE>	
		
		<BR>
		<a href='#pageTop'>top</a>	
		
		
		
		
		<%
		if(md.getDatabaseProductName() != null 
		   && md.getDatabaseProductName().toLowerCase().contains("oracle")
		   && false){
					
			oracle.jdbc.pool.OracleDataSource dsOracle = ds.unwrap(oracle.jdbc.pool.OracleDataSource.class);
			
			java.util.Properties connProps = dsOracle.getConnectionProperties();
			List connPropskeys = new ArrayList(connProps.keySet());
			Collections.sort(connPropskeys); 	%>
			
			<h3>Connection Properties</h3>
			
			<table border='1' width='800' cellspacing='0' cellpadding='1'>
			<tr>
				<th>Property<th>
				<th>Value</th>
			</tr>
			
			<%
			for(Object key : connPropskeys){ %>
				<tr>
					<td><%= (String)key %></td>
					<td><%= connProps.getProperty((String)key) %></td>
				</tr>
			<%
			} %>
			
			</table>
		
		<%
		} %>			
		
<%
	}
	catch(NamingException ex){ %>
		<P>Can't get context for the given resource reference name, <B><%=name%></B><BR>
		Check the web.xml file or JNDI settings of your application server.
		</P>
		<P><B>detail :</B><BR>
<%
		ex.printStackTrace(new java.io.PrintWriter(out));
	}
	catch(SQLException ex){ %>
		<P>Can't get connections from the defined database.<BR>
		Check the JNDI settings of your application server or status of the database to connect.
		</P>
		<P><B>detail :</B><BR>
<%
		ex.printStackTrace(new java.io.PrintWriter(out));
	}
	catch(Exception ex){ %>
		<P>There's an error!</P>
		<P><B>detail :</B><BR>
<%
		ex.printStackTrace(new java.io.PrintWriter(out));
	}
	finally{
		if(rs != null){
			try{ rs.close(); }
			catch(Exception ex){}
		}
		if(stmt != null){
			try{ stmt.close(); }
			catch(Exception ex){}
		}
		if(conn != null){
			try{ conn.close(); }
			catch(Exception ex){}
		}
	}
} %>

<br><br>
</div>
</body>
</html>