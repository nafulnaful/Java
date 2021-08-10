<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bookDao" class="ajax.book.BookDAO" scope="session"/>

<jsp:useBean id="bookDto" class="ajax.book.BookDTO" scope="page"/>
<jsp:setProperty property="*" name="bookDto"/>
<%--파라미터 데이터들을 bookDto객체에 모두 setting--%>
<%
	int n=bookDao.updateBook(bookDto);
%>
<result>
<%=n %>
</result>