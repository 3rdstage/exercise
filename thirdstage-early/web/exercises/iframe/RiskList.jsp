<%@page language="java" session="true" autoFlush="true" isThreadSafe="true"%>
<%@page contentType="text/html;charset=euc-kr"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
	<head>
		<title></title>
		<STYLE type="text/css">
/* page scope style */
			BODY {background:#FFFFFF}
			H1 {font-family:Verdana, 굴림; font-size:14pt; font-weight:bold; color:navy}
			H2 {font-family:Verdana, 굴림; font-size:13pt; font-weight:bold; color:navy}
			H3 {font-family:Verdana, 굴림; font-size:12pt; font-weight:bold; color:navy}
			H4 {font-family:Verdana, 굴림; font-size:11pt; font-weight:bold; color:navy}
			H5 {font-family:Verdana, 굴림; font-size:10pt; font-weight:bold; color:navy}
			P {font-family:Verdana, 돋움; font-size:9pt; font-weight:normal; color:black}
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
		</STYLE>
	</head>
	<body>
		<table class="detail" border='0' width='800' cellspacing="1" cellpadding="2">
			<tr>
				<th widdth="150" nowrap>프로젝트</th>
				<th nowrap>검토유형</th>
				<th nowrap>단계</th>
				<th width="150" nowrap>검토제목</th>
				<th nowrap>결과 식별자</th>
				<th nowrap>결과 유형</th>
				<th width="200" nowrap>부적합 내용</th>
				<th nowrap>조치권고일</th>
				<th nowrap>조치담당자</th>
				<th nowrap>조치예정일</th>	
				<th nowrap>조치완료일</th>
				<th nowrap>조치승인일</th>
				<th nowrap>상태</th>
			</tr>
			<tr>
				<td width="150">롯데마트 ERP 구축</td>
				<td>아키텍쳐 점검</td>
				<td>전개</td>
				<td width="150">[품질점검]아키텍쳐 2차 점검</td>
				<td><a href="JavaScript:parent.frames['detailFrm'].location.replace('./RiskDetail.jsp')">AQA_20050131_001</a></td>
				<td>필수</td>
				<td width="200">Pseudo-Swap 설정 해제 및 Dynamic Buffer Cache 사용</td>
				<td>20050131</td>
				<td>이운석</td>
				<td>2005.01.31</td>
				<td>2005.01.24</td>
				<td>2005.01.31</td>
				<td>조치완료</td>
			</tr>
			<tr>
				<td width="100">롯데마트 ERP 구축</td>
				<td>아키텍쳐 점검</td>
				<td>전개</td>
				<td>[품질점검]아키텍쳐 2차 점검</td>
				<td><a href="JavaScript:parent.frames['detailFrm'].location.replace('../../etc/BlankPage.html')">AQA_20050131_002</a></td>
				<td>필수</td>
				<td width="200">SAP DB서버 메모리 부족현상 해소 – SAP 패키지 자원 누수여부 조사</td>
				<td>20050131</td>
				<td>이운석</td>
				<td>2005.01.31</td>
				<td>2005.01.31</td>
				<td>2005.01.31</td>
				<td>조치완료</td>
			</tr>
			<tr>
				<td width="100">롯데마트 ERP 구축</td>
				<td>관리점검</td>
				<td>구축</td>
				<td>[품질점검]구축단계(관리, 범위점검)</td>
				<td><a href="JavaScript:void(0)">MQA_20041229_001</a></td>
				<td>필수</td>
				<td width="200">[범위관리] 비기능요구사항 미정의/범위관련 문서 일관성 미흡 및 고객 미합의</td>
				<td>20041224</td>
				<td>이승범</td>
				<td>2005.01.19</td>
				<td>2005.01.21</td>
				<td>2005.01.31</td>
				<td>조치완료</td>
			</tr>
			<tr>
				<td width="100">LG전자 러닝넷시스템 재구축</td>
				<td>아키텍쳐 점검</td>
				<td>설계</td>
				<td>전사 품질점검(아키텍쳐1차)</td>
				<td><a href="JavaScript:void(0)">AQA_20041220_001</a></td>
				<td>필수</td>
				<td width="200">성능관련 요구사항 정의</td>
				<td>2004.12.13</td>
				<td>손관수</td>
				<td>2004.12.13</td>
				<td>2004.12.13</td>
				<td>2005.01.11</td>
				<td>조치완료</td>
			</tr>
			<tr>
				<td width="100">LG전자 러닝넷시스템 재구축</td>
				<td>아키텍쳐 점검</td>
				<td>시험</td>
				<td>전사품질점검(아키텍쳐2차)</td>
				<td><a href="JavaScript:void(0)">AQA_20050127_001</a></td>
				<td>필수</td>
				<td width="200">메모리 관련 커널 파라메터 값 변경</td>
				<td>2005.02.04</td>
				<td>손관수</td>
				<td>2005.01.27</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>계획완료</td>
			</tr>
		</table>
	</body>
	
</html>
