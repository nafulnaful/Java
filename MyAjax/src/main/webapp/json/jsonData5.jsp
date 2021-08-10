<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="net.sf.json.*"%>
<%--
[1] JSON라이브러리 다운로드
   https://sourceforge.net/projects/json-lib/files/json-lib/json-lib-2.4/
   https://sheplim.tistory.com/entry/JSON-lib
   [2] 프로젝트/WEB-INF/lib 아래 6개의 jar파일을 붙여넣는다.
   [3] import="net.sf.json.*"
   
   Java Bean객체를 JSON형태로 변환해주는 라이브러리
--%>
<%
		//JSONObject obj=JSONObject.fromObject(bookDto)
		//1.객체 유형
		JSONObject obj=new JSONObject();
		obj.put("isbn", "123123");
		obj.put("title", "JSON라이브러리 활용");
		obj.put("price", "25000");
		obj.put("publish", "에어콘 출판사");
		obj.put("published", "21-05-11");
		obj.put("bimage", "e.jpg");
%>
<%=obj.toString()%>