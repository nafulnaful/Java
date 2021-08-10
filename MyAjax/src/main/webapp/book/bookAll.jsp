<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ajax.book.*,java.util.*,java.text.*" %>
    
<jsp:useBean id="bookDao" class="ajax.book.BookDAO" scope="session"/>
<%
	List<BookDTO> arr=bookDao.getAllBook();
%>
<table class="table table-hover table-bordered">
<% 
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	DecimalFormat df=new DecimalFormat("###,###");

	if(arr!=null){
		for(BookDTO b:arr){
%>
	<tr>
		<td width="20%"><%=b.getTitle()%></td>
		<td width="20%"><%=b.getPublish() %></td>
		<td width="20%"><%=df.format(b.getPrice()) %></td>
		<td width="20%"><%=sdf.format(b.getPublished()) %></td>
		<td width="20%">
		<a href="#book_data" onclick="goEdit('<%=b.getIsbn()%>')">수정</a>|
		<a href="#book_data" onclick="goDel('<%=b.getIsbn()%>')">삭제</a>
		</td>
	</tr>
<% 		}//for-----------------

	}//if-------------
%>	
</table>