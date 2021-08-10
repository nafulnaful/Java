<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.naming.*,javax.sql.*, java.sql.*"  %>
<% 
//xml형식으로 응답하려면 contentType을 text/xml로 변경해야 한다.
	response.setHeader("Cache-Control", "no-cache");
	//메모리 캐시 사용 안하도록

	String phone=request.getParameter("phone");

	Context ctx=new InitialContext();
	DataSource ds=(DataSource)ctx.lookup("java:comp/env/myoracle/tis_shop");
	Connection con=ds.getConnection();
	
	String sql="select * from pizza_user where phone=?";
	
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1,phone);
	
	ResultSet rs=ps.executeQuery();
	String idx="0", name="", addr="";
	while(rs.next()){
		idx=rs.getString("idx");
		name=rs.getString("name");
		addr=rs.getString("addr");
	}
	rs.close();
	ps.close();
	con.close();
%>    
<result>
	<idx><%=idx %></idx>
	<name><%=name%></name>
	<addr><%=addr %></addr>
	<phone><%=phone%></phone>
</result>







