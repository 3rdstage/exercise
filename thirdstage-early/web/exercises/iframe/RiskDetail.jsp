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
				<th width="15%"/>
				<th width="35%"/>
				<th width="15%"/>
				<th width="35%"/>
			</tr>
			<tr>
				<td class="item">프로젝트</td>
				<td>롯데마트 ERP 구축 프로젝트</td>
				<td class="item">프로젝트 PM</td>
				<td>이승범 차장</td>
			</tr>
			<tr>
				<td class="item">검토 유형</td>
				<td>아키텍쳐 점검</td>
				<td class="item">단계</td>
				<td>전개</td>
			</tr>
			<tr>
				<td class="item">검토 제목</td>
				<td colspan="3">[픔질점검]아키텍쳐 2차 점검</td>
			</tr>
			<tr>
				<td class="item">부적합 식별자</td>
				<td>AQA_20050131_001</td>
				<td class="item">부적합 내용</td>
				<td>Pseudo-Swap 설정 해제 및 Dynamic Buffer Cache 사용</td>
			</tr>
			<tr>
				<td class="item">구분</td>
				<td>필수</td>
				<td class="item">상태</td>
				<td>부분완료</td>
			</tr>

			
			<tr>
				<td class="item">조치 권고일</td>
				<td colspan='3'>2005.01.31</td>
			</tr>
			<tr>
					
				<td class="item">조치 예정일</td>
				<td>2005.01.31</td>
				<td class="item">조치 담당자</td>
				<td>이운석</td>
			</tr>
			<tr>
				<td class="item">조치 완료일</td>
				<td>2005.01.24</td>
				<td class="item">검토일(승인일?)</td>
				<td>2005.01.31</td>
			</tr>
			
			<tr>
				<td class="item">개선 사항</td>
				<td colspan='3'>실제 SAP DB서버는 SAP 엔진 및 DBMS에 의해 많은 메모리가 사용되고 있으며 이에
					따라 메모리 부족현상이 나타나고 있으며 이러한 메모리 부족현상을 해소하기 위해
					서라도 Pseudo-Swap 영역의 해제 및 Dynamic Buffer Cache를 사용해야 한다.
				</td>
			</tr>
			<tr>
				<td class="item">원인 분석</td>
				<td colspan='3'>기본적으로 HPUX는 Pseudo-Swap을 사용하는 것으로 파라미터가 설정되어 있으나
					(swapmem_on=1) 실제 이러한 메모리 스왑을 통한 성능상의 이점을 얻기는 어려우며,
					오히려 물리적 메모리의 낭비를 초래하게 된다.
					또한 Dynamic Buffer Cache를 사용하지 않고(bufpages=0, nbuf=0) Static Buffer
					Cache를 사용하게 되면 File I/O를 사용하지 않을 때 남은 메모리를 프로세스에 반
					환하지 못하며, 반대로 대용량 File I/O가 필요할 경우 Buffer Cache가 모자라게
					되면 I/O성능이 저하되는 문제점이 있다.
				</td>
			</tr>
			<tr>	
				<td class="item">조치 내역</td>
				<td colspan='3'>기존 bufpages와 nbuf는 0으로 셋팅되어 있어서 수정안했고, swapmem_on만 수정완료</td>
			</tr>
			<tr>
				<td class="item">확인 내용</td>
				<td colspan='3'>확인완료</td>
			</tr>
		</table>
	</body>
</html>

