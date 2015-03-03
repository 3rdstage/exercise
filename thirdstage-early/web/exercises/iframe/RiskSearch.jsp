<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
  

<f:view locale="ko">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=euc-kr"/>
		<meta http-equiv="Expires" content="Thu, 10 Nov 1999 24:00:00 GMT"/>
		<meta http-equiv="Pragma" content="No-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-store"/>
		<meta name="Author" content="Sang-Moon Oh"/> 
		<title>Risk Search</title>
		
		<script type="text/javascript" language="JavaScript">
			// page scope script
			function initPage(){
			}

			function checkToSubmit(){
			return true
			}
		</script>

		<style type="text/css">
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

			<h3>전사 시정조치사항 모니터링</h3>

			<h:form>
			<table class="search" width="800" border="0" cellspacing="1" cellpadding="2">
				<tr>
					<th width="15%"/>
					<th width="35%"/>
					<th width="15%"/>
					<th width="35%"/>
				</tr>
				<tr>
					<td class="search">검토 유형</td>
					<td class="search" colspan="3">
						<input type="checkbox" value="mgmtAudit">관리 점검</input>
						<input type="checkbox" value="archAudit">아키텍쳐 점검</input>
						<input type="checkbox" value="testAudit">시험 진단</input>
						
						<%--
						<h:selectManyCheckbox id="taskType" required="true">
						<f:selectItem itemValue="mgmtAudit" itemLabel="관리 점검"/>
						<f:selectItem itemValue="archAudit" itemLabel="아키텍쳐 점검"/>
						<f:selectItem itemValue="testingAudit" itemLabel="시험 진단"/>
						</h:selectManyCheckbox>
						--%>
						<%--
						<h:selectManyListbox id="taskType" required="true">
						<f:selectItem itemValue="mgmtAudit" itemLabel="관리 점검"/>
						<f:selectItem itemValue="archAudit" itemLabel="아키텍쳐 점검"/>
						<f:selectItem itemValue="testingAudit" itemLabel="시험 진단"/>
						</h:selectManyListbox>
						--%>
					</td>
					
				</tr>
				<tr>
					<td class="search">검토 기간</td>
					<td class="search" colspan='3'><h:inputText id="startYear" size="5" maxlength="4" >
						<f:validateLongRange minimum="0" maximum="9999"/>
						</h:inputText>년
						<h:inputText id="startMonth" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="12"/>
						</h:inputText>월
						<h:inputText id="startDay" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="31"/>
						</h:inputText>일 ~ 
						<h:inputText id="endYear" size="5" maxlength="4" >
						<f:validateLongRange minimum="0" maximum="9999"/>
						</h:inputText>년
						<h:inputText id="endMonth" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="12"/>
						</h:inputText>월
						<h:inputText id="endDay" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="31"/>
						</h:inputText>일
					</td>
				</tr>
				<tr>
					<td class="search">조치 권고일</td>
					<td class="search" colspan='3'><h:inputText id="startYear2" size="5" maxlength="4" >
						<f:validateLongRange minimum="0" maximum="9999"/>
						</h:inputText>년
						<h:inputText id="startMonth2" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="12"/>
						</h:inputText>월
						<h:inputText id="startDay2" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="31"/>
						</h:inputText>일 ~ 
						<h:inputText id="endYear2" size="5" maxlength="4" >
						<f:validateLongRange minimum="0" maximum="9999"/>
						</h:inputText>년
						<h:inputText id="endMonth2" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="12"/>
						</h:inputText>월
						<h:inputText id="endDay2" size="3" maxlength="2" >
						<f:validateLongRange minimum="1" maximum="31"/>
						</h:inputText>일
					</td>
				</tr>
				<tr>
					<td class="search">프로젝트명</td>
					<td class="search"><h:inputText id="projectName" size="20"/></td>
					<td class="search">점검자</td>
					<td class="search"><h:inputText id="auditor" size="20"/></td>
				</tr>
				<tr>
					<td class="search">상태</td>
					<td class="search" colspan="3">
						<input type="checkbox" value="excludesCompleted">미완료 시정조치사항만 (최종완료 제외?)</input>
					</td>
			</tr>
    
			</table>
	
			<table width="800" border="0" cellpadding="4">
				<tr>
					<td align="right">
					<h:commandButton action="search" value="Search"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandButton action="excel" value="Excel"/></td>
				</tr>
			</table>
			</h:form>  
			

			<iframe src="./RiskList.jsp" name="listFrm" frameborder='1' width='1150' height="200" marginheight="0" marginwidth="0" scrolling="auto">
			</iframe>
			
			<br><br>
			
			<iframe src="./RiskDetail.faces" name="detailFrm" frameborder='0' width='805' height='400' marginheight="0" marginwidth="0" scrolling="no">
			</iframe>
			
			<br/><br/>
			
			<a href='#pageTop'>top</a>
			<br/><br/>
		</div>
	</body>
</html>
</f:view>
