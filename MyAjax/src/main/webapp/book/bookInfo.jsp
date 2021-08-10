<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bookDao" class="ajax.book.BookDAO" scope="session"/>
<%
	String isbn=request.getParameter("isbn");
	ajax.book.BookDTO book=bookDao.getBookInfo(isbn);
	
	request.setAttribute("book", book);
%>
<book>
	<isbn>${book.isbn}</isbn>
	<title>${book.title}</title>
	<publish>${book.publish}</publish>
	<published>${book.published}</published>
	<price>${book.price}</price>
	<bimage>${book.bimage}</bimage>
</book>