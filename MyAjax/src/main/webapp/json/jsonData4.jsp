<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*,java.util.*"%>
    
<jsp:useBean id="bookDao" class="ajax.book.BookDAO" scope="session"/>
<%
	List<BookDTO> arr=bookDao.getAllBook();
%>
{
	"books":[
		<% 
		if(arr!=null){
			int i=0;
			for(BookDTO b:arr){
				request.setAttribute("book",b);
		%>
		{
			"isbn":"${book.isbn}",
			"title":"${book.title}",
			"publish":"${book.publish}",
			"published":"${book.published}",
			"price":"${book.price}",
			"bimage":"${book.bimage}"
		}
		<% 
			if(i<arr.size()-1){
				out.println(",");
			}
			i++;
			
			}//for=========================
		}//if========================================
		%>
		
	]
}
    