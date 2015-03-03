<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
response.setContentType("application/vnd.ms-excel;charset=EUC-KR");
response.setHeader("Content-Disposition", "attachment; filename=SimpleCSV.csv");

out.println("i, i^2, i^3");

for(int i = 0; i < 100; i++) out.println("" + i + ", " + i*i + ", " + i*i*i);

%>

