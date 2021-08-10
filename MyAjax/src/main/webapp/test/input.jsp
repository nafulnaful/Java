<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8" import="test.*, java.util.*,net.sf.json.*"%>
<%
String data = MyUtil.getRequestBody(request);
System.out.println(data);

JSONObject obj = JSONObject.fromObject(data);

String title = obj.getString("title");
String msg = obj.getString("msg");
System.out.println(title + "///" + msg);
if (title == null)
	return; 

//3. MemoVO에 담기
MemoVO memo = new MemoVO(0, title, msg, null);

//4. MemoDAO생성 insertMemo()호출
MemoDAO dao = new MemoDAO();

boolean b = dao.insertMemo(memo);
int n = (b) ? 1 : 0;
%>
{"result":<%=n%>}
