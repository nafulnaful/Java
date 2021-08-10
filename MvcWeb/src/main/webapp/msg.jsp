<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	String msg=(String)request.getAttribute("message");
	String loc=(String)request.getAttribute("loc");

<script>
	alert('<%=msg%>');
	location.href='<%=loc%>';
</script>
--%>
<script>
	alert('${message}');
	location.href='${loc}';
</script>

<%-- 
JSTL : Tag Library를 이용하여 제어문을 작성

--%>