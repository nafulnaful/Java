<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="net.sf.json.*, ajax.book.*, java.util.*"%>
    
    <%
    BookDAO bookDao=new BookDAO();
    List<BookDTO> arr=bookDao.getAllBook();
    
    JSONArray jsonArr=JSONArray.fromObject(arr);
    //fromObject(arr) : static메소드
    //ArrayList를 JSONArray유형으로 변환해줌
    %>
    <%=jsonArr.toString() %>
