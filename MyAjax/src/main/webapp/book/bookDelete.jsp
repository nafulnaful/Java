<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%//contentType을 "application/json" 유형으로 설정하자
	String isbn=request.getParameter("isbn");
	System.out.println(isbn);
%>
<jsp:useBean id="bookDao" class="ajax.book.BookDAO" scope="session"/>
<%
	int n=bookDao.deleteBook(isbn);
%>
{
	"result":"<%=n %>"
}