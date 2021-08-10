<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*, java.util.*, net.sf.json.*"%>
<% 
	MemoDAO dao=new MemoDAO();
	List<MemoVO> arr=dao.selectMemoAll();
	
	JSONArray jsonArr=JSONArray.fromObject(arr);
	out.println(jsonArr.toString());
%>    
