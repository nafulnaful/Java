<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*"%>
<%-- 
wW6Bg4yxyq3bryvFeIJi
5jyxHCUaT4
 --%>
 
 <%
 	String query=request.getParameter("query");
 	String display=request.getParameter("display");
 	String start=request.getParameter("start");
 
 if(query==null){
	 query="Ajax";//기본검색어
 }
 
 if(display==null){
	 display="10";//한 페이지 당 보여줄 도서 개수( 디폴트 : 10)
 }
 
 if(start==null){
	 start="1";//시작 페이지를 1페이지로 지정
 }
 String sort="sim";//정렬방식(유사도순으로): sim(유사도) date(출간일) count(판매량)
 
 	BookNaverProxy proxy=new BookNaverProxy();
 	String data=proxy.getData(query, display, start, sort);
 	System.out.println(data);
 	
 %>
 <%=data%>