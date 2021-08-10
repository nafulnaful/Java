<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<result>
		<c:forEach var="d" items="${downCgList}">
			<category upCode="${upCode}">
				<downCg_code>${d.downCg_code}</downCg_code>
				<downCg_name>${d.downCg_name}</downCg_name>
			</category>
		</c:forEach>
</result>