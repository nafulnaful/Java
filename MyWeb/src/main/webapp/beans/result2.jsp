<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cbean" class="beans.count.CountBean"
 scope="request"/>
<h1>result2.jsp</h1>
<h2 style="color:blue">
<jsp:getProperty property="count" name="cbean"/>  
</h2>
<a href="result3.jsp">result3.jsp로 이동</a>